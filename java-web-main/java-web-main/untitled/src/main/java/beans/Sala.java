package beans;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
public class Sala {
    private int idSala;
    private String nombre;
    private int capacidad;
    private String imgSala;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;

    public Sala() {
        // Constructor vacío necesario para algunos frameworks de persistencia.
    }

    public Sala(int idSala, String nombre, int capacidad, String imgSala) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.imgSala = imgSala;
    }

    public Sala(int idSala, String nombre, int capacidad) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Sala(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Sala(String nombre, int capacidad, String imgSala) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.imgSala = imgSala;
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

    @Override
    public String toString() {
        return "Sala [idSala=" + idSala + ", nombre=" + nombre + ", capacidad=" + capacidad +
                ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + "]";
    }

    public static String toArrayJson(ArrayList<Sala> salas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(salas);
        return resp;
    }
}
