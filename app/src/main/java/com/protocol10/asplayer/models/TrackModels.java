package com.protocol10.asplayer.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author Akshay Mukadam
 * @since 26/9/15.
 */
public class TrackModels extends RealmObject {

    @PrimaryKey
    private long trackId;
    private String artistName;
    private String albumName;
    private String songName;
    private long duration;
    private String trackPath;
    private long albumId;
    private long artistId;

    public TrackModels() {
    }

    public TrackModels(long trackId, String artistName, String albumName, String songName,
                       long duration, String trackPath, long albumId, long artistId) {
        this.trackId = trackId;
        this.artistName = artistName;
        this.albumName = albumName;
        this.songName = songName;
        this.duration = duration;
        this.trackPath = trackPath;
        this.albumId = albumId;
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSongName() {
        return songName;
    }

    public long getDuration() {
        return duration;
    }

    public long getTrackId() {
        return trackId;
    }

    public String getTrackPath() {
        return trackPath;
    }

    public long getAlbumId() {
        return albumId;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setTrackPath(String trackPath) {
        this.trackPath = trackPath;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    ;
}
