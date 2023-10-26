package com.example.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.Modelo.productos;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class Configuracion extends Fragment{

    EditText inputSearch,tiendas;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<productos> options;
    FirebaseRecyclerAdapter<productos, MyViewHolder> adapter;
    DatabaseReference DataRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // funcion para llamar en el frackmento
        View vista = inflater.inflate(R.layout.fragment_aplicacion, container, false);
        DataRef = FirebaseDatabase.getInstance().getReference().child("productos");
        inputSearch = vista.findViewById(R.id.inputSearch);
        recyclerView = vista.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        LoadData();


        return vista;

    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<productos>().setQuery(DataRef, productos.class).build();
        adapter = new FirebaseRecyclerAdapter<productos, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull productos model) {

                final String nTienda = model.getnTienda();
                holder.textView.setText(model.getnTienda());
                String Direccion_del_local = model.getDireccion_del_local();
                holder.textView.setText(model.getDireccion_del_local());

                Picasso.get().load(model.getImagenurl()).into(holder.imageView);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), Mainvistas.class);
                        intent.putExtra("productosKey", getRef(position).getKey());
                        startActivity(intent);

                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos, parent, false);
                return new MyViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
