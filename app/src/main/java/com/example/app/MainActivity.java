package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;


public class MainActivity extends AppCompatActivity  {
    Button Registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Registrar=(Button)findViewById(R.id.Registrar);

        Registrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Regristrar.class);
                startActivity(i);

            }
        });


    }

    public void login(View v){
        //Validador de login
        EditText campo1 = this.findViewById(R.id.Correo);
        String Correo = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.Contraseña);
        String Contraseña = campo2.getText().toString();
        System.out.println(Correo+" "+Contraseña);

        if(Correo.equals("c1") && Contraseña.equals("123")){
            Intent i = new Intent(this,Principal.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Erro en sus credenciales", Toast.LENGTH_LONG).show();

        }

        }
       public  void  crearCuenta(View v){
        Intent i = new Intent(this,Regristrar.class);
         startActivity(i);
       }

       }






