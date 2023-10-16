package com.example.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.Modelo.Productos;
import com.example.app.adapter.ProductosAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class Aplicacion extends Fragment {

    RecyclerView mRecyle;
    ProductosAdapter mAdapter;
    FirebaseFirestore mFirestore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirestore = FirebaseFirestore.getInstance();
        //mRecyle = requireView().findViewById(R.id.RecyclerView1);
        //mRecyle.setLayoutManager(new LinearLayoutManager(this));




    }

    //  @Override
    //  public void onStart() {
        //      super.onStart();
        //      mAdapter.startListening();
        // }

   // @Override
    // // public void onStop() {
    //  super.onStop();
    //  mAdapter.stopListening();
    // }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_aplicacion, container, false);


    }


}