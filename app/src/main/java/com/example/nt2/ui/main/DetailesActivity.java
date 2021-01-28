package com.example.nt2.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.nt2.R;
import com.example.nt2.ui.fragment.DetailesFragment;

public class DetailesActivity extends AppCompatActivity {
    private String value_Title, value_Source, value_Body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes);
        Intent intent = getIntent();
        value_Source = intent.getStringExtra("source");
        value_Title = intent.getStringExtra("title");
        value_Body = intent.getStringExtra("body");
//            update_Info(value_Source, value_Title, value_Body);
//
        DetailesFragment currentFragment = (DetailesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detailes);
        currentFragment.update_Info(value_Source, value_Title, value_Body);


    }
}