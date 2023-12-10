package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teatroapp.Compra.CompraContract;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;
import com.example.teatroapp.beans.Sala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity implements CompraContract.View {

    ValorarPresenter valorarPresenter;
    SalaPresenter salaPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);



    }

    @Override
    public void sucessListFechas(ArrayList<ObraSala> lstobraSala) {

    }

    @Override
    public void failureListFechas(String message) {

    }
}