package com.example.teatroapp.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CarritoInfo {
    private int idCarrito;
    private int idObraSala;
    private String tituloObra;
    private String imagenObra;
    private String nombreSala;
    private int duracionObra;
    private String fechaFuncion;
    private String horaFuncion;
    private BigDecimal precioObra;
    private int cantidad;

    public CarritoInfo(int idCarrito, int idObraSala, String tituloObra, String imagenObra, String nombreSala, int duracionObra, String fechaFuncion, String horaFuncion, BigDecimal precioObra, int cantidad) {
        this.idCarrito = idCarrito;
        this.idObraSala = idObraSala;
        this.tituloObra = tituloObra;
        this.imagenObra = imagenObra;
        this.nombreSala = nombreSala;
        this.duracionObra = duracionObra;
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.precioObra = precioObra;
        this.cantidad = cantidad;
    }

    public CarritoInfo(int idCarrito, String tituloObra, String imagenObra, String nombreSala, int duracionObra,
                       String fechaFuncion, String horaFuncion, BigDecimal precioObra, int cantidad) {
        this.idCarrito = idCarrito;
        this.tituloObra = tituloObra;
        this.imagenObra = imagenObra;
        this.nombreSala = nombreSala;
        this.duracionObra = duracionObra;
        this.fechaFuncion = fechaFuncion;
        this.horaFuncion = horaFuncion;
        this.precioObra = precioObra;
        this.cantidad = cantidad;
    }

    // Agrega getters y setters según sea necesario


    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdObraSala() {
        return idObraSala;
    }

    public void setIdObraSala(int idObraSala) {
        this.idObraSala = idObraSala;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getImagenObra() {
        return imagenObra;
    }

    public void setImagenObra(String imagenObra) {
        this.imagenObra = imagenObra;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getDuracionObra() {
        return duracionObra;
    }

    public void setDuracionObra(int duracionObra) {
        this.duracionObra = duracionObra;
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(String fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(String horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public BigDecimal getPrecioObra() {
        return precioObra;
    }

    public void setPrecioObra(BigDecimal precioObra) {
        this.precioObra = precioObra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "CarritoInfo{" +
                "idCarrito=" + idCarrito +
                ", tituloObra='" + tituloObra + '\'' +
                ", imagenObra='" + imagenObra + '\'' +
                ", nombreSala='" + nombreSala + '\'' +
                ", duracionObra=" + duracionObra +
                ", fechaFuncion=" + fechaFuncion +
                ", horaFuncion=" + horaFuncion +
                ", precioObra=" + precioObra +
                ", cantidad=" + cantidad +
                '}';
    }

    public static String toArrayJson(ArrayList<CarritoInfo> carritoInfos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(carritoInfos);
        return resp;
    }
}
