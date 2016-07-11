package com.arello.mobiletest.ui.event;

/**
 * Created by Server Kurtnebiev on 10.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public interface OnItemClick<T> {
    void onClick(T item, int position);
}
