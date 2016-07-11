package com.arello.mobiletest.controller.transit;

import android.app.Activity;

import com.arello.mobiletest.ui.fragment.PhotoFragment;
import com.arello.mobiletest.ui.fragment.PhotosFragment;
import com.arello.mobiletest.ui.fragment.StartFragment;
import com.fsm.transit.core.AbstractTransitManager;
import com.fsm.transit.core.TransitData;
import com.fsm.transit.core.TransitResultData;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class MainTransitManager extends AbstractTransitManager<FragmentAction> {
    /**
     * Pass {@link Activity} in args
     *
     * @param activity {@link Activity}
     */
    public MainTransitManager(Activity activity) {
        super(activity);
    }

    {
        transitionsMap.put(new TransitData<>(StartFragment.class, FragmentAction.PHOTOS), new TransitResultData<FragmentAction>(PhotosFragment.class, false));
        transitionsMap.put(new TransitData<>(PhotosFragment.class, FragmentAction.PHOTO), new TransitResultData<FragmentAction>(PhotoFragment.class, true));
    }
}
