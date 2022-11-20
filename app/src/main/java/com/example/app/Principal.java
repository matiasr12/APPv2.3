package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        TabLayout tl =(TabLayout)  findViewById(R.id.tagprincipal);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {

                    case 0:
                        Portada p = new Portada();
                        getSupportFragmentManager().beginTransaction().replace(R.id.la1, p).commit();
                        break;
                    case 1:
                        Configuracion c = new Configuracion();
                        getSupportFragmentManager().beginTransaction().replace(R.id.la1, c).commit();
                        break;

                    case 2:
                        Aplicacion a = new Aplicacion();
                        getSupportFragmentManager().beginTransaction().replace(R.id.la1, a).commit();
                        break;

                    case 3:
                        Estadisticas e = new Estadisticas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.la1, e).commit();

                        break;

                    case 4:
                         Lucesepecificas  L= new Lucesepecificas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.la1,L).commit();
                        break;





                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}