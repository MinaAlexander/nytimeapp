package com.example.nt2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nt2.data.Repositry;
import com.example.nt2.pojo.Data;
import com.example.nt2.pojo.Results;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {


    public MutableLiveData<Data> postsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> posts = new MutableLiveData<>();
    private static String TAG = "PostViewModel";
    ArrayList<Results> Postes = new ArrayList();

    public void getPosts() {
        postsMutableLiveData= fillData();
    }
    public MutableLiveData<Data> fillData() {
        Repositry.getINSTANCE().getPosts().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                postsMutableLiveData.setValue(response.body());
//                Log.e(TAG, "PostesModelsbody: " + response.body());
//                Log.e(TAG, "PostesModelsbody: " + response.body().toString());
//                Log.e(TAG, "PostesModelsbody: " + response.toString());
//                Postes = response.body().getResults();
//
//                for (int i = 0; i < Postes.size(); i++) {
//                    Log.e(TAG, "uri : " + Postes.get(i).getUri() + "\n" +
//                            "url : " + Postes.get(i).getUrl() + "\n" +
//                            "id : " + Postes.get(i).getId());
//                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                posts.setValue("errr");
                Log.e(TAG, "PostesModels error : " + t);

            }
        });
        return postsMutableLiveData;
    }


}