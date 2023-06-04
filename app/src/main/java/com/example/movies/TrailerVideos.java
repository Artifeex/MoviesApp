package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class TrailerVideos {

    @SerializedName("videos")
    private TrailersList videos;

    public TrailerVideos(TrailersList trailersList) {
        this.videos = trailersList;
    }

    public TrailersList getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "TrailerVideos{" +
                "videos=" + videos +
                '}';
    }
}
