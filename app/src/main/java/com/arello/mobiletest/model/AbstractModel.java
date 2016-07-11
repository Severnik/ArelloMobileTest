package com.arello.mobiletest.model;

import android.os.Bundle;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    public AbstractModel(AbstractModel abstractModel) {
    }

    protected AbstractModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putSerializable(getBundleKey(), this);
        return b;
    }

    protected abstract String getBundleKey();
}
