package com.example.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app.Modelo.Usuarios;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Estadisticas extends Fragment {
    Button btguardar;
    EditText nTienda;
    EditText nProducto;
    EditText Kogramos;
    EditText Precio;
    EditText Dlocal;


    // funcion del regristro de datos de la tienda
    static final int REQUEST_IMAGEN_CAPTURE =1;
    private DatabaseReference mStorage;
    private FirebaseFirestore mfirestore;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mStorage = FirebaseDatabase.getInstance().getReference();
        mfirestore = FirebaseFirestore.getInstance();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        nTienda = v.findViewById(R.id.nTienda);
        nProducto = v.findViewById(R.id.nProducto);
        Kogramos = v.findViewById(R.id.Kogramos);
        Precio = v.findViewById(R.id.Precio);
        Dlocal = v.findViewById(R.id.Dlocal);
        btguardar = v.findViewById(R.id.btguardar);
        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreTienda = nTienda.getText().toString().trim();
                String nombreProductos = nProducto.getText().toString().trim();
                String kilosOgramos = Kogramos.getText().toString().trim();
                String precio = Precio.getText().toString().trim();
                String dlocal = Dlocal.getText().toString().trim();

                if(nombreTienda.isEmpty() && nombreProductos.isEmpty() && kilosOgramos.isEmpty() && precio.isEmpty() && dlocal.isEmpty()){
                    Toast.makeText(requireContext(), "Debe completar los datos ", Toast.LENGTH_SHORT).show();

                }else{
                    postTiendas(nombreTienda,nombreProductos,kilosOgramos,precio,dlocal);
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombreTienda",nombreTienda);
                    map.put("nombreProductos",nombreProductos);
                    map.put("kiloOgramos",kilosOgramos);
                    map.put("percio",precio);
                    map.put("direccionDelLocal",dlocal);

                    mfirestore.collection("Productos").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(requireContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(requireContext(), "Error al ingresar ", Toast.LENGTH_SHORT).show();

                        }
                    });

                }




            }
        });






        return v;
    }

    private void postTiendas(String nombreTienda, String nombreProductos, String kilosOgramos, String precio, String dlocal) {
    }


}

