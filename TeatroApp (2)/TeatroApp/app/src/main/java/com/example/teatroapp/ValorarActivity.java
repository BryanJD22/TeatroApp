package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Valoracion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ValorarActivity extends AppCompatActivity  implements ValorarContract.View{

    private EditText edtPuntuacion;
    String tituloObraV;
    int idUser, idObra;

    private Button btnPuntuar;

    TextView valorarTitulo;

    ValorarPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorar);

        presenter = new ValorarPresenter(this);

        idObra = getIntent().getIntExtra("idObra",0);
        tituloObraV = getIntent().getStringExtra("tituloObra");
        idUser = getIntent().getIntExtra("idUser", 0);

        valorarTitulo = findViewById(R.id.valorarTitulo);

        edtPuntuacion = findViewById(R.id.edtPuntuacion);

        btnPuntuar = findViewById(R.id.btnPuntuar);

        btnPuntuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String puntuacionText = edtPuntuacion.getText().toString();

                if (validarPuntuacion(puntuacionText)) {
                    double puntuacion = Double.parseDouble(puntuacionText);

                    Valoracion valoracion = new Valoracion(puntuacion,idObra,idUser);

                    presenter.addValoracion(valoracion);

                } else {

                    Toast.makeText(ValorarActivity.this, "Invalid puntuacion. Please enter a number between 1 and 5.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private boolean validarPuntuacion(String puntuacionText) {
        try {
            double puntuacion = Double.parseDouble(puntuacionText);
            return puntuacion >= 1 && puntuacion <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
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
}