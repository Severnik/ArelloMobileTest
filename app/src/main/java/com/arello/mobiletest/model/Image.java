package com.arello.mobiletest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Image extends AbstractModel{

    public static final String BUNDLE_KEY = "image";

    public Image() {
    }

    public Image(String url, Thumb thumb) {
        this.url = url;
        this.thumb = thumb;
    }

    @JsonProperty("url")
    private String url;


    @JsonProperty("thumb")
    private Thumb thumb;

    @JsonProperty("preview")
    private Preview preview;


    @Override
    protected String getBundleKey() {
        return BUNDLE_KEY;
    }

    public Thumb getThumb() {
        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;


    }
}
