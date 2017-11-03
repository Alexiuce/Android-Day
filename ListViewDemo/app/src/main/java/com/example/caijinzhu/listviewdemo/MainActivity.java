 package com.example.caijinzhu.listviewdemo;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity  {

     private ListView lv;   // listView;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lv = (ListView)findViewById(R.id.lv_listView);
         lv.setAdapter(new DataSource());

     }

 }
