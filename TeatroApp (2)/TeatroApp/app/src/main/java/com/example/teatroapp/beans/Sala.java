package com.example.teatroapp.beans;

import java.util.Date;

public class Sala {
    private int idSala;

    private String nombre;
    private int capacidad;
    private String imgSala;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Sala() {


    }

    public Sala(int idSala, String nombre, int capacidad, String imgSala) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.imgSala = imgSala;
    }

    public Sala(int idSala, int capacidad) {
        this.idSala = idSala;
        this.capacidad = capacidad;
    }

    public Sala(int idSala, int capacidad, Date fechaCreacion, Date fechaModificacion) {
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getImgSala() {
        return imgSala;
    }

    public void setImgSala(String imgSala) {
        this.imgSala = imgSala;
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
}
