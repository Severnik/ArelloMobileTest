package com.arello.mobiletest.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arello.mobiletest.controller.transit.FragmentAction;
import com.arello.mobiletest.ui.activity.AbstractActivity;
import com.arello.mobiletest.ui.annotation.Layout;
import com.fsm.transit.core.ITransitManager;
import com.redmadrobot.chronos.gui.fragment.ChronosFragment;

import butterknife.ButterKnife;
import icepick.Icepick;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractFragment extends ChronosFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getViewLayout(), container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    protected void initView(View view) {

    }

    protected int getViewLayout() {
        Layout layout = this.getClass().getAnnotation(Layout.class);
        return layout != null ? layout.value() : 0;
    }

    /**
     * special fragment manager, do all switch use this object.
     *
     * @return instance of {@link ITransitManager}
     */
    public ITransitManager<FragmentAction> getTransitManager() {
        if (getActivity() != null) {
            return ((AbstractActivity) getActivity()).getTransitManager();
        } else {
            return null;
        }
    }
}
