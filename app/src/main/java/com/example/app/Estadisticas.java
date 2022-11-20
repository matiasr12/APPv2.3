package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app.Modelo.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Estadisticas extends Fragment {
    private ListView ListaUsuarios;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_estadisticas);
        //ListaUsuarios = (ListView) findViewById(R.id.ListaUsuarios);
        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
        cargarBd();

    }

    private void setContentView(int fragment_estadisticas) {
    }

    private void cargarBd() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
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

