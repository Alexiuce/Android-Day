package com.example.httpapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    /**
     *  UI
     */
    private View mContentView;
    private ListView mListView;
    private ImageView mLoadingView;
    private Context mContent;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_home_layout,container,false);
        setupUI();
        return mContentView;
    }

    private void setupUI() {
        mContent = getActivity();
        mListView = mContentView.findViewById(R.id.home_list_view);
        mLoadingView = mContentView.findViewById(R.id.home_loading_view);
        showSuccessView();
    }



    private void showSuccessView(){
        mLoadingView.setVisibility(View.GONE);
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("good");
        list.add("World");
        HomeAdapter ad = new HomeAdapter(mContent,list);
        mListView.setAdapter(ad);
    }



}
