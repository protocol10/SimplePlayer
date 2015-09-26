package com.protocol10.asplayer.interfaces;

import com.protocol10.asplayer.models.TrackModels;

import java.util.List;

/**
 * Created by akshay on 26/9/15.
 */
public interface ITrackView {

    void populateTracks(List<TrackModels> list);

    void showError(String errorStr);
}
