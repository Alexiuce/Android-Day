 package com.example.caijinzhu.listviewdemo;

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

    private class DataSource extends BaseAdapter{
        @Override      // 返回条目数量
        public int getCount() {
            return 40;
        }

        @Override      // 返回position位置的对象
        public Object getItem(int position) {
            return null;
        }

        @Override       // 返回position位置对应的id
        public long getItemId(int position) {
            return 0;
        }

        @Override     // 相当于iOS中的cellForRow ,返回每行的视图
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView tv ;
            if (convertView != null){
                tv = (TextView) convertView;
            }else {
                tv = new TextView(MainActivity.this);
            }
            tv.setText("adfsadf" + position);
            return tv;
        }
    }
 }
