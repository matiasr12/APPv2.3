package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Configuracion extends Fragment implements  OnMapReadyCallback{

    private GoogleMap myMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        //SupportMapFragment mapFragment = (SupportMapFragment) getParentFragmentManager().findFragmentById(R.id.map);
       // mapFragment.getMapAsync(this);
        Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


    }
}