package com.arello.mobiletest.controller.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public class Pagination {

    @JsonProperty("current")
    private int current;

    @JsonProperty("previous")
    private int previous;

    @JsonProperty("next")
    private int next;

    public int getCurrent() {
        return current;
    }

    public int getPrevious() {
        return previous;
    }

    public int getNext() {
        return next;
    }
}
