package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teatroapp.AddObras.AddContract;
import com.example.teatroapp.AddObras.AddObraPresenter;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements AddContract.View {

    private EditText edtTituloObra;

    private EditText edtCategoria;


    private EditText edtDesc;
    private EditText edtDuracion;
    private EditText edtPrecio;

    Obra obra = new Obra();

    private int idObra;

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


                String duracionStr = String.valueOf(edtDuracion.getText());

                if (validarInteger(duracionStr)!=false) {

                    obra.setDuracionMin(Integer.parseInt(duracionStr));

                } else {
                    View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

                    // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
                    TextView text = layout.findViewById(R.id.toast_text);
                    text.setText("Duracion no valida, tiene que ser un entero de los minutos" +
                            " que dure la obra");

                    // Crear y mostrar el Toast personalizado
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                    return; // Puedes salir del método o manejar el error de otra manera
                }

                // Validar el precio
                String precioStr = String.valueOf(edtPrecio.getText());
                if (validarBigDecimal(precioStr)!=false) {
                    obra.setPrecio(new BigDecimal(precioStr));
                } else {
                    View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

                    // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
                    TextView text = layout.findViewById(R.id.toast_text);
                    text.setText("Precio no aceptado, no puede tener mas de 10 digitos incluyendo los " +
                            "2 despues del punto");

                    // Crear y mostrar el Toast personalizado
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();

                    return; // Puedes salir del método o manejar el error de otra manera
                }


                Log.d("VALORES", "Título: " + obra.getTituloObra());
                Log.d("VALORES", "Descripción: " + obra.getDescripcionObra());
                Log.d("VALORES", "Duración: " + obra.getDuracionMin());
                Log.d("VALORES", "Precio: " + obra.getPrecio());
                presenter.add(obra);

                sucessAdd(idObras);


            }
        });



    }

    private boolean validarInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método para verificar si una cadena representa un BigDecimal válido
    private boolean validarBigDecimal(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException | ArithmeticException e) {
            return false;
        }
    }

    @Override
    public void sucessAdd(ArrayList<Obra> lstObras) {
        if (lstObras != null && !lstObras.isEmpty()) {
            this.idObras = lstObras;
            Obra obra = lstObras.get(0);
            int idObra = obra.getIdObra();
            Intent intent = getIntent();
            int idSala = Integer.parseInt(intent.getStringExtra("idSala"));
            ObraSala obraSala = new ObraSala(idObra, idSala);
            presenter.addObraSala(obraSala);


        } else {
            // Manejar el caso en que lstObras es null o vacío
            Log.e("ERROR", "lstObras es null o vacío");
        }

        View layout = getLayoutInflater().inflate(R.layout.toast_style, findViewById(R.id.toast_layout_style));

        // Configurar el texto del Toast (puedes personalizarlo según tus necesidades)
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText("Obra añadida correctamente");

        // Crear y mostrar el Toast personalizado
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }

    @Override
    public void failureListFilms(String message) {

    }
}