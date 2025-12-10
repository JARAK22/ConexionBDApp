package com.example.ejemplobasededatos.model;

public class Datos {
    private String nombre;
    private String apellido;
    private String correo;

    public Datos(){

    }

    public Datos(String nombre, String apellido, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }


    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
