package com.arello.mobiletest.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arello.mobiletest.R;
import com.arello.mobiletest.controller.remote.model.Pagination;
import com.arello.mobiletest.controller.remote.operation.PhotosOperation;
import com.arello.mobiletest.controller.transit.FragmentAction;
import com.arello.mobiletest.model.Photo;
import com.arello.mobiletest.model.PhotoToPosition;
import com.arello.mobiletest.ui.adapter.RecyclerViewAdapterPhotos;
import com.arello.mobiletest.ui.annotation.Layout;
import com.arello.mobiletest.ui.event.EndlessScrollListener;
import com.arello.mobiletest.ui.event.OnItemClick;
import com.arello.mobiletest.utils.Utils;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Server Kurtnebiev on 09.07.2016.
 * Copyright (c) 2016 ArelloMobileTest
 */
@Layout(R.layout.fragm_photos)
public class PhotosFragment extends AbstractFragment implements OnItemClick<Photo> {

    @Bind(R.id.photos_grid)
    RecyclerView recyclerView;

    @Bind(R.id.indeterminate_progress_native)
    ProgressBar bar;

    private RecyclerViewAdapterPhotos adapter;
    private List<Photo> data;
    private Pagination pagination;

    @Override
    protected void initView(View view) {
        super.initView(view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), Utils.countNumOfColoms(getActivity()), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapterPhotos();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(this);
        recyclerView.addOnScrollListener(new EndlessScrollListener(gridLayoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                bar.setVisibility(View.VISIBLE);
                runOperation(new PhotosOperation(pagination.getNext()));
            }
        });
        if (data != null) {
            adapter.setData(data);
        }
        if (adapter.getItemCount() == 0) {
            runOperation(new PhotosOperation(1));
        }
    }

    public void onOperationFinished(PhotosOperation.Result result) {
        bar.setVisibility(View.GONE);
        if (result.isSuccessful()) {
            if (data != null) {
                data.addAll(result.getOutput().getResult());
            } else {
                data = result.getOutput().getResult();
            }
            pagination = result.getOutput().getPagination();
            adapter.setData(data);
        }
    }

    @Override
    public void onClick(Photo item, int position) {
        getTransitManager().switchFragment(PhotosFragment.this,
                FragmentAction.PHOTO, new PhotoToPosition(adapter.getData(), position).toBundle());
    }
}
