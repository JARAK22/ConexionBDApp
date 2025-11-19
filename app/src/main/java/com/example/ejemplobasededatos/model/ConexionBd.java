package com.example.ejemplobasededatos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBd extends SQLiteOpenHelper {
    public ConexionBd(@Nullable Context context) {
        super(context, Constantes.NAME_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DATOS(id INT PRIMARY KEY, " +
                        "nombre VARCHAR(50) NOT NULL, " +
                        "apellidos VARCHAR(100) NOT NULL, " +
                        "Correo TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS DATOS;");
    }
}
