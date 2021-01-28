package com.example.nt2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

import com.example.nt2.R;
import com.example.nt2.pojo.Results;
import com.example.nt2.ui.Interface.MyCommunicator;
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
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //        currentFragment.update_Info("ac", "1", "2");


//        AllArticalsFragment  allArticalsFragment = new AllArticalsFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("source", String.valueOf(0));
//        allArticalsFragment.setArguments(bundle);
//        getFragmentManager().beginTransaction().replace(R.id.main_container, _detailesFragment).addToBackStack("tag").commit();

//        if(savedInstanceState == null)
//        {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.main_container, new AllArticals());
//        ft.commit();
//        }


//            getFragmentManager().beginTransaction().add(R.id.fragment_all,new AllArticals().commit();

//        View FDetailes=findViewById(R.id.fragment_detailes);
//        mIsDualPane=FDetailes.VISIBLE==View.VISIBLE;

//        Postes = new ArrayList<>();
//        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
//        postViewModel.getPosts();
//        recyclerView = findViewById(R.id.recycler);
//        adapter = new PostsAdapter();
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//
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

//    @Override
//    public void onItemClickCard(String source, String title, String body) {
//        Log.e(TAG, "data : " + source+title+body);
//
//        DetailesFragment currentFragment2 = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);
//        AllArticalsFragment currentFragment = (AllArticalsFragment) getSupportFragmentManager().findFragmentById(R.id.main_container);
//
//        if (currentFragment2 == null) {
//            currentFragment.dual = false;
//            Log.e(TAG, "data : " + false);
////            DetailesFragment _detailesFragment = new DetailesFragment();
////            Bundle bundle = new Bundle();
////            bundle.putString("source", String.valueOf(source));
////            bundle.putString("title", String.valueOf(title));
////            bundle.putString("body", String.valueOf(body)));
////            currentFragment.setArguments(bundle);
////            getFragmentManager().beginTransaction().replace(R.id.main_container, currentFragment).addToBackStack("tag").commit();
//
//        } else {
//            currentFragment.dual = true;
//            currentFragment2 = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);
//            currentFragment2.update_Info("ac", "1", "2");
//
//        }
//    }



    @Override
    public void heating(String source,String title,String body) {
        Log.e(TAG, "data heating postion : " + source+" - "+title+" - "+body);
        DetailesFragment currentFragment2 = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);
        AllArticalsFragment currentFragment = (AllArticalsFragment) getSupportFragmentManager().findFragmentById(R.id.main_container);

        if (currentFragment2 == null) {
            dual = false;
            Intent intent=new Intent(this,DetailesActivity.class);
            intent.putExtra("source",String.valueOf(source));
            intent.putExtra("title",String.valueOf(title));
            intent.putExtra("body",String.valueOf(body));
            startActivity(intent);
        } else {
            dual = true;
            Log.e(TAG, "data heating postion ELSE : " + source+" - "+title+" - "+body);

            currentFragment2.update_Info(source,title,body);

        }
    }

//    @Override
//    public void onItemClick(int postion) {
////        Fragment fragment_detailes2=getFragmentManager().findFragmentById(R.id.fragment_detailes_large);
//        Log.e(TAG, "PostionInMain : " + postion);
//        DetailesFragment currentFragment = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);
//
////        Fragment currentFragment = getFragmentManager().findFragmentById(R.id.fragment_detailes_large);
//
//        if (currentFragment == null) {
//            Intent intent = new Intent(this, DetailesActivity.class);
//            intent.putExtra("source", "Surces :" + String.valueOf(postion));
//            intent.putExtra("title", "Surces :" + String.valueOf(postion));
//            intent.putExtra("body", "Surces :" + String.valueOf(postion));
//
////            Fragment fragment_detailes = new Fragment_Detailes();
////            Bundle bundle = new Bundle();
////            bundle.putString("source", String.valueOf(Postes.get(postion).getSource()));
////            bundle.putString("title", String.valueOf(Postes.get(postion).getTitle()));
////            bundle.putString("body", String.valueOf(Postes.get(postion).getArticalbody()));
////            fragment_detailes.setArguments(bundle);
////            currentFragment.update_Info(String.valueOf(postion), "1", "2");
//
////            getFragmentManager().beginTransaction().replace(R.id.main_container, currentFragment).addToBackStack("tag").commit();
//
//        } else {
////            Fragment_Detailes fragment_detailes = new Fragment_Detailes();
//            Intent intent = new Intent(this, DetailesActivity.class);
//            intent.putExtra("source", "Surces :" + String.valueOf(postion));
//            intent.putExtra("title", "Surces :" + String.valueOf(postion));
//            intent.putExtra("body", "Surces :" + String.valueOf(postion));
//            currentFragment.update_Info(String.valueOf(postion), "1", "2");
//        }
//
////        Fragment_Detailes fragment_detailes = new Fragment_Detailes();
////        fragment_detailes=getFragmentManager().findFragmentById(R.id.fragment_detailes);
////        Bundle bundle = new Bundle();
////        bundle.putString("source", String.valueOf(Postes.get(postion).getSource()));
////        bundle.putString("title", String.valueOf(Postes.get(postion).getTitle()));
////        bundle.putString("body", String.valueOf(Postes.get(postion).getArticalbody()));
////        fragment_detailes.setArguments(bundle);
////        getFragmentManager().beginTransaction().replace(R.id.main_container, fragment_detailes).addToBackStack("tag").commit();
//
//    }
}
