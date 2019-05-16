package com.example.application.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.application.R;

public class LineRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_recycle_view);
        setupRecycleView();
    }

    private void setupRecycleView() {
        RecyclerView review = findViewById(R.id.recycle_view1);
        review.setLayoutManager(new LinearLayoutManager(LineRecycleViewActivity.this));
        review.setAdapter(new LinerAdapter(LineRecycleViewActivity.this));
    }
}
