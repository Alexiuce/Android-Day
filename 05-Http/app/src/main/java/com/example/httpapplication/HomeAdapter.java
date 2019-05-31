package com.example.httpapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList mDatas;
    private LayoutInflater mInflater;
    private HomeViewHolder mViewHolder;
    public HomeAdapter(Context ctx, ArrayList datas){
        mContext = ctx;
        mDatas = datas;
        mInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final String text = (String) getItem(position);
        if (convertView == null){
            mViewHolder = new HomeViewHolder();
            convertView = mInflater.inflate(R.layout.item_home_text_layout,parent,false);
            mViewHolder.textView = convertView.findViewById(R.id.item_text_view);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (HomeViewHolder) convertView.getTag();
        }

        mViewHolder.textView.setText(text);
        return convertView;
    }


    private static class HomeViewHolder{

        private TextView textView;

    }


}
