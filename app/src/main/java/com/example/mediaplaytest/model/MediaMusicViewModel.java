package com.example.mediaplaytest.model;

import androidx.lifecycle.MutableLiveData;

import com.example.mediaplaytest.data.MediaMusic;

import java.util.List;

public class MediaMusicViewModel {

    MediaMusicModel model;
    List<MediaMusic> mediaMusics;
    private MutableLiveData<List<MediaMusic>> mutableLiveDataMusicList = new MutableLiveData<>();
    public MediaMusicViewModel() {
        model = new MediaMusicModel(this);
    }

    public void getMediaMusicLists(){
        model.getMediaMusicLists();
    }
    public MutableLiveData<List<MediaMusic>> getMutableLiveDataMusicList(){
        return mutableLiveDataMusicList;
    }
    public void onChangeMediaMusicLists(List<MediaMusic> mediaMusics){
        mutableLiveDataMusicList.postValue(mediaMusics);
    }

}
