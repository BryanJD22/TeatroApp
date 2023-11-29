package com.example.teatroapp.beans;

import android.widget.EditText;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Obra {
    private int idObra;
    private String tituloObra;
    private String categoria;
    private String descripcionObra;
    private int duracionMin;

    private BigDecimal precio;
    private String imagenObra;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;

    public Obra() {
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, int duracionMin, BigDecimal precio, String imagenObra) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.imagenObra = imagenObra;
    }

    public Obra(String tituloObra, String categoria, String descripcionObra, int duracionMin, BigDecimal precio) {
        this.tituloObra = tituloObra;
        this.categoria = categoria;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.precio = precio;
    }

    public Obra(String tituloObra, String categoria, String descripcionObra, int duracionMin, String imagenObra) {
        this.tituloObra = tituloObra;
        this.categoria = categoria;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.imagenObra = imagenObra;
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, String imagenObra, Timestamp fechaCreacion, Timestamp fechaModificacion) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.imagenObra = imagenObra;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionObra() {
        return descripcionObra;
    }

    public void setDescripcionObra(String descripcionObra) {
        this.descripcionObra = descripcionObra;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String getImagenObra() {
        return imagenObra;
    }

    public void setImagenObra(String imagenObra) {
        this.imagenObra = imagenObra;
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
}
