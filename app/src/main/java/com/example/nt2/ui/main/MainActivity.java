package com.example.nt2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

import com.example.nt2.R;
import com.example.nt2.pojo.Results;
import com.example.nt2.ui.fragment.AllArticalsFragment;
import com.example.nt2.ui.fragment.DetailesFragment;

public class MainActivity extends AppCompatActivity implements  AllArticalsFragment.onHeatLisener {
    PostViewModel postViewModel;
    private static String TAG = "MainActivity";
    private ArrayList<Results> Postes;
    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    Boolean mIsDualPane = false;
    public static Boolean dual;
    AllArticalsFragment allArticalsFragment;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allArticalsFragment=new AllArticalsFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, allArticalsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
//        Postes = new ArrayList<>();
//        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
//        postViewModel.getPosts();
//        recyclerView = findViewById(R.id.recycler);
//        adapter = new PostsAdapter();
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//        postViewModel.postsMutableLiveData.observe(this, new Observer<Data>() {
//            @Override
//            public void onChanged(Data data) {
//                Log.e(TAG, "data : " + data);
//                ArrayList<Results> Postes = data.getResults();
//                adapter.setList(Postes);
////                for(int i=0;i<Postes.size();i++){
////                    Log.e(TAG,"uri : "+ Postes.get(i).getUri()+"\n"+
////                            "url : "+Postes.get(i).getUrl()+"\n"+
////                            "id : "+Postes.get(i).getId());
////                }
//
//            }
//
//        });

    }


    @Override
    public void heating(String source,String title,String body) {
        Log.e(TAG, "data heating postion : " + source+" - "+title+" - "+body);
        DetailesFragment tabletSize = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);

        if (tabletSize == null) {
            dual = false;
            Intent intent=new Intent(this,DetailesActivity.class);
            intent.putExtra("source",String.valueOf(source));
            intent.putExtra("title",String.valueOf(title));
            intent.putExtra("body",String.valueOf(body));
            startActivity(intent);
        } else {
            dual = true;
            Log.e(TAG, "data heating postion ELSE : " + source+" - "+title+" - "+body);

            tabletSize.update_Info(source,title,body);

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
