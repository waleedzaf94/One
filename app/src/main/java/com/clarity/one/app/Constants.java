package com.clarity.one.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 7/7/2015.
 */
public class Constants {

    public static String accessToken;
    public static final String authURL="https://api.instagram.com/oauth/authorize/";
    public static final String clientId="fa239f72473c4ca69515a3928cc0f494";
    public static final String clientSecret="53d593276b6d4826b4a687009fca59be";
    public static final String callbackURL="http://securityfinders.com.au/authenticate";
    public static int followersThreshold=10000;
    public static double engagementThreshold=1;
    public static List<String> filterLocations=new ArrayList<>();
    public static boolean filters=false;

}
