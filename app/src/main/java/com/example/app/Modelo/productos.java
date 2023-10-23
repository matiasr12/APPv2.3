package com.example.app.Modelo;

public class productos {
    private String Direccion_del_local;
    private String Imagenurl;
    private String Kogramos;
    private String Precio;
    private String nTienda;
    private String nombreProducto;

    public productos(String direccion_del_local, String imagenurl, String kogramos, String precio, String nTienda, String nombreProducto) {
        Direccion_del_local = direccion_del_local;
        Imagenurl = imagenurl;
        Kogramos = kogramos;
        Precio = precio;
        this.nTienda = nTienda;
        this.nombreProducto = nombreProducto;
    }

    public productos() {
    }

    public String getDireccion_del_local() {
        return Direccion_del_local;
    }

    public void setDireccion_del_local(String direccion_del_local) {
        Direccion_del_local = direccion_del_local;
    }

    public String getImagenurl() {
        return Imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        Imagenurl = imagenurl;
    }

    public String getKogramos() {
        return Kogramos;
    }

    public void setKogramos(String kogramos) {
        Kogramos = kogramos;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getnTienda() {
        return nTienda;
    }

    public void setnTienda(String nTienda) {
        this.nTienda = nTienda;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
