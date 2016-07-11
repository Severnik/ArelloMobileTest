package com.arello.mobiletest.utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.graphics.Palette;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.arello.mobiletest.TheApplication;
import com.arello.mobiletest.model.Photo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Utils {

    public static List<Palette.Swatch> swatches(String[] colors) {

        List<Palette.Swatch> swatches = new ArrayList<Palette.Swatch>();
        for (String color : colors) {
            swatches.add(new Palette.Swatch(Color.parseColor("#" + color), 1));
        }
        return swatches;
    }

    public static void setPaletteGridItemTitle(TextView textView, Photo photo) {
        Palette.Swatch swatch = Palette.from(Utils.swatches(photo.getPalette())).getVibrantSwatch();
        if (swatch != null) {
            textView.setBackgroundColor(swatch.getRgb());
            textView.setTextColor(swatch.getTitleTextColor());
        }
    }

    public static void setImageByURI(String url, ImageView imageView) {
        Glide.with(TheApplication.getInstance())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    public static void setImageFromThumbByURI(String url, String thumbUrl, ImageView imageView) {
        TheApplication context = TheApplication.getInstance();
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .thumbnail(Glide.with(context).load(thumbUrl))
                .into(imageView);
    }

    public static int countNumOfColoms(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        if (activity.getResources().getConfiguration().orientation ==
                activity.getResources().getConfiguration()
                        .ORIENTATION_LANDSCAPE) {

            return width > 1500 ? 6 : 3;
        } else {
            return width > 1500 ? 4 : 2;
        }
    }
}
