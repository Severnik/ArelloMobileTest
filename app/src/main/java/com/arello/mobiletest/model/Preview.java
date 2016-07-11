package com.arello.mobiletest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Preview extends AbstractModel {
    public static final String BUNDLE_KEY = "preview";

    public Preview() {
    }

    public Preview(String url) {
        this.url = url;
    }

    @JsonProperty("url")
    private String url;

    @Override
    protected String getBundleKey() {
        return BUNDLE_KEY;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
