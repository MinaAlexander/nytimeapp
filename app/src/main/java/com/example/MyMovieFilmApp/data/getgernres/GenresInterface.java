package com.example.MyMovieFilmApp.data.getgernres;

import com.example.MyMovieFilmApp.pojo.genres.Genres;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GenresInterface {
//    @GET("v2/viewed/1.json?api-key=B4ukuh3HxEnryIZbfJ5ffx7plgNzki3Q")
//    public Call<MovieModel> getPosts();

    //    @GET("3/movie/now_playing?api_key=f7235f31dae10ae9307def03f194112c&language=en-US&page=1")
//    public Call<Data> getPosts();
    @GET("3/genre/movie/list")
    public Call<Genres> getgenres(@Query("api_key") String key);
//    Call<MoviesSearchResponses> searchMovie(@Query("api_key") String key, @Query("query") String query, @Query("page") int page);

}
