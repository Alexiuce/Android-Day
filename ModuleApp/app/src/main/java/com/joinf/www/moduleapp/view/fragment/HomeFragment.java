package com.joinf.www.moduleapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joinf.www.moduleapp.R;

/**
 * Created by caijinzhu on 2017/12/20.
 */

public class HomeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_layout,null);

        return view;
    }
}
