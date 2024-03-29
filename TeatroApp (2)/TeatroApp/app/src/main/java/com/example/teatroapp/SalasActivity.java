package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.teatroapp.Adapter.AdapterSalas;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

public class SalasActivity extends AppCompatActivity implements SalaContract.View {

    private Button btnobras;
    public AdapterSalas adapterSalas;
    private SalaPresenter lstSalasPresenter;
    private ArrayList<Sala> lstSalas;

    private ImageView backimg;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas);
        backimg = findViewById(R.id.backImgSalas);
        backimg.setOnClickListener(v -> finish());

        lstSalasPresenter = new SalaPresenter(this);

        lstSalasPresenter.getSalas();


    }

    @Override
    public void sucessLstSalas(ArrayList<Sala> lstSalas) {
        this.lstSalas = lstSalas;

        recyclerView = findViewById(R.id.recyclerSalas);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

         adapterSalas = new AdapterSalas(lstSalas,this);

        recyclerView.setAdapter(adapterSalas);


    }

    @Override
    public void failureListFilms(String message) {

    }
}