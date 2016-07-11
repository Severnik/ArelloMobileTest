package com.arello.mobiletest.model;

import java.util.List;

/**
 * Created by Server Kurtnebiev on 10.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class PhotoToPosition extends AbstractModel {
    public static final String BUNDLE_KEY = "photo_to_position";

    private List<Photo> photos;

    private int position;

    public PhotoToPosition(List<Photo> photos, int position) {
        this.photos = photos;
        this.position = position;
    }

    @Override
    protected String getBundleKey() {
        return BUNDLE_KEY;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
