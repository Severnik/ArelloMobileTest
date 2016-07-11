package com.arello.mobiletest.controller.remote.operation;

import com.arello.mobiletest.controller.remote.service.AbstractRestService;
import com.redmadrobot.chronos.ChronosOperation;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractOperation<T> extends ChronosOperation<T> {

    @Override
    public T run() {
        return executeRoutine();
    }

    protected T executeRoutine() {
        return null;
    }

    public T executeService(AbstractRestService<T> abstractRestService) {
        return runRequest(abstractRestService);
    }


    private T runRequest(AbstractRestService<T> restService) {
        restService.run();
        return restService.getServiceResponseObject();
    }
}