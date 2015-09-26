package com.protocol10.asplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.protocol10.asplayer.R;
import com.protocol10.asplayer.interfaces.ITrackView;
import com.protocol10.asplayer.models.TrackModels;
import com.protocol10.asplayer.presenter.TrackPresenter;

import java.util.List;

/**
 * @author Akshay Mukadam
 * @since 26/9/15
 */
public class TrackFragment extends Fragment implements ITrackView {

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TrackPresenter trackPresenter = new TrackPresenter(this, getActivity());
        trackPresenter.retriveTracks();
        return inflater.inflate(R.layout.fragment_songs, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void populateTracks(List<TrackModels> list) {
        Log.i("List Size", "Size = " + list.size());
    }

    @Override
    public void showError(String errorStr) {
        Log.i("ERROR", errorStr);
    }
}
