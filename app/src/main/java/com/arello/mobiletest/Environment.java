package com.arello.mobiletest;

import retrofit.RestAdapter;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Environment {
    public static final String SERVER_REST = "https://api.desktoppr.co/1/wallpapers";
    public static final RestAdapter.LogLevel LOG_LEVEL = RestAdapter.LogLevel.FULL;
}
