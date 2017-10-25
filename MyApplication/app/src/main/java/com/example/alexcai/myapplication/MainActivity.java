package com.example.alexcai.myapplication;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickForSP(View v){
        System.out.println("click for sp demo");

        /* 获取sp */
        SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        /*使用sp eidt进行存储*/
        SharedPreferences.Editor edit = userInfo.edit();
        edit.putString("username","alexiuce");
        edit.commit();


    }
    public void clickForReadsp(View v){
        SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        String username = userInfo.getString("username","empty");

        /*方式1 ： 默认样式*/
//        Toast.makeText(this,"获取的sp值"+ username,Toast.LENGTH_SHORT).show();

        /* 方式2: 自定义位置 */
        Toast toast = Toast.makeText(this, "sp值:" + username, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        
        /*带图片的toast*/

//        Toast toast1 = Toast.makeText(this, "带图片显示sp值：" + username, Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.CENTER,0,0);
//        LinearLayout view = (LinearLayout) toast1.getView();
//        view.setOrientation(LinearLayout.HORIZONTAL);
//
//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.mipmap.ic_launcher);
//        view.addView(imageView);
//        toast1.show();

        /* */

    }

    public void clickForAlert(View v){
       /* 1. 创建alert builder*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /*1.1 设置builder的内容样式*/
//        builder.setMessage("这是内容部分");
        builder.setTitle("这是标题");


        final String[] items = {"one item","two item","three item"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"点击了 cancle btn",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNeutralButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"clikc sure btn",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        /*2. 通过builer 创建 dialog*/
        AlertDialog alertDialog = builder.create();
        /*3. 显示 dialog*/
        alertDialog.show();

    }



}
