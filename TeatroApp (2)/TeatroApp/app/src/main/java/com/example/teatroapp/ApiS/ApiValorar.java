package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiValorar {

    @GET("ServletTeatro")
    Call<ArrayList<Valoracion>> addValoracion(@Query("ACTION") String action,
                                              @Query("VALORACION") double valoracion,
                                              @Query("IDOBRA") int idObra,
                                              @Query("IDUSER") int idUser);
    @GET("ServletTeatro")
    Call<ArrayList<Valoracion>> getValoraciones(@Query("ACTION") String action,
                                              @Query("IDOBRA") String idObra);
}
