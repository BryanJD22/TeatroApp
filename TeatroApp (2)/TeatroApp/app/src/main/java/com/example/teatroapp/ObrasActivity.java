package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.teatroapp.Adapter.AdapterObras;
import com.example.teatroapp.Adapter.CategoriasAdapter;
import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.Categorias.CategoriaPresenter;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Obras.ObraPresenter;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class ObrasActivity extends AppCompatActivity implements ObraContract.View, CategoriaContract.View {

    private Button agregarbtn;
    public AdapterObras adapterObras;
    private ObraPresenter lstObrasPresenter;
    private ImageView backimg;
    private CategoriaPresenter lstCategoriaPresenter;

    private ArrayList<Obra> lstObras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obras);
        backimg = findViewById(R.id.backImgObras);
        backimg.setOnClickListener(v -> finish());

        lstObrasPresenter = new ObraPresenter(this);
        lstCategoriaPresenter = new CategoriaPresenter(this);


        Intent intent = getIntent();
        if (intent.hasExtra("idSala")) {
            String idSala = intent.getStringExtra("idSala");
            lstObrasPresenter.getObrasPorSala(idSala);
            agregarbtn = findViewById(R.id.addbtnObras);


            agregarbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ObrasActivity.this, AddActivity.class);
                    intent.putExtra("idSala", String.valueOf(idSala));
                    startActivity(intent);
                }
            });

        } else if(intent.hasExtra("categoria")){

            String categoria = intent.getStringExtra("categoria");
            lstCategoriaPresenter.getObrasPorCategoria(categoria);
            successListObrasPorCategoria(lstObras);
            agregarbtn = findViewById(R.id.addbtnObras);
            agregarbtn.setVisibility(View.GONE);


        }else {
            // Manejar el caso en el que no se proporcionó un ID de sala

        }

        /*// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.idReciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);*/





    }

    @Override
    public void sucessListObras(ArrayList<Obra> lstObras) {
        // Crear un nuevo adaptador
        //adapter = new AdapterObras(lstObras);
        this.lstObras = lstObras;
        RecyclerView recyclerView = findViewById(R.id.recyclerObras);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapterObras = new AdapterObras(this,lstObras);
        recyclerView.setAdapter(adapterObras);

    }

    @Override
    public void sendRequestTopVentas(ArrayList<Obra> lstObras) {

    }

    @Override
    public void sendRequestTopPopular(ArrayList<Obra> lstObras) {

    }

    @Override
    public void failureListObras(String message) {
        Toast.makeText(ObrasActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sucessListCategorias(ArrayList<Categoria> lstcategoria) {

    }

    @Override
    public void failureListCategoria(String message) {

    }

    @Override
    public void successListObrasPorCategoria(ArrayList<Obra> lstObras) {
        this.lstObras = lstObras;
        RecyclerView recyclerView = findViewById(R.id.recyclerObras);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapterObras = new AdapterObras(this,lstObras);
        recyclerView.setAdapter(adapterObras);

    }
}