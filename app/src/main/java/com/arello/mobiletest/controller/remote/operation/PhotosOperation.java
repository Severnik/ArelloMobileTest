package com.arello.mobiletest.controller.remote.operation;

import android.support.annotation.NonNull;

import com.arello.mobiletest.controller.remote.model.JSONResponse;
import com.arello.mobiletest.controller.remote.service.PhotoListService;
import com.arello.mobiletest.model.Photo;
import com.redmadrobot.chronos.ChronosOperationResult;

import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class PhotosOperation extends AbstractOperation<JSONResponse<List<Photo>>> {

    private int page;

    public PhotosOperation(int page) {
        this.page = page;
    }

    @Override
    protected JSONResponse<List<Photo>> executeRoutine() {
        return executeService(new PhotoListService(page));
    }

    @NonNull
    @Override
    public Class<? extends ChronosOperationResult<JSONResponse<List<Photo>>>> getResultClass() {
        return Result.class;
    }

    public static class Result extends ChronosOperationResult<JSONResponse<List<Photo>>> {
    }
}
