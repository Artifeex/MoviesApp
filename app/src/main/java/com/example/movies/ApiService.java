package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

//    @Headers({
//            "Accept: application/json",
//            "X-API-KEY: ТУТ-ВАШ-API-КЛЮЧ"
//    })
    @GET("v1.3/movie?token=HEGYVVJ-G864NWE-HCMG3DY-GQTRY8K&rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=40")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("v1.3/movie?token=HEGYVVJ-G864NWE-HCMG3DY-GQTRY8K&selectFields=videos.trailers")
    Single<TrailerResponse> loadTrailers(@Query("id") int id);

    @GET("v1/review?token=HEGYVVJ-G864NWE-HCMG3DY-GQTRY8K")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}
