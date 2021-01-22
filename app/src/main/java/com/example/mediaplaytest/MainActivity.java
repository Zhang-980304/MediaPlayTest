package com.example.mediaplaytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mediaplaytest.adapter.MediaMusicAdpater;
import com.example.mediaplaytest.data.MediaMusic;
import com.example.mediaplaytest.model.MediaMusicViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTabMusicAll;
    private Button btnTabMusicFavorite;
    private RecyclerView recyclevieMusicAll;
    private RecyclerView recyclevieMusicFavorite;
    private MediaMusicAdpater musicAdpater;
    private List<MediaMusic> mediaMusicList = new ArrayList<>();
    private MediaMusicViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initView(){
        btnTabMusicAll = findViewById(R.id.main_media_tab_music);
        btnTabMusicFavorite = findViewById(R.id.main_media_tab_music_favor);
        recyclevieMusicAll = (RecyclerView)findViewById(R.id.main_media_all_list);
        recyclevieMusicFavorite = (RecyclerView)findViewById(R.id.main_media_favourite_list);

        btnTabMusicAll.setOnClickListener(this);
        btnTabMusicFavorite.setOnClickListener(this);
    }

    private void initDate(){
        recyclevieMusicAll.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        musicAdpater = new MediaMusicAdpater(this,mediaMusicList);
        viewModel = new MediaMusicViewModel();
        recyclevieMusicAll.setAdapter(musicAdpater);
        viewModel.getMutableLiveDataMusicList().observe(this, new Observer<List<MediaMusic>>() {
            @Override
            public void onChanged(List<MediaMusic> mediaMusics) {
                mediaMusicList.clear();
                mediaMusicList.addAll(mediaMusics);
                musicAdpater.notifyDataSetChanged();
            }
        });
        viewModel.getMediaMusicLists();
    }

    private void changeMusicMode(int mode){
       switch(mode){
           case DefineValue.MUSIC_MODE_ALL:
               btnTabMusicAll.setBackgroundResource(R.drawable.mobile_common_tab_btn_pre);
               btnTabMusicFavorite.setBackgroundResource(R.color.colorTabBg);
               recyclevieMusicAll.setVisibility(View.VISIBLE);
               recyclevieMusicFavorite.setVisibility(View.INVISIBLE);
               break;
           case DefineValue.MUSIC_MODE_FAVORITE:
               btnTabMusicAll.setBackgroundResource(R.color.colorTabBg);
               btnTabMusicFavorite.setBackgroundResource(R.drawable.mobile_common_tab_btn_pre);
               recyclevieMusicAll.setVisibility(View.INVISIBLE);
               recyclevieMusicFavorite.setVisibility(View.VISIBLE);
               break;
       }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_media_tab_music:
                changeMusicMode(DefineValue.MUSIC_MODE_ALL);
                break;
            case R.id.main_media_tab_music_favor:
                changeMusicMode(DefineValue.MUSIC_MODE_FAVORITE);
                break;

        }
    }
}