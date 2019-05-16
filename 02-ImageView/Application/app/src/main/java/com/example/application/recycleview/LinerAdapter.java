package com.example.application.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application.R;

public class LinerAdapter extends RecyclerView.Adapter<LinerAdapter.LinerViewHolder> {

    private Context mContext;
    public LinerAdapter(Context c) {
        this.mContext = c;
    }

    @NonNull
    @Override
    public LinerAdapter.LinerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinerAdapter.LinerViewHolder viewHolder, int i) {
        viewHolder.textView.setText("Hello holder");
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    class LinerViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public LinerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view1);
        }
    }


}
