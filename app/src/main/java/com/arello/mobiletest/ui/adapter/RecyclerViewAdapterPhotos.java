package com.arello.mobiletest.ui.adapter;

import android.view.ViewGroup;

import com.arello.mobiletest.R;
import com.arello.mobiletest.model.Photo;
import com.arello.mobiletest.ui.holder.PhotosHolder;


/**
 * Created by Server Kurtnebiev on 10.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class RecyclerViewAdapterPhotos extends AbstractRecyclerViewAdapter<Photo, PhotosHolder> {

    @Override
    public int getItemViewType(int position) {
        return R.layout.photos_item;
    }

    @Override
    public PhotosHolder onInitViewHolder(ViewGroup parent, int viewType) {
        return new PhotosHolder(inflater.inflate(viewType, parent, false));
    }
}
