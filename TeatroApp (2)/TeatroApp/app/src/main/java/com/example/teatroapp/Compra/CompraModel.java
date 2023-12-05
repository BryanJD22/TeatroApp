package com.example.teatroapp.Compra;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiCompra;
import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompraModel implements CompraContract.Model {

    @Override
    public void getFechas(String idObra, OnLstObraSalaListener onLstObraSalaListener) {

        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<ArrayList<ObraSala>> call = apiCompra.lst_obras_fechas("ObraSala.FECHASBY_IDOBRA", idObra);
        call.enqueue(new Callback<ArrayList<ObraSala>>() {
            public void onResponse(Call<ArrayList<ObraSala>> call, Response<ArrayList<ObraSala>> response) {
                if(response.isSuccessful()){
                    ArrayList<ObraSala> obrasSalas = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(obrasSalas!=null) {
                        onLstObraSalaListener.onFinished(obrasSalas);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<ObraSala>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });


    }
}
