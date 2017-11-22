package com.example.caijinzhu.mobilesafeguard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;

    private String[] mTitles;

    private int[] mImageIDs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        setupGridViewData();
    }

    private void setupGridViewData() {
    mTitles =  new String[]{
          "手机防盗","通信卫士","软件管理","进程管理","流量统计","手机杀毒","缓存清理","高级工具","设置中心"
        };

    mImageIDs = new int[]{R.mipmap.home_safe,R.mipmap.home_callmsgsafe,R.mipmap.home_apps,
            R.mipmap.home_taskmanager,R.mipmap.home_netmanager,R.mipmap.home_trojan,
            R.mipmap.home_sysoptimize,R.mipmap.home_tools,R.mipmap.home_settings
    };

    mGridView.setAdapter( new MyAdapter());
    }


    private void setupUI(){
        mGridView = (GridView)findViewById(R.id.gridView);
    }


    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public Object getItem(int position) {
            return mTitles[position];
        }

        @Override
        public long getItemId(int position) {
            return mImageIDs[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(),R.layout.gridview_item,null);

            TextView textview = (TextView) view.findViewById(R.id.gridItem_textView);
            textview.setText(mTitles[position]);

            ImageView imageView = (ImageView) view.findViewById(R.id.girdItem_imageView);
            imageView.setBackgroundResource(mImageIDs[position]);

            return view;
        }
    }
}
