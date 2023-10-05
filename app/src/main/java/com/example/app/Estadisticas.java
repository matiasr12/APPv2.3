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
import android.widget.ListView;

import com.example.app.Modelo.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Estadisticas extends Fragment {

    // funcion del regristro de datos de la tienda
    static final int REQUEST_IMAGEN_CAPTURE =1;
    private DatabaseReference mStorage;
    private ListView ListaUsuarios;
    ListView lvUsuarios;
    ArrayList<Usuarios> Usuario;
    ArrayAdapter<Usuarios> adpUsuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStorage = FirebaseDatabase.getInstance().getReference();



    }
    public  void tomar_foto(View v)
    {
        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getActivity().getPackageManager())!=null){
            startActivityForResult(takePictureIntent,REQUEST_IMAGEN_CAPTURE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estadisticas, container, false);
       // ListaUsuarios = (ListView) v.findViewById(R.id.lvUsuarios);
        //ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
        //cargarBd();
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

