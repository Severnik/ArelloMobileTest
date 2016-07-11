package com.arello.mobiletest.controller.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class JSONResponse<T> {

    @JsonProperty("response")
    private T result;

    @JsonProperty("pagination")
    private Pagination pagination;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
