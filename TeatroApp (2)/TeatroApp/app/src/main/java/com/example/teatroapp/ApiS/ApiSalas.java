package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiSalas {

    @GET("ServletTeatro")
    Call<ArrayList<Sala>> lst_salas(@Query("ACTION") String action);

    @GET("ServletTeatro")
    Call<ArrayList<Sala>> lst_salasByid(@Query("ACTION") String action, String idSala);
}
