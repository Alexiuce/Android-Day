package com.example.alexcai.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

/**
 * Created by caijinzhu on 2017/10/25.
 */

public class ContactActivity extends AppCompatActivity {

    private ListView contactListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setupUI();
    }

    private void setupUI() {

        contactListView = (ListView)findViewById(R.id.lv_contact);


    }
}
