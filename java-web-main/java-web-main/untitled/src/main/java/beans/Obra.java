package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Obra {
    private int idObra;
    private String tituloObra;
    private String descripcionObra;

    private String categoria;
    private int duracionMin;

    private BigDecimal precio;
    private String imagenObra;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;

    public Obra() {
    }

    public Obra(int idObra) {
        this.idObra = idObra;
    }





    public Obra(String tituloObra, String descripcionObra, int duracionMin, BigDecimal precio) {
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.precio = precio;
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, int duracionMin, BigDecimal precio, String imagenObra) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.imagenObra = imagenObra;
    }

    public Obra(String tituloObra, String descripcionObra, String categoria, int duracionMin, BigDecimal precio, String imagenObra) {
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.categoria = categoria;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.imagenObra = imagenObra;
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, String categoria, int duracionMin, BigDecimal precio, String imagenObra) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.categoria = categoria;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.imagenObra = imagenObra;
    }

    public Obra(String tituloObra, String descripcionObra, int duracionMin, BigDecimal precio , String imagenObra ) {
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.imagenObra = imagenObra;
    }

    public Obra(int idObra, String tituloObra, String descripcionObra, String imagenObra) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
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

    public Obra(int idObra, String tituloObra, String descripcionObra, int duracionMin, String imagenObra, BigDecimal precio) {
        this.idObra = idObra;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.duracionMin = duracionMin;
        this.imagenObra = imagenObra;
        this.precio = precio;
    }

    public Obra(String categoria) {
    }



    public Obra(String tituloObra, String categoria, String desc, int i, BigDecimal precioObra) {
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

    public String getDescripcionObra() {
        return descripcionObra;
    }

    public void setDescripcionObra(String descripcionObra) {
        this.descripcionObra = descripcionObra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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
    public static String toArrayJson(ArrayList<Obra> obras) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(obras);
        return resp;
    }

}
