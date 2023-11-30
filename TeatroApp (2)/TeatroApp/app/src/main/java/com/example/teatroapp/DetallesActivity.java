package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.teatroapp.Adapter.CategoriasAdapter;
import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.Categorias.CategoriaPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class DetallesActivity extends AppCompatActivity implements ValorarContract.View, CategoriaContract.View {
    private TextView tituloObra, obraValoracionTxt, duracionTxt, descObra;
    private ProgressBar progressBar;
    private NestedScrollView scrollView;
    private ImageView pic2, backImg, valorarStar;
    private RecyclerView recyclerViewCategorias;

    ArrayList<Categoria> lstCategorias = new ArrayList<>();
    ArrayList<Obra> datosObra = new ArrayList<>();
    private int idObra, idUser;

    private String tituloObraV;
    ValorarPresenter presenter;

    ArrayList<Valoracion> valoraciones = new ArrayList<>();

    CategoriaPresenter categoriaspresenter;
    private RecyclerView.Adapter adaptercategorias;

    private RecyclerView  recyclerViewCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        initView();


        idObra = getIntent().getIntExtra("idObra",0);
        tituloObraV = getIntent().getStringExtra("tituloObra");
        idUser = getIntent().getIntExtra("idUser", 0);
        presenter = new ValorarPresenter(this);


        categoriaspresenter = new CategoriaPresenter(this);
        categoriaspresenter.getCategoriasPorObra(String.valueOf(idObra));


        presenter.getObraById(String.valueOf(idObra));
        sendRequestObras(datosObra);

        presenter.getValoraciones(String.valueOf(idObra));




        obraValoracionTxt.setOnClickListener(v -> {
            Intent intent = new Intent(DetallesActivity.this, ValorarActivity.class);
            intent.putExtra("tituloObraV", tituloObraV);
            intent.putExtra("idObra", idObra);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
    }



    private void initView() {
        tituloObra = findViewById(R.id.tituloObraDetalles);
        progressBar = findViewById(R.id.progressBarDetail);
        scrollView = findViewById(R.id.scrollView2);
        pic2 = findViewById(R.id.picDetail);
        obraValoracionTxt = findViewById(R.id.obraValoracion);

        duracionTxt = findViewById(R.id.duracionDetalles);
        descObra = findViewById(R.id.descDetalles);
        backImg = findViewById(R.id.backImg);
        recyclerViewCategorias = findViewById(R.id.categoriaDetalles);
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        backImg.setOnClickListener(v -> finish());
    }


    @Override
    public void sendRequestObras(ArrayList<Obra> lstObras) {
        if (lstObras != null && !lstObras.isEmpty()) {
            this.datosObra = lstObras;
            RequestOptions requestOptions = new RequestOptions();
            requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(30));
            Obra obra = lstObras.get(0);

            tituloObra.setText(obra.getTituloObra());
            Glide.with(DetallesActivity.this)
                    .load(obra.getImagenObra())
                    .apply(requestOptions)
                    .placeholder(R.drawable.sukuna)
                    .into(pic2);
            // obraValoracionTxt.setText();
            duracionTxt.setText(String.valueOf(obra.getDuracionMin()));
            descObra.setText(obra.getDescripcionObra());
        } else {
            // Manejar el caso en el que la lista esté vacía
            // Por ejemplo, mostrar un mensaje de error o tomar alguna acción predeterminada.
            Log.e("DetallesActivity", "La lista de obras está vacía");
        }

    }



    @Override
    public void sucessLstValoraciones(ArrayList<Valoracion> lstValoraciones) {


        if (!lstValoraciones.isEmpty()) {
            Valoracion valoracion = lstValoraciones.get(0); // Assuming you are getting a single Valoracion
            obraValoracionTxt.setText(String.valueOf(valoracion.getValoracion())); // Assuming there's a method like getRating() in Valoracion class
        } else {
            obraValoracionTxt.setText("No hay valoraciones hechas");
        }

    }

    @Override
    public void failureListValoraciones(String message) {

    }

    @Override
    public void sucessListCategorias(ArrayList<Categoria> lstcategoria) {
        this.lstCategorias = lstcategoria;
        recyclerViewCategorias = findViewById(R.id.categoriaDetalles);
        adaptercategorias = new CategoriasAdapter(lstcategoria);
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCategoria.setAdapter(adaptercategorias);
    }

    @Override
    public void failureListCategoria(String message) {

    }

    @Override
    public void successListObrasPorCategoria(ArrayList<Obra> lstObras) {

    }
}