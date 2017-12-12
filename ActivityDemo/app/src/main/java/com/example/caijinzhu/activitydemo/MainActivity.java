package com.example.caijinzhu.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView smsList;
    private String[] sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        sms = new String[]{"我的祝福最霸道，收到你就没烦恼，白天黑夜乐淘淘；我的短信最美好，看后愁闷都得跑，轻松愉快才逍遥；我的信息最牢靠，幸福吉祥来笼罩，美梦成真在今朝；我的祝愿最着调，生日当天有爆料，欢歌笑语总围绕！",
                "你在我的心中扎根，我们的友谊露重更深；你在我的牵挂中缤纷，我们的情感喜大普奔；你在我的坦诚中光临，我们的心有灵犀更近；你在我的问候中欢欣，我们的关爱情不自禁；你在我的祝福中兴奋，祝你生日快乐开心！",
                "好友如梦似幻，日夜兼程思念，亲朋血脉相连，话语滋润心田，知音一生有缘，牵手幸福永远，挚爱看雨听蝉，开心快乐无边，知己晓得冷暖，经常相互惦念，我心与你相牵，送你灿烂心愿，祝你生日圆满，谱写壮丽诗篇！",
                "一捧香土藏奇葩，孕育种子发新芽，寄托情思千万里，一年四季绘新画；一滴细雨催鲜花，雨过天晴景色佳，朵朵相思满枝桠，千丝万缕放光华；一条短信给你发，祝你开心美潇洒，生日快乐伴随你，高枕无忧爱融洽！",
                "一年四季你在忙，辛苦奔波也安康，朋友恩情记心上，春夏秋冬不淡忘，多吃是福巧梳妆，早睡早起心敞亮，工作不要太疯狂，劳逸结合身体棒，朋友常聚人脉旺，游刃有余尽徜徉，我的短信圆梦想，生日快乐财源广！",
                "风霜雪雨走一路，日夜兼程不停步，笑泪各半掩双目，前途坎坷当散步，一程山水艰难赴，山穷水尽看萍浮，晨有朝霞夕落幕，潇洒走过就是福，仕途高低别在乎，工作舒心赚财富，我的短信似火炉，生日快乐常守护！",
                "距离有近有远，朋友相互惦念，时间有长有短，再忙也要见面，季节有早有晚，牵挂天地之间，岁月有冷有暖，贴心话语交谈，情谊有深有浅，要有短信相连，只要好友相伴，万事皆能圆满，祝你幸福绕牵，生日欢乐开颜！",
                "有山有水有风景，景色绚丽心放松，有意有爱有真情，情义无价爱与共，有风有雨有天空，天空晴朗任你行，有聚有缘有宾朋，亲友挚爱化寒冰，有来有往有憧憬，前程似锦美梦成，祝你生日最高兴，时刻都有新感动！",
                "意外的温暖，意外的感动，意外的关怀，意外的欣赏，意外的珍视，意外的美好。意外，其实不是意外；意外，其实是一种必然。我用温暖的微笑问候你，用如水的柔情拥抱你，用纯朴的真心陪伴你，用无瑕的美丽祝福你：亲，生日快乐，一生幸福！",
                "长长的距离手中的线，我对你的思念不会断，儿时的天真少年的浪漫，花开的季节情意缠绵，真挚的关爱无尽的情感，都是你的生日让我挂牵，虽然不能赶到你的面前，我的短信同样表达我的祝愿，谨祝生日快乐，幸福健康到永远！"
        };
        smsList = (ListView)findViewById(R.id.lv_smsListView);
        smsList.setAdapter(new Datasource());


        // cell 点击事件
        smsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Activity act = (Activity) parent.getContext();
//                Toast.makeText(getApplicationContext(),"asdfsdf",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(act,SplashActivity.class);
                it.putExtra("sms",sms[position]);
                act.startActivity(it);

            }
        });
    }


    private class Datasource extends BaseAdapter{
        @Override
        public int getCount() {
            return sms.length;
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
            View v;
            if (convertView == null){
                v = View.inflate(MainActivity.this,R.layout.item_layout,null);
            }else {
                v = convertView;
            }
            TextView tv = (TextView) v.findViewById(R.id.tv_item);
            tv.setText(sms[position]);
            return v;
        }
    }


    // MARK: - 按钮点击事件处理
    public void openNewActivity(View v){
        Intent it = new Intent(this,SplashActivity.class);


        // 传递数据到下个页面
//        Uri hello = Uri.parse("hello://world");
//        it.setData(hello);
//        startActivity(it);

        it.putExtra("name","alexiuce");
        startActivityForResult(it,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){

            System.out.println(data.getStringExtra("back"));
        }
    }



}
