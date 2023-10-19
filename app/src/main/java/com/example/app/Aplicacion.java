package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.app.Modelo.productos;
import com.example.app.adapter.adapterproductos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class Aplicacion extends Fragment {
    DatabaseReference ref;
    ArrayList<productos> list;
    RecyclerView rv;
    SearchView searchView;
    adapterproductos adapter;
    LinearLayoutManager lm;




  //  @Override
    //   public void onCreate(Bundle savedInstanceState) {
    //     super.onCreate(savedInstanceState);
    //    mFirestore = FirebaseFirestore.getInstance();



    //   }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ref = FirebaseDatabase.getInstance().getReference().child("Productos");
        rv = getView().findViewById(R.id.rv);
        searchView = getView().findViewById(R.id.search);
        //lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        list = new ArrayList<>();
        adapter = new adapterproductos(list);
        rv.setAdapter(adapter);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        productos ms = snapshot.getValue(productos.class);
                        list.add(ms);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscar(s);
                return false;
            }
        });

        return inflater.inflate(R.layout.fragment_aplicacion, container, false);


    }

    private void buscar(String s) {
        ArrayList<productos>milista = new ArrayList<>();
        for(productos obj: list){
            if(obj.getNombreProductos().toLowerCase().contains(s.toLowerCase()));
            milista.add(obj);
        }
        adapterproductos  adapter = new adapterproductos(milista);
        rv.setAdapter(adapter);
    }



}