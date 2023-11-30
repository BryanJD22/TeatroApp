package com.example.teatroapp.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ObraSala {
    int idObraSala;
    int idObra;
    int idSala;

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

    public static String toArrayJson(ArrayList<ObraSala> obraSalas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(obraSalas);
        return resp;
    }

}
