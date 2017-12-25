package com.example.caijinzhu.inflatedemo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View inflateView;
    private ViewGroup rootView;
    private boolean isShowing;
    private LinearLayout pointContrainer;
    private TextView descTextView;
    private ViewPager viewPage;
    private int[] pictureIDArray;
    private ImageView[] imageViews;
    private ArrayList<ImageView> pictureArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (ViewGroup)findViewById(R.id.ll_main);

        /*方式1*/
//        inflateView = View.inflate(this, R.layout.inflate_view, null);

        /*方式2*/
//       inflateView = LayoutInflater.from(this).inflate(R.layout.inflate_view,null);

        /* 方式3 */
        LayoutInflater inflate = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        inflateView = inflate.inflate(R.layout.inflate_view,null);

        setupUI();
    }

    private void setupUI() {
        pointContrainer = (LinearLayout) findViewById(R.id.layout_pointContainer);
        descTextView = (TextView)findViewById(R.id.textView_scrollDescription);
        viewPage = (ViewPager) findViewById(R.id.viewPager_scrollViewPager);
        pictureIDArray = new int[]{R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};

        pictureArray = new ArrayList<ImageView>();

        ImageView imgView;
        for (int i = 0; i < pictureIDArray.length; i++){
            imgView = new ImageView(this);
            imgView.setBackgroundResource(pictureIDArray[i]);
            pictureArray.add(imgView);
        }
        viewPage.setAdapter(new ViewPagerAdapter());
    }


    public void show(View v){
        if (isShowing){return;}
        rootView.addView(inflateView);
        isShowing = true;

    }
    public void remove(View v){
        if (!isShowing){return;}
        isShowing = false;
        rootView.removeView(inflateView);

    }

    /** ViewPager 数据适配器类*/
    private class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return pictureArray.size();
        }


        /** 3. 判断是否需要复用
         * */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            // 当滑动新条目又返回时,view是否可以被复用
            // 返回判断规则
            return view == object;
        }

        /** 1. 返回要显示的条目
         * container : 就是ViewPager本身
         * position: 条目的位置
         * */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView =  pictureArray.get(position);
            container.addView(imageView);
            return imageView;
        }

        /**
         *  2.销毁 */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View)object);
        }
    }

}
