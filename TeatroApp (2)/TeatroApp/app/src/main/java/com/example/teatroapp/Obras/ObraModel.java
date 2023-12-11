package com.example.teatroapp.Obras;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiUsers;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObraModel implements ObraContract.Model{
    @Override
    public void getObrasService(final OnLstObrasListener onLstObrasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.lst_obras("Obra.FIND_ALL");
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstObrasListener.onFinished(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObrasListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObrasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }

    public void getObrasPorSala(String idSala, final OnLstObrasListener onLstObrasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.lst_obras_sala("Obra.FINDBY_IDSALA", idSala);
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstObrasListener.onFinished(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObrasListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObrasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }

    public void getObrasTopVentas(final OnLstObrasListener onLstObrasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.lst_obras("Obra.TOP10VENTAS");
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstObrasListener.onFinished(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObrasListener.onFailure("Fallo: Top Ventas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObrasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }

    public void getObrasTopPopular(final OnLstObrasListener onLstObrasListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.lst_obras("Obra.TOP10PUNTUADAS");
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstObrasListener.onFinished(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObrasListener.onFailure("Fallo: Top Ventas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObrasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }


    public void getObraPorTitulo(String titulo, OnLstObrasListener onLstObrasListener) {

        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.obraportitulo("Obra.TITULO", titulo);
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        onLstObrasListener.obraportitulo(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObrasListener.onFailure("Fallo: Top Ventas");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObrasListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }
}
