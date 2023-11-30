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
    String mensaje;

    ValorarPresenter presenter;

    ArrayList<Valoracion> valoraciones = new ArrayList<>();

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

        mensaje = "Ha ocurrido un problema pruebe otra vez más tarde";

        btnPuntuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String puntuacionText = edtPuntuacion.getText().toString();

                if (validarPuntuacion(puntuacionText)) {
                    double puntuacion = Double.parseDouble(puntuacionText);

                    Valoracion valoracion = new Valoracion(puntuacion,idObra,idUser);

                    presenter.addValoracion(valoracion);
                    sucessLstValoraciones(valoraciones);

                } else {
                    // Inflar el diseño personalizado del Toast
                    View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

                    // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
                    TextView text = layout.findViewById(R.id.toast_text);
                    text.setText("La valoracion tiene que ser entre 1 y 5");

                    // Crear y mostrar el Toast personalizado
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
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
        this.valoraciones = lstValoraciones;
        // Inflar el diseño personalizado del Toast
        View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

        // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText("Valoración añadida correctamente");

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public void failureListValoraciones(String message) {
        this.mensaje = message;
        // Inflar el diseño personalizado del Toast
        View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

        // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText(message);

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}