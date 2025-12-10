package com.example.ejemplobasededatos.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemplobasededatos.R;
import com.example.ejemplobasededatos.model.Datos;
import com.example.ejemplobasededatos.model.Manager;

public class MostrarDatos extends AppCompatActivity {

    Manager manager;
    ListView listView;
    ArrayAdapter<Datos> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);


        listView = findViewById(R.id.listarDatos);

        manager = new Manager(MostrarDatos.this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, manager.listarData());

        listView.setAdapter(adapter);
    }



}