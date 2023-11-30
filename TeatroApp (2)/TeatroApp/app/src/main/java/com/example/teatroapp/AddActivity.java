package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teatroapp.AddObras.AddContract;
import com.example.teatroapp.AddObras.AddObraPresenter;
import com.example.teatroapp.beans.Obra;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements AddContract.View {

    private EditText edtTituloObra;

    private EditText edtCategoria;


    private EditText edtDesc;
    private EditText edtDuracion;
    private EditText edtPrecio;

    Obra obra = new Obra();

    AddObraPresenter presenter = new AddObraPresenter(this);

    private Button addBtn;
    ArrayList<Obra> idObras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();

        String idSala = intent.getStringExtra("idSala");



        edtTituloObra = findViewById(R.id.tituloObra);
        edtDesc = findViewById(R.id.desc);
        //edtCategoria = findViewById(R.id.categoria);
        edtDuracion = findViewById(R.id.duracion);
        edtPrecio = findViewById(R.id.precio);



        addBtn = findViewById(R.id.addBtnAdmin);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obra.setTituloObra(edtTituloObra.getText().toString());
                obra.setDescripcionObra(edtDesc.getText().toString());
                obra.setDuracionMin(Integer.parseInt(String.valueOf(edtDuracion.getText())));
                obra.setPrecio(new BigDecimal(String.valueOf(edtPrecio.getText())));
                Log.d("VALORES", "Título: " + obra.getTituloObra());
                Log.d("VALORES", "Descripción: " + obra.getDescripcionObra());
                Log.d("VALORES", "Duración: " + obra.getDuracionMin());
                Log.d("VALORES", "Precio: " + obra.getPrecio());
                presenter.add(obra);

                sucessAdd(idObras);


            }
        });

    }

    @Override
    public void sucessAdd(ArrayList<Obra> lstObras) {
        this.idObras = lstObras;
        Obra obra = lstObras.get(0);
        int idObra = obra.getIdObra();



    }

    @Override
    public void failureListFilms(String message) {

    }
}