package com.arello.mobiletest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Photo extends AbstractModel {

    public static final String BUNDLE_KEY = "photo";

    public Photo() {
    }

    @JsonProperty("image")
    private Image image;

    @JsonProperty("likes_count")
    private int likesCount;

    @JsonProperty("uploader")
    private String uploader;

    @JsonProperty("palette")
    private String[] palette;
    //jackson ignore
    private List<Photo> photos;

    @Override
    protected String getBundleKey() {
        return BUNDLE_KEY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String[] getPalette() {
        return palette;
    }

    public void setPalette(String[] palette) {
        this.palette = palette;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
