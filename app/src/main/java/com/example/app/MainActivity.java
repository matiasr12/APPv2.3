package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity  {
    Button Registrar;
    private EditText etCorreo;
    private EditText etContrasena;
    private EditText etUsuario;
    private Button Conectar;
    private String email ="";
    private String password="";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Registrar=(Button)findViewById(R.id.Registrar);

        mAuth = FirebaseAuth.getInstance();
        etCorreo=(EditText) findViewById(R.id.etCorreo);
        etContrasena=(EditText) findViewById(R.id.etContrasena);
        Conectar=(Button) findViewById(R.id.Conectar);

        Conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etCorreo.getText().toString();
                password= etContrasena.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    LoginUser();
                }else{
                    Toast.makeText(MainActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Registrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Regristrar.class);
                startActivity(i);

            }
        });
      

    }

    private void LoginUser() {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  startActivity(new Intent(MainActivity.this,Principal.class));
                  finish();

              }else{
                  Toast.makeText(MainActivity.this, "No se pudo iniciar", Toast.LENGTH_SHORT).show();
              }
            }
        });


    }


    public  void  crearCuenta(View v){
        Intent i = new Intent(this,Regristrar.class);
         startActivity(i);
       }

       }






