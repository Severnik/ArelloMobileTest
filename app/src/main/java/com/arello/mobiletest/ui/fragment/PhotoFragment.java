package com.arello.mobiletest.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.arello.mobiletest.R;
import com.arello.mobiletest.model.PhotoToPosition;
import com.arello.mobiletest.ui.adapter.PhotoPagerAdapter;
import com.arello.mobiletest.ui.annotation.Layout;

import butterknife.Bind;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
@Layout(R.layout.fragm_photo)
public class PhotoFragment extends AbstractFragment {

    private PhotoToPosition photoToPosition;

    @Bind(R.id.btn_back_area)
    FrameLayout backArea;

    @Bind(R.id.uploader)
    TextView uploader;

    @Bind(R.id.view_pager)
    ViewPager photos;
    private PhotoPagerAdapter adapter;
    private PhotoPagerAdapter.NavigationTopBar listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            photoToPosition = (PhotoToPosition) getArguments().getSerializable(PhotoToPosition.BUNDLE_KEY);
        }
    }

    @Override
    protected void initView(View view) {
        if (photoToPosition != null) {
            adapter = new PhotoPagerAdapter();
            photos.setAdapter(adapter);
            adapter.addAll(photoToPosition.getPhotos());
            photos.setCurrentItem(photoToPosition.getPosition());
            uploader.setText(photoToPosition.getPhotos().get(photoToPosition.getPosition()).getUploader());
            listener = new PhotoPagerAdapter.NavigationTopBar() {
                @Override
                public void onClickVisibility() {
                    if (backArea.getVisibility() == View.GONE && uploader.getVisibility() == View.GONE) {
                        showNavigationBar();
                    } else {
                        hideNavigationBar();
                    }
                }
            };
            adapter.setBackClick(listener);
        }
        backArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTransitManager().back();
            }
        });
        photos.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                uploader.setText(photoToPosition.getPhotos().get(position).getUploader());
            }
        });

    }

    private void showNavigationBar() {
        uploader.setAlpha(0.0f);
        backArea.setAlpha(0.0f);
        uploader.setVisibility(View.VISIBLE);
        backArea.setVisibility(View.VISIBLE);
        uploader.animate()
                .setListener(null)
                .alpha(1.0f);
        backArea.animate()
                .setListener(null)
                .alpha(1.0f);
    }

    private void hideNavigationBar() {
        adapter.setBackClick(null);
        backArea.animate()
                .alpha(0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        backArea.setVisibility(View.GONE);
                    }
                });
        uploader.animate()
                .alpha(0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        uploader.setVisibility(View.GONE);
                        adapter.setBackClick(listener);
                    }
                });
    }
}
