package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Confirm;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCompra {

    @GET("ServletTeatro")
    Call<ArrayList<ObraSala>> lst_obras_fechas(@Query("ACTION") String action, @Query("IDOBRA") String idobra);
    @GET("ServletTeatro")
    Call<ArrayList<Carrito>> addCarrito(@Query("ACTION") String action, @Query("ID_USUARIO") String idusUario,
                                        @Query("ID_OBRA_SALA") String id_obra_sala,
                                        @Query("CANTIDAD") String cantidad
                                         );

    @GET("ServletTeatro")
    Call<ArrayList<Carrito>> eliminarCarito(@Query("ACTION") String action, @Query("ID_USUARIO") String idusUario,
                                        @Query("ID_OBRA_SALA") String id_obra_sala

    );
    @GET("ServletTeatro")
    Call<ArrayList<CarritoInfo>> loadCarrito(@Query("ACTION") String action, @Query("IDUSER") String idUser);

    @GET("ServletTeatro")
    Call<ArrayList<Carrito>> loadHistorial(@Query("ACTION") String action, @Query("IDUSER") String idUser);

    @GET("ServletTeatro")
    Call<Confirm> confirmar(@Query("ACTION") String action, @Query("IDUSER") String idUser);
}
