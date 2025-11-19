package com.example.ejemplobasededatos.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ejemplobasededatos.R;
import com.example.ejemplobasededatos.model.ConexionBd;

public class MainActivity extends AppCompatActivity {

    ConexionBd conexionBd;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        conexionBd = new ConexionBd(this);
        db = conexionBd.getWritableDatabase();
        Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
    }
}