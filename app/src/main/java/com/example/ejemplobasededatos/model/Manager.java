package com.example.ejemplobasededatos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Manager {

    private ConexionBd conexionBd;
    private SQLiteDatabase db;

    public Manager(Context context){
        conexionBd = new ConexionBd(context);
    }

    public void openBdWr(){
        // abre la base de datos en modo escritura
        db = conexionBd.getWritableDatabase();
    }

    public void openDbRd(){
        // abre la base de datos en modo lectura
        db = conexionBd.getReadableDatabase();
    }
}
