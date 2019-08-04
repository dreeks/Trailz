package xyz.dreeks.trailz.utils;

import java.io.File;
import java.util.ArrayList;

import xyz.dreeks.trailz.trails.Trail;

public class Constants {

    public static final String MOD_ID      = "trailz";
    public static final String MOD_NAME    = "Trailz";
    public static final String MOD_VERSION = "1.0";

    public static final String CLIENT_PROXY_LOCATION = "xyz.dreeks.trailz.proxy.Client";
    public static final String SERVER_PROXY_LOCATION = "xyz.dreeks.trailz.proxy.Server";

    public static File TRAILS_FOLDER;
    public static ArrayList<Trail> TRAILS = new ArrayList<>();

}