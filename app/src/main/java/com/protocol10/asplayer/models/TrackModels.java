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

    private TrackModels(TrackBuilder builder) {
        this.albumName = builder.albumName;
        this.artistName = builder.artistName;
        this.duration = builder.duration;
        this.trackId = builder.trackId;
        this.songName = builder.songName;
        this.albumId = builder.albumId;
        this.artistId = builder.artistId;
        this.trackPath = builder.trackPath;
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

    public Long getAlbumId() {
        return albumId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public static class TrackBuilder {
        private String artistName;//optional
        private String albumName; //optional
        private String songName;//required
        private long duration;//required
        private long trackId;//required
        private String trackPath;//required
        private long albumId;//optional
        private long artistId;//optional

        /**
         * @param songName  Name of the Track
         * @param trackPath Path of the Track
         * @param trackId   Unique Id for track
         * @param duration  Duration of Media
         */
        public TrackBuilder(String songName, String trackPath, long trackId, long duration) {
            this.songName = songName;
            this.trackId = trackId;
            this.duration = duration;
            this.trackPath = trackPath;
        }

        public TrackBuilder setAlbumName(String albumName) {
            this.albumName = albumName;
            return this;
        }

        public TrackBuilder setArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        public TrackBuilder setArtistId(long artistId) {
            this.artistId = artistId;
            return this;
        }

        public TrackBuilder setAlbumId(long albumId) {
            this.albumId = albumId;
            return this;
        }

        public TrackModels build() {
            return new TrackModels(this);
        }
    }
}
