package com.example.nt2.ui.fragment;

import androidx.lifecycle.Observer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nt2.R;
import com.example.nt2.pojo.Data;
import com.example.nt2.pojo.Results;
import com.example.nt2.ui.main.PostViewModel;
import com.example.nt2.ui.main.PostsAdapter;

import java.util.ArrayList;

public class AllArticalsFragment extends Fragment implements PostsAdapter.OnItemListener {

    private PostViewModel postViewModel;
    private static String TAG = "AllArticalsFragment";
    private ArrayList<Results> Postes;
    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private View rootView;

    onHeatLisener onHeatLisener;

    public static AllArticalsFragment newInstance() {
        return new AllArticalsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_all_articals, container, false);
        return rootView;
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     Postes = new ArrayList<>();
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        recyclerView = rootView.findViewById(R.id.recycler);
        adapter = new PostsAdapter(Postes, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                Log.e(TAG, "data : " + data);
                Postes = data.getResults();
                adapter.setList(Postes);

//                for(int i=0;i<Postes.size();i++){
//                    Log.e(TAG,"uri : "+ Postes.get(i).getUri()+"\n"+
//                            "url : "+Postes.get(i).getUrl()+"\n"+
//                            "id : "+Postes.get(i).getId());
//                }

            }

        });
    }


    @Override
    public void onItemClick(int postion) {
        Log.e(TAG, "postion :" + postion);
        onHeatLisener.heating(String.valueOf(Postes.get(postion).getSource()),String.valueOf(Postes.get(postion).getTitle()),String.valueOf(Postes.get(postion).getArticalbody()));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onHeatLisener=(onHeatLisener) context;
    }

    public interface onHeatLisener {
        public void heating(String source,String title,String body);
    }


}