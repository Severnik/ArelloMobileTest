package com.arello.mobiletest.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.arello.mobiletest.controller.transit.FragmentAction;
import com.arello.mobiletest.ui.annotation.Layout;
import com.fsm.transit.core.ITransitManager;
import com.redmadrobot.chronos.gui.activity.ChronosActivity;

import icepick.Icepick;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractActivity extends ChronosActivity {

    protected ITransitManager<FragmentAction> transitManager;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getViewLayout());
        createTransitManager();
        getTransitManager().setCurrentContainer(getMainFragmentContainerRes());

        if (savedInstanceState == null) {
            getTransitManager().switchFragment(getFragmentForStart(), (Bundle) null, true);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    protected int getViewLayout() {
        Layout layout = this.getClass().getAnnotation(Layout.class);
        return layout != null ? layout.value() : 0;
    }

    /**
     * method provide access to transit manager object for current activity
     *
     * @return TransitManager object, what manipulate fragments
     */
    public ITransitManager<FragmentAction> getTransitManager() {
        return transitManager;
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }


    /**
     * set fragment for start after activity open
     *
     * @return Fragment for start
     */
    protected abstract Class<? extends Fragment> getFragmentForStart();

    /**
     * create concrete TransitManager object for activity page transitions
     */
    protected abstract void createTransitManager();


    /**
     * set FrameLayout id for fragment container
     *
     * @return id for transit manager
     */
    protected abstract int getMainFragmentContainerRes();


}
