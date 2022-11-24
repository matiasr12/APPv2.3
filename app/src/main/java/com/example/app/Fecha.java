package com.example.app;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import androidx.appcompat.app.AppCompatActivity;

public class Fecha extends AppCompatActivity {
    TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_aplicacion);

        textview1=findViewById(R.id.textview1);
        textview1.setText(getCurrentTime());



    }
   private  String getCurrentTime(){
       return new SimpleDateFormat("hh:mm", Locale.getDefault()).format(new Date());

   }


    }


