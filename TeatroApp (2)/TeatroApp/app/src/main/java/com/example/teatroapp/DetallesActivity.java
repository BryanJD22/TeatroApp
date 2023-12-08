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
import com.example.teatroapp.Adapter.FechasAdapter;
import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.Categorias.CategoriaPresenter;
import com.example.teatroapp.Compra.CompraContract;
import com.example.teatroapp.Compra.CompraPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class DetallesActivity extends AppCompatActivity implements ValorarContract.View, CategoriaContract.View, CompraContract.View {
    private TextView tituloObra, obraValoracionTxt, duracionTxt, descObra;
    private ProgressBar progressBar;
    private NestedScrollView scrollView;
    private ImageView pic2, backImg, valorarStar;
    private RecyclerView recyclerViewCategorias, recyclerViewFechas;

    ArrayList<Categoria> lstCategorias = new ArrayList<>();
    ArrayList<Obra> datosObra = new ArrayList<>();
    private int idObra, idUser;

    private String tituloObraV;
    ValorarPresenter presenter;
    CompraPresenter compraPresenter;

    ArrayList<Valoracion> valoraciones = new ArrayList<>();
    ArrayList<ObraSala> fechas = new ArrayList<>();

    CategoriaPresenter categoriaspresenter;

    private RecyclerView.Adapter adaptercategorias, adapterfechas;

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
        sucessLstValoraciones(valoraciones);

        sucessListCategorias(lstCategorias);


        compraPresenter = new CompraPresenter(this);

        compraPresenter.getFechas(String.valueOf(idObra));
        sucessListFechas(fechas);

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
        this.valoraciones = lstValoraciones;

        if (!lstValoraciones.isEmpty()) {
            Valoracion valoracion = lstValoraciones.get(0);
            obraValoracionTxt.setText(String.valueOf(valoracion.getValoracion()));
        } else {
            obraValoracionTxt.setText("No hay valoraciones hechas");
        }

    }

    @Override
    public void failureListValoraciones(String message) {

    }

    @Override
    public void sucessListCategorias(ArrayList<Categoria> lstcategoria) {
        if (lstcategoria != null) {
            this.lstCategorias = lstcategoria;
            recyclerViewCategorias = findViewById(R.id.categoriaDetalles);
            adaptercategorias = new CategoriasAdapter(lstcategoria);
            recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            // Asegúrate de que recyclerViewCategorias se haya inicializado correctamente antes de usarlo
            if (recyclerViewCategorias != null) {
                recyclerViewCategorias.setAdapter(adaptercategorias);
            } else {
                // Manejar la situación en la que recyclerViewCategorias es null
                Log.e("Error", "recyclerViewCategorias es null");
            }
        } else {
            // Manejar la situación en la que lstcategoria es null
            Log.e("Error", "lstcategoria es null");
        }
    }

    @Override
    public void failureListCategoria(String message) {

    }

    @Override
    public void successListObrasPorCategoria(ArrayList<Obra> lstObras) {

    }




    @Override
    public void sucessListFechas(ArrayList<ObraSala> lstobraSala) {
        this.fechas = lstobraSala;
        recyclerViewFechas = findViewById(R.id.fechas);
        adapterfechas = new FechasAdapter(lstobraSala, idUser);
        recyclerViewFechas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewFechas.setAdapter(adapterfechas);
    }

    @Override
    public void failureListFechas(String message) {


    }

}