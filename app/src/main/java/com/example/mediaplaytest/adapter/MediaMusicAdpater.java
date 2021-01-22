package com.example.mediaplaytest.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediaplaytest.R;
import com.example.mediaplaytest.data.MediaMusic;

import java.util.List;

public class MediaMusicAdpater extends RecyclerView.Adapter<MediaMusicAdpater.ItemViewHolder> {
    private List<MediaMusic> mediaMusic;
    private ItemClickListener itemClickListener;
    private Activity activity;

    public MediaMusicAdpater(Activity activity,List<MediaMusic>mediaMusic){
        this.activity = activity;
        this.mediaMusic = mediaMusic;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_music_item, parent, false);
       return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MediaMusic data = mediaMusic.get(position);
        holder.music_item_profile.setBackgroundResource(data.getImage());
        holder.music_item_title.setText(data.getTitle());
        holder.music_item_artist.setText(data.getArtist());

    }

    @Override
    public int getItemCount() {
        return mediaMusic.size();
    }
   public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView music_item_profile;
        private TextView music_item_title;
        private TextView music_item_artist;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            music_item_profile = itemView.findViewById(R.id.music_item_profile);
            music_item_title = itemView.findViewById(R.id.music_item_title);
            music_item_artist = itemView.findViewById(R.id.music_item_artist);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener != null){
                itemClickListener.onMusicSelected(getAdapterPosition());
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    public interface ItemClickListener{
        void onMusicSelected(int position);
    }

}
