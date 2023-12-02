package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCompra {

    @GET("ServletTeatro")
    Call<ArrayList<ObraSala>> lst_obras_fechas(@Query("ACTION") String action, @Query("IDOBRA") String idobra);
}
