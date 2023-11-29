package com.example.teatroapp.Categorias;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiCategoria;
import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaModel implements CategoriaContract.Model{
    @Override
    public void getCategoriasService(final CategoriaContract.Model.OnLstCategoriaListener onLstCategoriaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCategoria apiCategoria = ApiTeatro.getClient().create(ApiCategoria.class);
        //petición asíncrona.
        Call<ArrayList<Categoria>> call = apiCategoria.lstcategorias("Categoria.FIND_ALL");
        call.enqueue(new Callback<ArrayList<Categoria>>() {
            public void onResponse(Call<ArrayList<Categoria>> call, Response<ArrayList<Categoria>> response) {
                if(response.isSuccessful()){
                    ArrayList<Categoria> categorias = response.body();// Aquí tengo el JSON
                    if(categorias!=null) {
                        onLstCategoriaListener.onFinished(categorias);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstCategoriaListener.onFailure("Fallo: Top Ventas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Categoria>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstCategoriaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }

    public void getObrasPorCategoria(String categoria, final CategoriaContract.Model.OnLstCategoriaListener onLstCategoriaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCategoria apiCategoria = ApiTeatro.getClient().create(ApiCategoria.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiCategoria.lst_obras_categoria("Obra.BYCATEGORIA", categoria);
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstCategoriaListener.obraPorCategoria(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstCategoriaListener.onFailure("Fallo: Obra Por categoria");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstCategoriaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }


    public void getCategoriasPorObra(String idObra, OnLstCategoriaListener onLstCategoriaListener) {

        ApiCategoria apiCategoria = ApiTeatro.getClient().create(ApiCategoria.class);
        //petición asíncrona.
        Call<ArrayList<Categoria>> call = apiCategoria.lst_categoriasByObra("Categoria.BYOBRA", idObra);
        call.enqueue(new Callback<ArrayList<Categoria>>() {
            public void onResponse(Call<ArrayList<Categoria>> call, Response<ArrayList<Categoria>> response) {
                if(response.isSuccessful()){
                    ArrayList<Categoria> categorias = response.body();// Aquí tengo el JSON
                    if(categorias!=null) {
                        onLstCategoriaListener.onFinished(categorias);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstCategoriaListener.onFailure("Fallo: Obra Por categoria");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Categoria>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstCategoriaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }
}
