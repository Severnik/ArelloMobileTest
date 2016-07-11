package com.arello.mobiletest.controller.remote.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.arello.mobiletest.controller.remote.model.JSONResponse;


/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractService<T> {

    protected T serviceResponseObject;

    protected static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public T getServiceResponseObject() {
        return serviceResponseObject;
    }

    public abstract void run();

}