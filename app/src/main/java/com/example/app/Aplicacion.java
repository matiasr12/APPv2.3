package com.example.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.app.Modelo.productos;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;


public class Aplicacion extends Fragment {

    EditText inputSearch;
    RecyclerView rv;
    FirestoreRecyclerOptions<productos> options;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // funcion para llamar en el frackmento
        View vista = inflater.inflate(R.layout.fragment_aplicacion, container, false);
        //rv = vista.findViewById(R.id.rv);
        //rv = getView().findViewById(R.id.rv);
        //searchView = vista.findViewById(R.id.search);
        //searchView = getView().findViewById(R.id.search);
        inputSearch = vista.findViewById(R.id.inputSearch);
        rv = vista.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv.setHasFixedSize(true);

        return vista;

    }


}