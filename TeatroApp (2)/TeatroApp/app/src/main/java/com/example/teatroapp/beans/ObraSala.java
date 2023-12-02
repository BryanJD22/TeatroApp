package com.example.teatroapp.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Date;
import java.util.ArrayList;

public class ObraSala {
    int idObraSala;
    int idObra;
    int idSala;
    private Date fecha;
    private String hora;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public ObraSala(int idObraSala, int idSala, Date fecha, String hora) {
        this.idObraSala = idObraSala;
        this.idSala = idSala;
        this.fecha = fecha;
        this.hora = hora;
    }

    public ObraSala(int idObra, int idSala) {
        this.idObra = idObra;
        this.idSala = idSala;
    }

    public ObraSala(int idObraSala, int idObra, int idSala) {
        this.idObraSala = idObraSala;
        this.idObra = idObra;
        this.idSala = idSala;
    }

    public int getIdObraSala() {
        return idObraSala;
    }

    public void setIdObraSala(int idObraSala) {
        this.idObraSala = idObraSala;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public static String toArrayJson(ArrayList<ObraSala> obraSalas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(obraSalas);
        return resp;
    }

}
