package com.clarity.one.app;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.clarity.one.R;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class LoginActivity extends Activity {

    private TextView loginTitle;
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private RelativeLayout loginBackground;
    private ImageButton loginInstagramLogo;

    private static final String authURL="https://api.instagram.com/oauth/authorize/";
    private static final String tokenURL="https://api.instagram.com/oauth/access_token";
    public static final String apiURL="https://api.instagram.com/v1";
    public static String callbackURL="http://securityfinders.com.au/authenticate";
    private static String authURLString=authURL+"?client_id="+Constants.clientId+"&redirect_uri="+callbackURL+"&response_type=code&display=touch&scope=likes+comments+relationships";
    private static String tokenURLString=tokenURL+"?client_id="+Constants.clientId+"&client_secret"+Constants.clientSecret+"&redirect_uri="+callbackURL+"&grant_type=authorization_code";
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTitle = (TextView) findViewById(R.id.loginTitle);
        loginEmail = (EditText) findViewById(R.id.loginEmailAddress);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginSignInButton);
        loginBackground = (RelativeLayout) findViewById(R.id.loginBackground);
        loginInstagramLogo = (ImageButton) findViewById(R.id.loginInstagramLogo);

        initStuff();

    }

    private void initStuff() {
        loginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                //moveUp();
            }
        });
        loginPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                //moveUp();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                Intent i = new Intent(v.getContext(), ListsActivity.class);
                startActivity(i);
            }
        });
        loginBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                }
                //moveDown();
            }
        });
        loginInstagramLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate(v);
                Intent i = new Intent(v.getContext(), ListsActivity.class);
                startActivity(i);
            }
        });
    }

    private void authenticate(View v){
        WebView webView = new WebView(v.getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new AuthWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(authURLString);
    }

    private void moveUp(){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) loginBackground.getLayoutParams();
        params.setMargins(0, 20, 0, 0);
        loginBackground.setLayoutParams(params);
    }

    private void moveDown(){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) loginBackground.getLayoutParams();
        params.setMargins(0, 20, 0, 0);
        loginBackground.setLayoutParams(params);
    }

    public class AuthWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            if (url.startsWith(callbackURL))
            {
                System.out.println(url);
                String parts[] = url.split("=");
                token = parts[1];  //This is your request token.
                //InstagramLoginDialog.this.dismiss();
                return true;
            }
            return false;
        }
    }

    class getAuthToken extends AsyncTask<String, Integer, Void>{
        public Void doInBackground(String... args){
            try
            {
                URL url = new URL(tokenURLString);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
                outputStreamWriter.write("client_id="+Constants.clientId+
                        "client_secret="+ Constants.clientSecret +
                        "grant_type=authorization_code" +
                        "redirect_uri="+callbackURL+
                        "code=" + token);
                outputStreamWriter.flush();
                String response = streamToString(httpsURLConnection.getInputStream());
                JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();
                String accessTokenString = jsonObject.getString("access_token"); //Here is your ACCESS TOKEN
                String id = jsonObject.getJSONObject("user").getString("id");
                String username = jsonObject.getJSONObject("user").getString("username");
                //This is how you can get the user info.
                //You can explore the JSON sent by Instagram as well to know what info you got in a response
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        public String streamToString(InputStream p_is)
        {
            try
            {
                BufferedReader m_br;
                StringBuffer m_outString = new StringBuffer();
                m_br = new BufferedReader(new InputStreamReader(p_is));
                String m_read = m_br.readLine();
                while(m_read != null)
                {
                    m_outString.append(m_read);
                    m_read =m_br.readLine();
                }
                return m_outString.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return "";
        }

    }

}


