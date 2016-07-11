package com.arello.mobiletest.ui.fragment;

import android.os.Handler;
import android.view.View;

import com.arello.mobiletest.R;
import com.arello.mobiletest.controller.transit.FragmentAction;
import com.arello.mobiletest.ui.annotation.Layout;
import com.hanks.htextview.HTextView;

import butterknife.Bind;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
@Layout(R.layout.fragm_start)
public class StartFragment extends AbstractFragment {

    @Bind(R.id.label_txt)
    HTextView label;

    @Override
    protected void initView(View view) {
        super.initView(view);
        label.animateText(getActivity().getString(R.string.desktoppr_gallery));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getTransitManager().switchFragment(StartFragment.this, FragmentAction.PHOTOS);
            }
        }, 2000);

    }
}
