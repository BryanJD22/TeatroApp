package com.example.teatroapp.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.util.ArrayList;

public class Carrito {
    private int idCarrito;
    private int idCompra;
    private int idUsuario;
    private int idObraSala;
    private Integer cantidad;
    private String fechaAgregado;

    public Carrito() {

    }

    public Carrito(int idCompra, Integer cantidad, String fechaAgregado) {
        this.idCompra = idCompra;
        this.cantidad = cantidad;
        this.fechaAgregado = fechaAgregado;
    }

    public Carrito(int idCarrito, int idUsuario, int cantidad, String fechaAgregado) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
        this.fechaAgregado = fechaAgregado;
    }

    public Carrito(int idUsuario, int idObraSala, int cantidad) {
        this.idUsuario = idUsuario;
        this.idObraSala = idObraSala;
        this.cantidad = cantidad;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdObraSala() {
        return idObraSala;
    }

    public void setIdObraSala(int idObraSala) {
        this.idObraSala = idObraSala;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(String fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito=" + idCarrito +
                ", idUsuario=" + idUsuario +
                ", idObraSala=" + idObraSala +
                ", cantidad=" + cantidad +
                ", fechaAgregado=" + fechaAgregado +
                '}';
    }

    public static String toArrayJson(ArrayList<Carrito> lstcarrito) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(lstcarrito);
        return resp;
    }


}
