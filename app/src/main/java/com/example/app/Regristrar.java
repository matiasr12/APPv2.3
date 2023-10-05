package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public  class Regristrar  extends AppCompatActivity{

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private  Button btnRegristrar;
    private EditText etCorreo;
    private EditText etContrasena;
    private EditText etUsuario;
    private String email ="";
    private String password="";
    private String name="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        setContentView(R.layout.activity_regristrar);

        etCorreo=(EditText) findViewById(R.id.etCorreo);
        etContrasena=(EditText) findViewById(R.id.etContrasena);
        etUsuario=(EditText) findViewById(R.id.etUsuario);
        btnRegristrar=(Button) findViewById(R.id.btRegristrar);
        btnRegristrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=etCorreo.getText().toString();
                password=etContrasena.getText().toString();
                name=etUsuario.getText().toString();

                if(!name.isEmpty() && !email.isEmpty()  && !password.isEmpty()){
                    if(password.length() >= 6){

                    }else{
                        Toast.makeText(Regristrar.this, "La contraseña debe tener todos los caracteres ", Toast.LENGTH_SHORT).show();
                    }

                    registerUser();
                }
                else{
                    Toast.makeText(Regristrar.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void registerUser(){
        Toast.makeText(this, "CORREO: "+email, Toast.LENGTH_SHORT).show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                task.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("ERRORRRRRR!: ");
                        System.out.println(e.toString());
                    }
                });
               if(task.isSuccessful()){
                 Map<String, String> map = new HashMap<>();
                 map.put("email",email);
                 map.put("password",password);
                 map.put("name",name);
                 String id =  mAuth.getCurrentUser().getUid();

                 mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task2) {
                         if(task2.isSuccessful()){
                             startActivity(new Intent(Regristrar.this,MainActivity.class));
                             finish();
                         }else{
                             Toast.makeText(Regristrar.this, "no se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                         }

                     }
                 });


               }else{
                   Toast.makeText(Regristrar.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}








