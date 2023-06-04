package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class FavouriteMoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFavouriteMovies;
    private MoviesAdapter favouriteMoviesAdapter;
    private FavMovActViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movies);
        initViews();
        viewModel = new ViewModelProvider(this).get(FavMovActViewModel.class);
        favouriteMoviesAdapter = new MoviesAdapter();
        recyclerViewFavouriteMovies.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewFavouriteMovies.setAdapter(favouriteMoviesAdapter);

        viewModel.getFavMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                favouriteMoviesAdapter.setMovies(movies);
            }
        });

        favouriteMoviesAdapter.setOnClickMovieListener(new MoviesAdapter.OnClickMovieListener() {
            @Override
            public void onClickMovie(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(FavouriteMoviesActivity.this, movie);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        recyclerViewFavouriteMovies = findViewById(R.id.recyclerViewFavouriteMovies);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteMoviesActivity.class);
    }
}