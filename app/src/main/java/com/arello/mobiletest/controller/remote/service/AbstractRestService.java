package com.arello.mobiletest.controller.remote.service;

import com.arello.mobiletest.Environment;
import com.arello.mobiletest.controller.remote.IService;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractRestService<T> extends AbstractService<T> {
    private static IService irestService;

    protected static IService getAPI() {
        if (irestService == null) {
            irestService = new RestAdapter.Builder()
                    .setEndpoint(Environment.SERVER_REST)
                    .setConverter(new JacksonConverter(getObjectMapper()))
                    .setLogLevel(Environment.LOG_LEVEL)
                    .build()
                    .create(IService.class);
        }
        return irestService;
    }

    @Override
    public void run() {
        run(getAPI());
    }

    protected abstract void run(IService API);


}