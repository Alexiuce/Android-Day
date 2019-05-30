package com.example.httpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.httplibrary.HttpTool;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mHomeIconView,mClassifyIconView,mDiscoveryIconView,mProfileIconView;
    private RelativeLayout mHomeLayout,mClassifyLayout,mDiscoveryLayout,mProfileLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        HttpTool.fetchData();

    }

    private void setupUI() {
        mHomeIconView = findViewById(R.id.tab_home_icon);
        mHomeLayout = findViewById(R.id.tab_home_layout);
        mHomeLayout.setOnClickListener(this);
        mClassifyIconView = findViewById(R.id.tab_classify_icon);
        mClassifyLayout = findViewById(R.id.tab_classify_layout);
        mClassifyLayout.setOnClickListener(this);
        mDiscoveryIconView = findViewById(R.id.tab_discovery_icon);
        mDiscoveryLayout = findViewById(R.id.tab_discovery_layout);
        mDiscoveryLayout.setOnClickListener(this);
        mProfileIconView = findViewById(R.id.tab_profile_icon);
        mProfileLayout = findViewById(R.id.tab_profile_layout);
        mProfileLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tab_home_layout:
                mHomeIconView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mClassifyIconView.setBackgroundResource(R.drawable.comui_tab_message);
                mDiscoveryIconView.setBackgroundResource(R.drawable.comui_tab_person);
                mProfileIconView.setBackgroundResource(R.drawable.comui_tab_pond);
                break;
            case R.id.tab_classify_layout:
                mClassifyIconView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mHomeIconView.setBackgroundResource(R.drawable.comui_tab_home);
                mDiscoveryIconView.setBackgroundResource(R.drawable.comui_tab_person);
                mProfileIconView.setBackgroundResource(R.drawable.comui_tab_pond);
                break;
            case R.id.tab_discovery_layout:
                mDiscoveryIconView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                mClassifyIconView.setBackgroundResource(R.drawable.comui_tab_message);
                mHomeIconView.setBackgroundResource(R.drawable.comui_tab_home);
                mProfileIconView.setBackgroundResource(R.drawable.comui_tab_pond);
                break;
            case R.id.tab_profile_layout:
                mProfileIconView.setBackgroundResource(R.drawable.comui_tab_pond_selected);
                mClassifyIconView.setBackgroundResource(R.drawable.comui_tab_message);
                mDiscoveryIconView.setBackgroundResource(R.drawable.comui_tab_person);
                mHomeIconView.setBackgroundResource(R.drawable.comui_tab_home);
                break;
        }
    }
}
