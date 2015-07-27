package com.clarity.one.fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clarity.one.R;
import com.clarity.one.adapters.PopularAdapter;
import com.clarity.one.api.ApiClient;
import com.clarity.one.app.Constants;
import com.clarity.one.model.Influencer;
import com.clarity.one.model.MediaPost;
import com.clarity.one.model.geocode.AddressComponent;
import com.clarity.one.model.geocode.Result;
import com.clarity.one.model.geocode.ReverseGeocodeResp;
import com.clarity.one.model.instagram.Location;
import com.clarity.one.model.instagram.MediaResp;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import retrofit.RetrofitError;

/**
 * Created by Waleed on 7/15/2015.
 */
public class PopularFragment extends Fragment {

    private String userId;
    private Influencer influencer;

    private Set<String> topMedia;
    private List<MediaPost> mediaPosts = new ArrayList<>();

    private RecyclerView mRecyclerView;

    private PopularAdapter mAdapter;

    public PopularFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_influencer_popular, container, false);

        userId = getArguments().getString("ActivityUserId");
        influencer = (Influencer) getArguments().getSerializable("InfluencerObject");

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.popularRecycler);

        topMedia = influencer.getTopMedia();
        new IGDownloader().execute();

        return rootView;
    }

    private void setAdapter(){
        mAdapter = new PopularAdapter(getActivity(), mediaPosts);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    private String getCC(List<Result> results){
        for (int i=0; i<results.size(); i++){ //Go through each Result block
            ArrayList<AddressComponent> comps = (ArrayList<AddressComponent>) results.get(i).getAddressComponents();
            for (int j=0; j<comps.size(); j++){ //Go through each address component in one Result
                ArrayList<String> types = (ArrayList<String>) comps.get(j).getTypes();
                String nm = comps.get(j).getLongName();
                for (int k=0; k<types.size(); k++){ //Go through each of the types an address component is tagged with
                    if (types.get(k).equals("locality")){
                        return nm;
                    }
                    if (types.get(k).equals("country")){
                        return nm;
                    }
                }

            }
        }
        return "N/A";
    }

    class IGDownloader extends AsyncTask<Void, Void, Void>{

        public IGDownloader(){

        }

        protected Void doInBackground(Void... params){
            downloadMedia();
            return null;
        }

        private void downloadMedia(){
            //for (String mediaId: topMedia){
            Iterator<String> iterator = topMedia.iterator();
            for (int i=0; i<Math.min(5, topMedia.size()); i++){
                String mediaId = iterator.next();
                MediaResp mediaResp;
                try {
                    mediaResp = ApiClient.getInstagramApiClient().getMediaObjectSync(mediaId, Constants.accessToken);
                    MediaPost mediaPost = new MediaPost();
                    String caption = mediaResp.getData().getCaption().getText();
                    int comments = mediaResp.getData().getComments().getCount();
                    int likes = mediaResp.getData().getLikes().getCount();
                    String locName = mediaResp.getData().getLocation().getName();
                    double lat = mediaResp.getData().getLocation().getLatitude();
                    double lng = mediaResp.getData().getLocation().getLongitude();
                    String mId = mediaResp.getData().getId();
                    String pic = mediaResp.getData().getImages().getStandard_resolution().getUrl();

                    if (caption != null) mediaPost.setCaption(caption);
                    mediaPost.setComments(comments);
                    mediaPost.setLikeCount(likes);
                    if (locName != null) mediaPost.setLocation(locName);
                    else{
                        try {
                            ReverseGeocodeResp resp = ApiClient.getMapsClient().reverseGeocodeSync(lat + "," + lng, "locality", Constants.mapsApiKey);
                            if (resp.getStatus().equals("OK")) {
                                List<Result> results = resp.getResults();
                                String loc = getCC(results);
                                if (!loc.equals("N/A")){
                                    mediaPost.setLocation(loc);
                                }
                            } else if (resp.getStatus().equals("OVER_QUERY_LIMIT")){

                            }
                        } catch (Exception e){
                            Log.e("ReverseGeocodingError", e.getMessage());
                        }
                    }
                    mediaPost.setMediaId(mId);
                    mediaPost.setUrl(pic);
                    mediaPost.setPicture(downloadImage(pic));
                    //new ImageDownloader(pic, mediaPost).execute();

                    mediaPosts.add(mediaPost);
                    //mediaPost.setPicture;
                } catch (RetrofitError retrofitError){
                    Log.e("RetrofitError", retrofitError.getMessage());
                } catch (Exception e){
                    Log.e("Error downloading media", e.getMessage());
                }
            }
        }

        protected void onPostExecute(Void params){
            setAdapter();
        }

        private Drawable downloadImage(String url1){
            URL url;
            InputStream in;
            BufferedInputStream buf;

            try{
                url = new URL(url1);
                in = url.openStream();

                buf = new BufferedInputStream(in);

                Bitmap bmap = BitmapFactory.decodeStream(buf);
                if (in != null){
                    in.close();
                }
                if (buf != null){
                    buf.close();
                }
                return new BitmapDrawable(bmap);
            } catch (Exception e){
                Log.e("Error downloading image", e.toString());
            }
            return null;
        }

    }

}
