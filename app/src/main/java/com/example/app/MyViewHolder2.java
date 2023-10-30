package com.example.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder2 extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView1,textView2;
    View vista;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img1);
        textView1 = itemView.findViewById(R.id.prodc1);
        textView2 = itemView.findViewById(R.id.prodc2);
        vista=itemView;

    }
}
