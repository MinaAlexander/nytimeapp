package com.example.nt2.data;

import com.example.nt2.pojo.Data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repositry {
    //    https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=B4ukuh3HxEnryIZbfJ5ffx7plgNzki3Q
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/";

    private PostInterface postInterface;
    private static Repositry INSTANCE;
    private static String TAG = "PostsClient";

    public Repositry() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static Repositry getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new Repositry();
        }
        return INSTANCE;
    }

    public Call<Data> getPosts() {
        return postInterface.getPosts();
    }
}
