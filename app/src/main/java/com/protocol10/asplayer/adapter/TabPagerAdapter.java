package com.protocol10.asplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import utils.AppConstants;
import com.protocol10.asplayer.fragment.AlbumFragment;
import com.protocol10.asplayer.fragment.ArtistFragment;
import com.protocol10.asplayer.fragment.PlayListFragment;
import com.protocol10.asplayer.fragment.TrackFragment;

/**
 * @author Akshay Mukadam
 * @since 26/9/15.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private static final String[] TITLES = {"Songs", "Albums", "Artist", "PlayList"};

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        String titleName = TITLES[position];
        Fragment fragment = null;
        switch (titleName) {
            case AppConstants.SONG_TAG:
                fragment = new TrackFragment();
                break;
            case AppConstants.ALBUM_TAG:
                fragment = new AlbumFragment();
                break;
            case AppConstants.ARTIST_TAG:
                fragment = new ArtistFragment();
                break;
            case AppConstants.PLAYLIST_TAG:
                fragment = new PlayListFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
