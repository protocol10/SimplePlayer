package com.protocol10.asplayer.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.protocol10.asplayer.R;
import com.protocol10.asplayer.adapter.TrackAdapter;
import com.protocol10.asplayer.interfaces.ITrackView;
import com.protocol10.asplayer.models.TrackModels;
import com.protocol10.asplayer.presenter.TrackPresenter;
import com.protocol10.asplayer.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Akshay Mukadam
 * @since 26/9/15
 */
public class TrackFragment extends Fragment implements ITrackView {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView.LayoutManager mLayoutManager;
    TrackAdapter trackAdapter;
    List<TrackModels> tracksList;
    TrackPresenter trackPresenter;
    /**
     * Flag used to check if data exist locally
     */
    private boolean isDataPresent = false;
    /**
     * Flag  used to clear arrayList only once if there exist SDCard
     */
    private boolean isDataCleared = false;

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tracksList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        trackAdapter = new TrackAdapter(tracksList, getActivity());
        mRecyclerView.setAdapter(trackAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(AppConstants.IS_DATA_CLEARED, isDataCleared);
        outState.putBoolean(AppConstants.IS_DATA_PRESENT, isDataPresent);
        outState.putParcelableArrayList(AppConstants.TRACK_LIST, (ArrayList<? extends Parcelable>) tracksList);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            isDataPresent = savedInstanceState.getBoolean(AppConstants.IS_DATA_PRESENT);
            isDataCleared = savedInstanceState.getBoolean(AppConstants.IS_DATA_CLEARED);
        } else {
            initUi();
        }
    }

    private void initUi() {
        trackPresenter = new TrackPresenter(this, getActivity());
        trackPresenter.retrieveFromDataBase();
    }

    @Override
    public void populateTracks(List<TrackModels> list) {
        Log.i("List Size", "Size = " + list.size());
        if (isDataPresent) {
            if (!isDataCleared)
                tracksList.clear();
            isDataCleared = true;
        }
        tracksList.addAll(list);
        trackAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorStr) {
        Log.i("ERROR", errorStr);
    }

    @Override
    public void populateFromDataBase(List<TrackModels> list) {
        if (list.isEmpty()) {
            isDataPresent = false;
            tracksList.clear();
            tracksList.addAll(list);
            trackAdapter.notifyDataSetChanged();
        } else {
            isDataPresent = true;
        }
        trackPresenter.retreiveTracks();

    }
}
