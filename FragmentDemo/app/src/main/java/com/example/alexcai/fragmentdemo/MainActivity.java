package com.example.alexcai.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TopFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_bottomLayout,new BottomFragment());

        fragmentTransaction.commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

        Toast.makeText(this, uri.toString(),Toast.LENGTH_SHORT).show();

    }

    public void updateTopFragment(String text){
        TopFragment top = (TopFragment) getFragmentManager().findFragmentById(R.id.fragment_top);
        top.updateText(text);

    }
}
