package com.protocol10.asplayer.utils;

import android.net.Uri;
import android.provider.MediaStore;

/**
 * @author Akshay Mukadam
 * @since 26/9/15
 * This class contains the constants used all over the App
 */
public class AppConstants {
    public static final String SONG_TAG = "Songs";
    public static final String ALBUM_TAG = "Albums";
    public static final String ARTIST_TAG = "Artist";
    public static final String PLAYLIST_TAG = "PlayList";
    public static final Uri INTERNAL = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
    public static final Uri EXTERNAL = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    public static final String UNABLE_TAG = "Unable to fetch media";
    public static final String NOMEDIA_TAG = "No media on device";
    /**
     * Used for projection of columns from MediaStore DataBase which ir provided by android
     * helps to retrieves available tracks  with it's subordinate information
     */
    public static final String[] TRACKS_COLUMNS = {
            MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.ALBUM_ID, MediaStore.Audio.Media.ARTIST_ID};
}
