package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class prueba {


    public class Aplicacion extends Fragment {
        DatabaseReference ref;
      //  ArrayList<productos> list;
        RecyclerView rv;
        SearchView searchView;
       // adapterproductos adapter;
        LinearLayoutManager lm;




        //  @Override
        //   public void onCreate(Bundle savedInstanceState) {
        //     super.onCreate(savedInstanceState);
        //    mFirestore = FirebaseFirestore.getInstance();



        //   }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // funcion para llamar en el frackmento
            View vista = inflater.inflate(R.layout.fragment_aplicacion, container, false);
            ref = FirebaseDatabase.getInstance().getReference().child("Productos");
            rv = vista.findViewById(R.id.rv);
            //rv = getView().findViewById(R.id.rv);
           // searchView = vista.findViewById(R.id.search);
            //searchView = getView().findViewById(R.id.search);
            lm = new LinearLayoutManager(getContext());
            rv.setLayoutManager(lm);
          //  list = new ArrayList<>();
      //      adapter = new adapterproductos(list);
            // rv.setAdapter(adapter);
            ref.addValueEventListener(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            //          productos ms = snapshot.getValue(productos.class);
                            //         list.add(ms);
                        }
                        //      adapter.notifyDataSetChanged();

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            return vista;


        }





    }
}
