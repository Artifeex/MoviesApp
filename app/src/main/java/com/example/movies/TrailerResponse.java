package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerResponse {

    @SerializedName("docs")
    private List<TrailerVideos> trailerVideosList;

    public List<TrailerVideos> getTrailerVideosList() {
        return trailerVideosList;
    }

    @Override
    public String toString() {
        return "TrailerResponse{" +
                "trailersList=" + trailerVideosList +
                '}';
    }
}
