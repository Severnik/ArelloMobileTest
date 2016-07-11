package com.arello.mobiletest.controller.remote.service;

import com.arello.mobiletest.controller.remote.IService;
import com.arello.mobiletest.controller.remote.model.JSONResponse;
import com.arello.mobiletest.model.Photo;

import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class PhotoListService extends AbstractRestService<JSONResponse<List<Photo>>> {
    private int page;

    public PhotoListService(int page) {
        this.page = page;
    }

    @Override
    protected void run(IService API) {
        serviceResponseObject = API.getPhotos(page);
    }
}
