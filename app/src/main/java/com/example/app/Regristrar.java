package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Modelo.Usuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Key;
import java.util.UUID;
public  class Regristrar  extends AppCompatActivity{
    FirebaseDatabase database;
    Button btnRegristrar;
    EditText etusuario,etcorreo,etcontraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regristrar);
        etusuario = (EditText) findViewById(R.id.etusuario);
        etcorreo = (EditText) findViewById(R.id.etcorreo);
        etcontraseña = (EditText) findViewById(R.id.etcontraseña);
        btnRegristrar = (Button) findViewById(R.id.btnRegristrar);
        btnRegristrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Regristrar.this, "Hola", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });
    }
    public  void insertar(){
        String NombreUsuario =etusuario.getText().toString();
        String correo =etcorreo.getText().toString();
        String contraseña =etcontraseña.getText().toString();
        String key = UUID.randomUUID().toString();
        Usuarios a = new Usuarios(key,NombreUsuario,correo,contraseña);
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("APPluces");
        myRef.child(key).setValue(a);


    }




}







