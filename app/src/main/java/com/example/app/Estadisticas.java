package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;


public class Estadisticas extends Fragment {
    Button btguardar,btnimg;
    EditText nTienda;
    EditText nProducto;
    EditText Kogramos;
    EditText Precio;
    EditText Dlocal;
    EditText namegame;


    // funcion del regristro de datos de la tienda
    static final int REQUEST_IMAGEN_CAPTURE =1;
    private DatabaseReference mStorage;
    StorageReference storageReference;
    private FirebaseFirestore mfirestore;
//homa

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mStorage = FirebaseDatabase.getInstance().getReference();
        mfirestore = FirebaseFirestore.getInstance();
       storageReference= FirebaseStorage.getInstance().getReference();
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
        btnimg = v.findViewById(R.id.btnimg);


        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();

            }
        });

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

