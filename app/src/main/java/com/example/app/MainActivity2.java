package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.Modelo.productos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {

    private EditText nombre, kilos, Precio, tienda, direccion;
    private Button btnActualizar;

    private FirebaseDatabase database;
    private DatabaseReference productosRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.ednombre);
        kilos = findViewById(R.id.edkilos);
        Precio = findViewById(R.id.edprecio);
        tienda = findViewById(R.id.edtienda);
        direccion = findViewById(R.id.eddirecciom);
        btnActualizar = findViewById(R.id.btnActualizar);

        database = FirebaseDatabase.getInstance();
        productosRef = database.getReference("productos");

        // Obtén el nombre del producto que deseas editar (clave única).
        final String nombreProducto = getIntent().getStringExtra("nombreProducto");

        productosRef.orderByChild("nombreProducto").equalTo(nombreProducto).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    productos  producto = snapshot.getValue(productos.class);
                    if (producto != null) {
                        nombre.setText(producto.getNombreProducto());
                        kilos.setText(producto.getKogramos());
                        Precio.setText(producto.getPrecio());
                        tienda.setText(producto.getnTienda());
                        direccion.setText(producto.getDireccion_del_local());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombreProducto = nombre.getText().toString();
                String kilogramos = kilos.getText().toString();
                String nTienda = tienda.getText().toString();
                String nuevaDireccionLocal = direccion.getText().toString();
                String precio = Precio.getText().toString();

                // Actualiza los datos del producto utilizando el nombre del producto como clave.
                productosRef.orderByChild("nombreProducto").equalTo(nombreProducto).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            snapshot.getRef().child("nombreProducto").setValue(nuevoNombreProducto);
                            snapshot.getRef().child("Kogramos").setValue(kilogramos);
                            snapshot.getRef().child("Precio").setValue(precio);
                            snapshot.getRef().child("nTienda").setValue(nTienda);
                            snapshot.getRef().child("Direccion_del_local").setValue(nuevaDireccionLocal);
                        }
                        Toast.makeText(MainActivity2.this, "Producto actualizado con éxito", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}