package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class CategoriaActivity extends AppCompatActivity implements CategoriaContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

    }

    @Override
    public void sucessListCategorias(ArrayList<Categoria> lstcategoria) {

    }

    public void successListObrasPorCategoria(ArrayList<Obra> lstObras){

    }
    @Override
    public void failureListCategoria(String message) {

    }
}