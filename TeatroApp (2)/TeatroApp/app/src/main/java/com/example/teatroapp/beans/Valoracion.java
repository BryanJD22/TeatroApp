package com.example.teatroapp.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Valoracion {
    private int idValoracion;
    private double valoracion;
    private int idObra;
    private int idUsuario;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;

    public Valoracion() {

    }

    public Valoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public Valoracion(int idValoracion, double valoracion, int idObra, int idUsuario) {
        this.idValoracion = idValoracion;
        this.valoracion = valoracion;
        this.idObra = idObra;
        this.idUsuario = idUsuario;
    }

    public Valoracion(double valoracion, int idObra, int idUsuario) {
        this.valoracion = valoracion;
        this.idObra = idObra;
        this.idUsuario = idUsuario;
    }


    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }


    public static String toArrayJson(ArrayList<Valoracion> lstvaloraciones) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(lstvaloraciones);
        return resp;
    }
}
