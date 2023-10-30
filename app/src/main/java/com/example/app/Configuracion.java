package com.example.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.app.Modelo.productos;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;


public class Configuracion extends Fragment{

    EditText inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<productos> options;
    FirebaseRecyclerAdapter<productos, MyViewHolder2> adapter;
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

        LoadData("");
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString()!=null){
                    LoadData(editable.toString());
                }else{
                    LoadData("");
                }

            }
        });


        return vista;

    }

    private void LoadData(String data) {
        Query query = DataRef.orderByChild("nTienda").endAt(data+"\uf8ff");
        options = new FirebaseRecyclerOptions.Builder<productos>().setQuery(query, productos.class).build();
        adapter = new FirebaseRecyclerAdapter<productos, MyViewHolder2>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder2 holder, final int position, @NonNull productos model) {

                final String nTienda = model.getnTienda();
                holder.textView1.setText(model.getnTienda());
                holder.textView2.setText(model.getDireccion_del_local());

                Picasso.get().load(model.getImagenurl()).into(holder.imageView);


            }

            @NonNull
            @Override
            public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiendas, parent, false);
                return  new MyViewHolder2(v);

            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
