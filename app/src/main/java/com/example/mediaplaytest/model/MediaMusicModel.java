package com.example.mediaplaytest.model;

import com.example.mediaplaytest.R;
import com.example.mediaplaytest.data.MediaMusic;

import java.util.ArrayList;
import java.util.List;

public class MediaMusicModel {
    private MediaMusicViewModel viewModel;
    private List<MediaMusic> mediaMusics = new ArrayList<>();
    public MediaMusicModel(MediaMusicViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void getMediaMusicLists(){
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_01,"Dance Monkey","Monkey1"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_02,"Dance Monkey2","Monkey2"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_03,"Dance Monkey3","Monkey3"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_04,"Dance Monkey4","Monkey"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_05,"Dance Monkey","Monkey"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_06,"Dance Monkey","Monkey"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_07,"Dance Monkey","Monkey"));
        mediaMusics.add(new MediaMusic(R.drawable.mobile_music_thumb_08,"Dance Monkey","Monkey"));
        viewModel.onChangeMediaMusicLists(mediaMusics);
    }
}
