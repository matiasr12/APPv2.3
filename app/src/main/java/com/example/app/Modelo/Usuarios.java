package com.example.app.Modelo;

public class Usuarios {
    public String key;
    public String NombreUsuario;
    public String IdCorreo;
    public String contraseña;

    public Usuarios() {
    }

    public Usuarios(String key, String NombreUsuario, String IdCorreo, String contraseña) {
        this.key = key;
        this.NombreUsuario = NombreUsuario;
        this.IdCorreo = IdCorreo;
        this.contraseña = contraseña;

    }

    public static void add(Usuarios a) {
    }

    @Override
    public String toString() {
        return "Nombre:" +this.NombreUsuario+" Correo: "+this.IdCorreo;
    }
}




