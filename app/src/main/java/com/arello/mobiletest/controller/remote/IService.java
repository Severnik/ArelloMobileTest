package com.arello.mobiletest.controller.remote;

import com.arello.mobiletest.controller.remote.model.JSONResponse;
import com.arello.mobiletest.model.Photo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public interface IService {

    @GET("/")
    JSONResponse<List<Photo>> getPhotos(@Query("page") int page);
}
