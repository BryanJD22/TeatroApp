package beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Carrito {
    private int idCarrito;
    private int idUsuario;
    private int idObraSala;
    private int cantidad;
    private Timestamp fechaAgregado;

    public Carrito() {

    }


    public Carrito(int idUsuario, int idObraSala, int cantidad) {
        this.idUsuario = idUsuario;
        this.idObraSala = idObraSala;
        this.cantidad = cantidad;
    }

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

    public Timestamp getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(Timestamp fechaAgregado) {
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
