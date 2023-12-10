package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teatroapp.Adapter.AdaptarCarrito;
import com.example.teatroapp.Compra.CompraContract;
import com.example.teatroapp.Compra.CompraPresenter;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;
import com.example.teatroapp.beans.Sala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity implements CompraContract.View {
    ArrayList<CarritoInfo> carritoInfos;
    CompraPresenter compraPresenter;
    private RecyclerView recyclerViewCarrito;
    private RecyclerView.Adapter adapterCarrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        int idUser = getIntent().getIntExtra("idUser", 0);

        compraPresenter = new CompraPresenter(this);
        compraPresenter.loadCarrito(String.valueOf(idUser));
    }

    @Override
    public void sucessListFechas(ArrayList<ObraSala> lstobraSala) {

    }

    @Override
    public void sucessCarrito(ArrayList<CarritoInfo> carrito) {
        this.carritoInfos = carrito;
        recyclerViewCarrito = findViewById(R.id.Carrito);
        adapterCarrito = new AdaptarCarrito(this,carrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        recyclerViewCarrito.setAdapter(adapterCarrito);

    }

    @Override
    public void failureListFechas(String message) {

    }
}