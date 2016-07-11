package com.arello.mobiletest.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arello.mobiletest.R;
import com.arello.mobiletest.model.Photo;
import com.arello.mobiletest.utils.Utils;

import butterknife.Bind;


/**
 * Created by Server Kurtnebiev on 10.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class PhotosHolder extends AbstractHolder<Photo> {

    @Bind(R.id.img_photo)
    ImageView imgPhoto;

    @Bind(R.id.uploader)
    TextView uploader;

    @Bind(R.id.likes_count)
    TextView likesCount;

    public PhotosHolder( View itemView) {
        super(itemView);
    }

    @Override
    public void bind(int position) {
        Utils.setPaletteGridItemTitle(uploader, model);
        Utils.setImageByURI(model.getImage().getThumb().getUrl(), imgPhoto);
        uploader.setText(model.getUploader());
        likesCount.setText(String.valueOf(model.getLikesCount()));
    }
}
