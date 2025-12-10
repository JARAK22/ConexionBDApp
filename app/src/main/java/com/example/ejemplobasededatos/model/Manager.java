package com.example.ejemplobasededatos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

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

    public void closeBd(){
        db.close();
    }

    public long insertData(Datos datos){
        openBdWr();
        ContentValues values = new ContentValues();
        values.put("nombre", datos.getNombre());
        values.put("apellidos", datos.getApellido());
        values.put("correo", datos.getCorreo());
        long id = db.insert("DATOS", null, values);
        return id;
    }

    public ArrayList<Datos> listarData(){
        openDbRd();
        ArrayList<Datos> lista = new ArrayList<>();

        String sql = "SELECT * FROM DATOS";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do {
                // Crear un objeto nuevo por cada fila/registro
                Datos datos = new Datos();

                // Extraer los datos del Cursor usando los nombres de las columnas:
                /*
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellidos"));
                String correo = cursor.getString(cursor.getColumnIndexOrThrow("correo"));
                */
                // Asignar esos valores al objeto 'datos' usando los setters:
                datos.setNombre(cursor.getString(0));
                datos.setApellido(cursor.getString(1));
                datos.setCorreo(cursor.getString(2));

                // Añadir el objeto completo a la lista
                lista.add(datos);

            } while(cursor.moveToNext());
        }
        // Cierre de recursos crucial
        cursor.close();
        closeBd();

        // Devolver la lista
        return lista;
    }
}
