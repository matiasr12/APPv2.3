package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Mainvistas extends AppCompatActivity {



    ImageView imageView;
    TextView prdictps1,prdictps2,prdictps3,prdictps4,produc22;
    Button Editbt;
    DatabaseReference Ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainvistas);
        prdictps1 = findViewById(R.id.produc);
        prdictps2 = findViewById(R.id.produc2);
        prdictps3 = findViewById(R.id.produc3);
        prdictps4 = findViewById(R.id.produc4);
        produc22 = findViewById(R.id.produc22);
        Editbt = findViewById(R.id.Editbt);
        imageView=findViewById(R.id.img2);



        Ref = FirebaseDatabase.getInstance().getReference().child("productos");
        String productosKey=getIntent().getStringExtra("productosKey");
        Ref.child(productosKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String nombreProducto = snapshot.child("nombreProducto").getValue().toString();
                    String Imagenurl = snapshot.child("Imagenurl").getValue().toString();
                    String Kogramos = snapshot.child("Kogramos").getValue().toString();
                    String Precio =snapshot.child("Precio").getValue().toString();
                    String nTienda =snapshot.child("nTienda").getValue().toString();
                    String  Direccion_del_local = snapshot.child("Direccion_del_local").getValue().toString();


                    Picasso.get().load(Imagenurl).into(imageView);
                    prdictps1.setText(nombreProducto);
                    prdictps2.setText(Kogramos);
                    prdictps3.setText(Precio);
                    prdictps4.setText(nTienda);
                    produc22.setText(Direccion_del_local);

                    Editbt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(Mainvistas.this,MainActivity2.class);
                            i.putExtra("nombreProducto",nombreProducto);
                            startActivity(i);



                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}