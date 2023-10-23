package com.example.app.Modelo;

public class productos {


    private  String direccionDelLocal;
    private  String kiloOgramos;
    private  String  nombreProductos;
    private  String nombreTienda;
    private  String percio;

    public productos() {
    }

    public productos(String direccionDelLocal, String kiloOgramos, String nombreProductos, String nombreTienda, String percio) {
        this.direccionDelLocal = direccionDelLocal;
        this.kiloOgramos = kiloOgramos;
        this.nombreProductos = nombreProductos;
        this.nombreTienda = nombreTienda;
        this.percio = percio;
    }

    public String getDireccionDelLocal() {
        return direccionDelLocal;
    }

    public void setDireccionDelLocal(String direccionDelLocal) {
        this.direccionDelLocal = direccionDelLocal;
    }

    public String getKiloOgramos() {
        return kiloOgramos;
    }

    public void setKiloOgramos(String kiloOgramos) {
        this.kiloOgramos = kiloOgramos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getPercio() {
        return percio;
    }

    public void setPercio(String percio) {
        this.percio = percio;
    }
}
