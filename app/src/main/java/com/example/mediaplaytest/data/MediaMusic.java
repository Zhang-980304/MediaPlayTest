package com.example.mediaplaytest.data;

public class MediaMusic {
    protected String id;
    protected int image;
    protected String title;
    protected String artist;
    protected String album;

    public MediaMusic(int image, String title, String artist){
        this.image = image;
        this.title = title;
        this.artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



}
