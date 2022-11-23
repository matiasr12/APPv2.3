package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Fecha extends AppCompatActivity {
   Button Prender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_aplicacion);

        Prender = findViewById(R.id.Prender);

        Prender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("i","hola");
            }
        });

    }

}