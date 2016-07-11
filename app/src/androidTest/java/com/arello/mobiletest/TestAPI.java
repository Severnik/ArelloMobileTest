package com.arello.mobiletest;

import android.test.AndroidTestCase;

import com.arello.mobiletest.controller.remote.model.JSONResponse;
import com.arello.mobiletest.controller.remote.service.PhotoListService;
import com.arello.mobiletest.model.Photo;

import java.util.List;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class TestAPI extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testPhotosHandler() throws Exception {
        JSONResponse<List<Photo>> jsonResponse = doPhotosRequest();
        assertNotNull(jsonResponse);
        assertNotNull(jsonResponse.getResult());
        assertNotNull(jsonResponse.getPagination());

    }

    private JSONResponse<List<Photo>> doPhotosRequest() {
        PhotoListService service = new PhotoListService(2);
        service.run();
        return service.getServiceResponseObject();
    }

}
