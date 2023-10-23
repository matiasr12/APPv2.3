package com.example.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;



public class Estadisticas extends Fragment {
    private static final int REQUEST_CODE = 1;
    Button btguardar;
    EditText nTienda;
    EditText nProducto;
    EditText Kogramos;
    EditText Precio;
    EditText Dlocal;
    ImageView imagenViewadd;
    Uri imagenUri;
    Boolean isImageAdded;

    DatabaseReference Dataref;
    StorageReference Storageref;

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
        imagenViewadd = v.findViewById(R.id.imagenViewadd);

        Dataref = FirebaseDatabase.getInstance().getReference().child("productos");
        Storageref = FirebaseStorage.getInstance().getReference().child("productosImg");

        imagenViewadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nombreProducto = nProducto.getText().toString();
                if (isImageAdded && nombreProducto != null) {
                    uploadImagen(nombreProducto);
                } else {
                    Toast.makeText(getContext(), "Debes seleccionar una imagen y proporcionar un nombre de producto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private void uploadImagen(final String nombreProducto) {
        final String key = Dataref.push().getKey();
        Storageref.child(key + ".jpg").putFile(imagenUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Storageref.child(key + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("nombreProducto", nombreProducto);
                        hashMap.put("nTienda", nTienda.getText().toString()); // Guardar el nombre de la tienda
                        hashMap.put("Kogramos", Kogramos.getText().toString());
                        hashMap.put("Precio", Precio.getText().toString());
                        hashMap.put("Direccion del local", Dlocal.getText().toString());
                        hashMap.put("Imagenurl", uri.toString());
                        // Subir los datos a Firebase Realtime Database bajo una clave única
                        Dataref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getView().getContext(), "Producto registrado con éxito", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data!=null) {
            imagenUri = data.getData();
            isImageAdded = true;
            imagenViewadd.setImageURI(imagenUri);
        }
    }
}