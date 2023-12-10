package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;

public class Carrito {
    private int idCarrito;
    private int idUsuario;
    private String tituloObra;
    private String descripcionObra;
    private String nombreSala;
    private int duracionMin;
    private String fechaObra;
    private String  horaObra;
    private double precio;
    private Date fechaCreacion;
    private Date fechaModificacion;

    // Constructor por defecto
    public Carrito() {
    }

    public Carrito(int idCarrito, int idUsuario, String tituloObra, String descripcionObra, String nombreSala, int duracionMin, String fechaObra, String horaObra, double precio) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.tituloObra = tituloObra;
        this.descripcionObra = descripcionObra;
        this.nombreSala = nombreSala;
        this.duracionMin = duracionMin;
        this.fechaObra = fechaObra;
        this.horaObra = horaObra;
        this.precio = precio;
    }

    // Getters y Setters

    public int getIdCarrito() {
        return idCarrito;
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

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String getFechaObra() {
        return fechaObra;
    }

    public void setFechaObra(String fechaObra) {
        this.fechaObra = fechaObra;
    }

    public String getHoraObra() {
        return horaObra;
    }

    public void setHoraObra(String horaObra) {
        this.horaObra = horaObra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
    public static String toArrayJson(ArrayList<Carrito> lstcarrito) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(lstcarrito);
        return resp;
    }
}
