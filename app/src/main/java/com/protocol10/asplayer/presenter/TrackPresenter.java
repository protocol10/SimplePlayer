package com.protocol10.asplayer.presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;

import com.protocol10.asplayer.interfaces.ITrackView;
import com.protocol10.asplayer.models.TrackModels;

import java.util.ArrayList;
import java.util.List;

import utils.AppConstants;

/**
 * @author Akshay Mukadam
 * @since 26/9/15.
 */
public class TrackPresenter {

    ITrackView trackView;
    List<TrackModels> list = new ArrayList<>();
    Context context;
    private boolean isSdCardPresent = false;

    public TrackPresenter(ITrackView trackView, Context context) {
        this.trackView = trackView;
        this.context = context;
        isSdCardPresent = checkForSdCard();
    }

    private boolean checkForSdCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public void retriveTracks() {
        retrieveInternalTracks();
    }

    private void retrieveInternalTracks() {

        Cursor cursor = getContentResolver().query(AppConstants.INTERNAL,
                AppConstants.TRACKS_COLUMNS, "", null, MediaStore.Audio.Media.TITLE + " asc");
        if (cursor == null) {
            trackView.showError(AppConstants.UNABLE_TAG);
        } else if (!cursor.moveToFirst()) {
            trackView.showError(AppConstants.NOMEDIA_TAG);
        } else {
            do {
                String trackName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String trackPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                long trackId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                long artistId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID));
                String albumName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                TrackModels trackModels = new TrackModels.TrackBuilder(trackName, trackPath,
                        trackId, duration).setAlbumId(albumId).setArtistId(artistId).
                        setAlbumName(albumName).setArtistName(artist).build();
                list.add(trackModels);
            } while (cursor.moveToNext());
            cursor.close();
        }
        if (isSdCardPresent) {
            retrieveExternalTracks();
        } else {
            trackView.populateTracks(list);
        }
    }

    private void retrieveExternalTracks() {

    }

    private ContentResolver getContentResolver() {
        return context.getContentResolver();
    }
}
