package com.tutorials.hp.jsongridview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.tutorials.hp.jsongridview.m_JSON.JSONDownloader;

public class MainActivity extends AppCompatActivity {

    String jsonURL="http://jsonplaceholder.typicode.com/users";
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      gv= (GridView) findViewById(R.id.gv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this,jsonURL,gv).execute();
            }
        });
    }
}
