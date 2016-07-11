package com.arello.mobiletest.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arello.mobiletest.ui.event.OnItemClick;

import butterknife.ButterKnife;

/**
 * Created by Server Kurtnebiev on 10.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
public abstract class AbstractHolder<D> extends RecyclerView.ViewHolder {

    protected D model;
    public View itemView;

    public AbstractHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(int position);

    public void setData(D model, int position) {
        this.model = model;
        bind(position);
    }

    public void setOnItemClick(final OnItemClick<D> clickListener, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onClick(model, position);
                }
            }
        });
    }
}
