package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Obra;

import java.math.BigDecimal;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiObras {

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras(@Query("ACTION") String action);
    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obras_sala(@Query("ACTION") String action, @Query("IDSALA") String idSala);

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> lst_obrasById(@Query("ACTION") String action, @Query("IDOBRA") String idObra);

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> addObra(@Query("ACTION") String action,
                                  @Query("TITULO") String titulo,
                                  @Query("DESC") String desc,
                                  @Query("DURACION") int duracion,
                                  @Query("PRECIO") BigDecimal precio);

    @GET("ServletTeatro")
    Call<ArrayList<Obra>> addObra(String s, int idObra, int idSala);
}
