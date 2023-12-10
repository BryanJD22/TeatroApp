package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Sala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity implements ValorarContract.View, SalaContract.View {

    ValorarPresenter valorarPresenter;
    SalaPresenter salaPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        int id_obra = getIntent().getIntExtra("idObra", 0);
        int id_sala = getIntent().getIntExtra("idSala", 0);

        valorarPresenter = new ValorarPresenter(this);
        salaPresenter = new SalaPresenter(this);

        valorarPresenter.getObraById(String.valueOf(id_obra));
        salaPresenter.getSalaById(String.valueOf(id_sala));

    }

    @Override
    public void sendRequestObras(ArrayList<Obra> lstObras) {

    }

    @Override
    public void sucessLstValoraciones(ArrayList<Valoracion> lstValoraciones) {

    }

    @Override
    public void failureListValoraciones(String message) {

    }

    @Override
    public void sucessLstSalas(ArrayList<Sala> lstSalas) {

    }

    @Override
    public void failureListFilms(String message) {

    }
}