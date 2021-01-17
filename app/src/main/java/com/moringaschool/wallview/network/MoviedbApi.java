package com.moringaschool.wallview.network;

import com.moringaschool.wallview.models.MovieListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviedbApi {
    @GET("search/movie")
    Call<MovieListResponse> getMovies(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("sort_by") String sort_by,
            @Query("include_adult") String include_adult,
            @Query("include_video") String include_video,
            @Query("page") Integer page
    );
}
