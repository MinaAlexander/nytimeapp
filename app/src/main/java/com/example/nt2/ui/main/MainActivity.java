package com.example.nt2.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.nt2.R;
import com.example.nt2.ui.fragment.DetailesFragment;
import com.example.nt2.ui.fragment.PostsFragment;

public class MainActivity extends AppCompatActivity implements PostsFragment.onHeatLisener {
    private static String TAG = "MainActivity";
    public static Boolean dual;
    private PostsFragment postsFragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsFragment = new PostsFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, postsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void heating(String source, String title, String body) {
        Log.e(TAG, "data1 : " + source + " - " + title + " - " + body);
        DetailesFragment tabletSize = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes_large);

        if (tabletSize == null) {
            dual = false;
            Intent intent = new Intent(this, DetailesActivity.class);
            intent.putExtra("source", String.valueOf(source));
            intent.putExtra("title", String.valueOf(title));
            intent.putExtra("body", String.valueOf(body));
            startActivity(intent);
        } else {
            dual = true;
            Log.e(TAG, "data2: " + source + " - " + title + " - " + body);

            tabletSize.update_Info(source, title, body);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
