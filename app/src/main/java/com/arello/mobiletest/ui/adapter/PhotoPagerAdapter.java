package com.arello.mobiletest.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arello.mobiletest.R;
import com.arello.mobiletest.model.Image;
import com.arello.mobiletest.model.Photo;
import com.arello.mobiletest.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class PhotoPagerAdapter extends PagerAdapter {

    private List<Photo> photos;
    private NavigationTopBar backClick;

    public void setBackClick(NavigationTopBar backClick) {
        this.backClick = backClick;
    }

    @Override
    public int getCount() {
        return photos != null ? photos.size() : 0;
    }

    public void addAll(Collection<Photo> collection) {
        if (collection != null) {
            if (photos == null) {
                photos = new ArrayList<Photo>();
            }
            photos.clear();
            photos.addAll(collection);
            notifyDataSetChanged();
        }
    }

    @Override
    public View instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(
                R.layout.photo_item, null);
        ImageView imgPhoto = (ImageView) view.findViewById(R.id.img_pictured);
        Image image = photos.get(position).getImage();
        Utils.setImageFromThumbByURI(image.getUrl(),
                image.getThumb().getUrl(), imgPhoto);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backClick != null) {
                    backClick.onClickVisibility();
                }
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public interface NavigationTopBar {
        void onClickVisibility();
    }

}
