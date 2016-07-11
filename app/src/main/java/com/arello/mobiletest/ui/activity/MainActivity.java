package com.arello.mobiletest.ui.activity;

import android.app.Fragment;

import com.arello.mobiletest.R;
import com.arello.mobiletest.controller.transit.MainTransitManager;
import com.arello.mobiletest.ui.annotation.Layout;
import com.arello.mobiletest.ui.fragment.StartFragment;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
@Layout(R.layout.main_activity)
public class MainActivity extends AbstractActivity {

    @Override
    protected Class<? extends Fragment> getFragmentForStart() {
        return StartFragment.class;
    }

    @Override
    protected void createTransitManager() {
        transitManager = new MainTransitManager(this);
    }

    @Override
    protected int getMainFragmentContainerRes() {
        return R.id.fragment_container;
    }
}
