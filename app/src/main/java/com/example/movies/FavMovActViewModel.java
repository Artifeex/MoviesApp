package com.example.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class FavMovActViewModel extends AndroidViewModel {

    private final MovieDatabase movieDatabase;

    public LiveData<List<Movie>> getFavMovies() {
        return movieDatabase.movieDao().getAllFavouriteMovies();
    }

    public FavMovActViewModel(@NonNull Application application) {
        super(application);
        movieDatabase = MovieDatabase.getInstance(application);
    }
}
