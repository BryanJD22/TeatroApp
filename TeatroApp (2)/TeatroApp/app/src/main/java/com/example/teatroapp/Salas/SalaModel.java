package com.example.teatroapp.Salas;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiSalas;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalaModel implements SalaContract.Model{
    @Override
    public void getSalasService(final OnLstSalasListener onLstSalasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiSalas apiSalas = ApiTeatro.getClient().create(ApiSalas.class);
        //petición asíncrona.
        Call<ArrayList<Sala>> call = apiSalas.lst_salas("Sala.FIND_ALL");
        call.enqueue(new Callback<ArrayList<Sala>>() {
            public void onResponse(Call<ArrayList<Sala>> call, Response<ArrayList<Sala>> response) {
                if(response.isSuccessful()){
                    ArrayList<Sala> salas = response.body();// Aquí tengo el JSON
                    if(salas!=null) {
                        onLstSalasListener.onFinished(salas);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstSalasListener.onFailure("Fallo: listas salas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Sala>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstSalasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }

    public void getSalaById(String idsala, final OnLstSalasListener onLstSalasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiSalas apiSalas = ApiTeatro.getClient().create(ApiSalas.class);
        //petición asíncrona.
        Call<ArrayList<Sala>> call = apiSalas.lst_salasByid("Sala.FINDBY_ID", idsala);
        call.enqueue(new Callback<ArrayList<Sala>>() {
            public void onResponse(Call<ArrayList<Sala>> call, Response<ArrayList<Sala>> response) {
                if(response.isSuccessful()){
                    ArrayList<Sala> salas = response.body();// Aquí tengo el JSON
                    if(salas!=null) {
                        onLstSalasListener.onFinished(salas);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstSalasListener.onFailure("Fallo: listas salas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Sala>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstSalasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }
}
