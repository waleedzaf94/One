package com.clarity.one.api;

import com.clarity.one.model.geocode.ReverseGeocodeResp;
import com.clarity.one.model.instagram.MediaListResp;
import com.clarity.one.model.instagram.MediaResp;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Waleed on 7/24/2015.
 */
public class ApiClient {

    private static InstagramInterface mInstagramInterface;
    private static MapsInterface mapsInterface;

    public static InstagramInterface getInstagramApiClient(){
        if (mInstagramInterface == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://api.instagram.com/v1")
                    .build();

            mInstagramInterface = restAdapter.create(InstagramInterface.class);
        }

        return mInstagramInterface;
    }

    public static MapsInterface getMapsClient(){
        if (mapsInterface == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://maps.googleapis.com/maps/api")
                    .build();

            mapsInterface = restAdapter.create(MapsInterface.class);
        }

        return mapsInterface;
    }

    public interface InstagramInterface{
        @GET("/users/{user-id}/media/recent")
        void getUserMedia(@Path("user-id") String userID, @Query("count") int count, @Query("access_token") String accessToken, Callback<MediaListResp> callback);

        @GET("/users/{user-id}/media/recent")
        MediaListResp getUserMediaSync(@Path("user-id") String userId, @Query("count") int count, @Query("access_token") String accessToken);

        @GET("/media/{id}")
        void getMediaObject(@Path("id") String mediaId, @Query("access_token") String accessToken, Callback<MediaResp> callback);

        @GET("/media/{id}")
        MediaResp getMediaObjectSync(@Path("id") String mediaId, @Query("access_token") String accessToken);

    }

    public interface MapsInterface{

        @GET("/geocode/json")
        void reverseGeocode(@Query("latlng") String coords, @Query("key") String apiKey, @Query("result_type") String resultType, Callback<ReverseGeocodeResp> callback);

        @GET("/geocode/json")
        ReverseGeocodeResp reverseGeocodeSync(@Query("latlng") String coords, @Query("result_type") String resultType, @Query("key") String apiKey);
    }

}
