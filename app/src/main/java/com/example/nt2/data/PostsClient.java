package com.example.nt2.data;

import android.util.Log;

import com.example.nt2.pojo.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
//    https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=B4ukuh3HxEnryIZbfJ5ffx7plgNzki3Q
//    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/";

    private PostInterface postInterface;
    private static PostsClient INSTANCE;
    private static String  TAG = "PostsClient";

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
        Log.e(TAG,"postInterface : "+postInterface);

    }

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostsClient();
            Log.e(TAG,"INSTANCE : "+INSTANCE);

        }
        return INSTANCE;
    }

    public Call<Data> getPosts(){
        Log.e(TAG,"getPosts : "+postInterface.getPosts());

        return postInterface.getPosts();
    }
}
