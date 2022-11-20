package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.app.Modelo.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {
    FirebaseDatabase database;
    ListView ListaUsuarios;
    ArrayList<Usuarios> usuarios;
    ArrayAdapter<Usuarios> adaptadorUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_estadisticas);
        ListaUsuarios = (ListView) findViewById(R.id.ListaUsuarios);
        usuarios = new ArrayList<Usuarios>();
        cargarBd();

    }

    private void cargarBd() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference UsuarioRef = database.getReference("APPluces");
        ValueEventListener UsuarioListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d: snapshot.getChildren()) {
                    String key = d.child("key").getValue().toString();
                    String NombreUsuario= d.child("usuario").getValue().toString();
                    String IdCorreo=d.child("correo").getValue().toString();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Un error");
            }
        };
        UsuarioRef.addValueEventListener(UsuarioListener);

    }

}