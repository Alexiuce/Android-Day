package com.example.caijinzhu.listviewdemo;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by caijinzhu on 2017/11/3.
 */

public class DataSource extends BaseAdapter{

    @Override
    public int getCount() {
        return 40;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View cellView;
        Activity act = (Activity) parent.getContext();
        if (convertView != null){
            cellView =  convertView;
        }else {
            cellView = View.inflate(parent.getContext(), R.layout.main_cell_item, null);
        }
        TextView titleView = (TextView) cellView.findViewById(R.id.tv_titleView);
        titleView.setText("from xml view" + position);

        ImageView icon = (ImageView) cellView.findViewById(R.id.iv_iconView);

        int index = position % 10 + 1;
        String picName = "icon" + index ;

        Application app = act.getApplication();
        int id = act.getResources().getIdentifier(picName,"drawable",app.getPackageName());
        icon.setImageResource(id);
        return cellView;
    }
}
