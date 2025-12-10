package com.example.ejemplobasededatos.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ejemplobasededatos.R;
import com.example.ejemplobasededatos.model.ConexionBd;
import com.example.ejemplobasededatos.model.Datos;
import com.example.ejemplobasededatos.model.Manager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Manager manager;

    TextInputEditText txtnombre, txtapellido, txtcorreo;
    MaterialButton btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.edNombre);
        txtapellido = findViewById(R.id.edApellido);
        txtcorreo = findViewById(R.id.edCorreo);
        btnenviar = findViewById(R.id.btnEnviar);


        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = new Manager(MainActivity.this);

                String nombre = txtnombre.getText().toString();
                String apellido = txtapellido.getText().toString();
                String correo = txtcorreo.getText().toString();

                // Pasamos los valores al pojo
                Datos datos = new Datos(nombre, apellido, correo);

                // Llamamos al metodo insertar
                long resul = manager.insertData(datos);

                if (resul > 0){
                    Toast.makeText(MainActivity.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error al insertar datos", Toast.LENGTH_SHORT).show();
                }

                iniciar(view);
            }
        });
    }

    public void iniciar(View view){
        Intent MoverActivity = new Intent(MainActivity.this, MostrarDatos.class);
        startActivity(MoverActivity);
    }
}