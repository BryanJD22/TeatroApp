package com.example.teatroapp.ApiS;

import com.example.teatroapp.CategoriaActivity;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCategoria {
    @GET("ServletTeatro")
    Call<ArrayList<Categoria>> lstcategorias(@Query("ACTION") String action);

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras_categoria(@Query("ACTION") String action, @Query("CATEGORIA") String categoria);

    @GET("ServletTeatro")
    Call<ArrayList<Categoria>> lst_categoriasByObra(@Query("ACTION") String action, @Query("IDOBRA") String idObra);
}
