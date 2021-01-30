package com.example.nt2.ui.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nt2.R;
import com.example.nt2.databinding.FragmentPostesBinding;
import com.example.nt2.pojo.Data;
import com.example.nt2.pojo.Results;
import com.example.nt2.ui.main.PostViewModel;
import com.example.nt2.ui.main.PostsAdapter;

import java.net.InetAddress;
import java.util.ArrayList;

public class PostsFragment extends Fragment implements PostsAdapter.OnItemListener {

    private PostViewModel postViewModel;
    private static String TAG = "PostsFragment";
    private ArrayList<Results> postes;
    private PostsAdapter adapter;
    private onHeatLisener onHeatLisener;
    FragmentPostesBinding binding;

    public static PostsFragment newInstance() {
        return new PostsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        rootView = inflater.inflate(R.layout.fragment_all_articals, container, false);
//        return rootView;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postes, container, false);
        View rootView = binding.getRoot();
        return rootView;
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postes = new ArrayList<>();
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        adapter = new PostsAdapter(this);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycler.setAdapter(adapter);
        checkInternet();
//        recyclerView = rootView.findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
    }

    public void loadData() {

        postViewModel.postsMutableLiveData.observe(getActivity(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                Log.e(TAG, "datap 1: " + data);
                postes = data.getResults();

                if (postes.size() == 0) {
                    Log.e(TAG, "datap 2 : " + data);

                } else {
                    Log.e(TAG, "datap 3 : " + postes.size());
                    postes = data.getResults();
                    adapter.setList(data.getResults());
                    adapter.notifyDataSetChanged();

                }
//                for(int i=0;i<Postes.size();i++){
//                    Log.e(TAG,"uri : "+ Postes.get(i).getUri()+"\n"+
//                            "url : "+Postes.get(i).getUrl()+"\n"+
//                            "id : "+Postes.get(i).getId());
//                }

            }

        });


    }

    private void checkInternet() {
        Log.e(TAG, "VersionCheck" + "CheckInternet");
        ConnectivityManager cManager;
        AlertDialog.Builder mBuilder_net;
        AlertDialog alertDialog_net;

        Log.e(TAG, "isNetworkConnected : " + isNetworkConnected() + "  --- isInternetAvailable : " + isInternetAvailable());
        if (isNetworkConnected()) {
            loadData();

        } else {
            mBuilder_net = new AlertDialog.Builder(getContext(), AlertDialog.THEME_HOLO_LIGHT);
            mBuilder_net.setTitle("Net Work Bad!");
            mBuilder_net.setMessage("please try again later");
            mBuilder_net.setIcon(R.mipmap.ic_launcher);
            mBuilder_net.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialoge, int i) {
                    checkInternet();
//                    Retry.setVisibility(View.VISIBLE);
//                    Exit.setVisibility(View.VISIBLE);
                }
            });
            alertDialog_net = mBuilder_net.create();
            alertDialog_net.show();
            alertDialog_net.setCancelable(false);
            alertDialog_net.setCanceledOnTouchOutside(false);
        }
    }

    public boolean isNetworkConnected() {
        try {
            ConnectivityManager cm = (ConnectivityManager) getActivity()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onItemClick(int postion) {
        Log.e(TAG, "postion :" + postion);
        onHeatLisener.heating(String.valueOf(postes.get(postion).getSource()), String.valueOf(postes.get(postion).getTitle()), String.valueOf(postes.get(postion).getArticalbody()));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onHeatLisener = (onHeatLisener) context;
    }

    public interface onHeatLisener {
        public void heating(String source, String title, String body);
    }


}