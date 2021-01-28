package com.example.nt2.data;

import com.example.nt2.pojo.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("v2/viewed/1.json?api-key=B4ukuh3HxEnryIZbfJ5ffx7plgNzki3Q")
    public Call<Data> getPosts();
}
