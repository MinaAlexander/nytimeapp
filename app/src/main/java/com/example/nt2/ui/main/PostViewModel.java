package com.example.nt2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nt2.data.PostsClient;
import com.example.nt2.pojo.Data;
import com.example.nt2.pojo.Results;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    public MutableLiveData<Data> postsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> posts = new MutableLiveData<>();
    private static String TAG = "PostViewModel";

    public void getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                postsMutableLiveData.setValue(response.body());
                Log.e(TAG,"PostesModelsbody: "+response.body());
                Log.e(TAG,"PostesModelsbody: "+response.body().toString());
                Log.e(TAG,"PostesModelsbody: "+response.toString());
                 ArrayList<Results> Postes=response.body().getResults();
                 for(int i=0;i<Postes.size();i++){
                     Log.e(TAG,"uri : "+ Postes.get(i).getUri()+"\n"+
                             "url : "+Postes.get(i).getUrl()+"\n"+
                             "id : "+Postes.get(i).getId());
                 }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                posts.setValue("errr");
                Log.e(TAG,"PostesModels error : "+t);

            }
        });
    }
}