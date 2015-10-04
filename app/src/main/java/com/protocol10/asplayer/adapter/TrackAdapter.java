package com.protocol10.asplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.protocol10.asplayer.R;
import com.protocol10.asplayer.models.TrackModels;

import java.util.List;

/**
 * @author Akshay Mukadam
 * @since 27/9//15
 */
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackHolder> {

    List<TrackModels> list;
    Context context;

    public TrackAdapter(List<TrackModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_tracks, parent, false);
        return new TrackHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackHolder holder, int position) {
        TrackModels trackModels = list.get(position);
        holder.trackTextView.setText(trackModels.getSongName());
        holder.artistTextView.setText(trackModels.getArtistName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TrackHolder extends RecyclerView.ViewHolder {
        TextView trackTextView;
        TextView artistTextView;

        public TrackHolder(View itemView) {
            super(itemView);
            trackTextView = (TextView) itemView.findViewById(R.id.trackTextView);
            artistTextView = (TextView) itemView.findViewById(R.id.artistTextView);
        }
    }
}
