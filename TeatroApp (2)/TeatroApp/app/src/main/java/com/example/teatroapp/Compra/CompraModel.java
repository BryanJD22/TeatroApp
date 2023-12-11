package com.example.teatroapp.Compra;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiCompra;
import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Confirm;
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

    public void addCarrito(String idUser, String idObraSala, String i, OnLstObraSalaListener onLstObraSalaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<ArrayList<Carrito>> call = apiCompra.addCarrito("Carrito.ADD", idUser,idObraSala,i);
        call.enqueue(new Callback<ArrayList<Carrito>>() {
            public void onResponse(Call<ArrayList<Carrito>> call, Response<ArrayList<Carrito>> response) {
                if(response.isSuccessful()){
                    ArrayList<Carrito> carrito = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(carrito!=null) {
                        onLstObraSalaListener.add(carrito);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Carrito>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }

    public void eliminarCarrito(String idUser, String idObraSala, OnLstObraSalaListener onLstObraSalaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<ArrayList<Carrito>> call = apiCompra.eliminarCarito("Carrito.ELIMINAR", idUser,idObraSala);
        call.enqueue(new Callback<ArrayList<Carrito>>() {
            public void onResponse(Call<ArrayList<Carrito>> call, Response<ArrayList<Carrito>> response) {
                if(response.isSuccessful()){
                    ArrayList<Carrito> carrito = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(carrito!=null) {
                        onLstObraSalaListener.add(carrito);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Carrito>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }

    public void loadCarrito(String idUser, OnLstObraSalaListener onLstObraSalaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<ArrayList<CarritoInfo>> call = apiCompra.loadCarrito("Carrito.FIND_CARRITO",idUser);
        call.enqueue(new Callback<ArrayList<CarritoInfo>>() {
            public void onResponse(Call<ArrayList<CarritoInfo>> call, Response<ArrayList<CarritoInfo>> response) {
                if(response.isSuccessful()){
                    ArrayList<CarritoInfo> carrito = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(carrito!=null) {
                        onLstObraSalaListener.loadCarrito(carrito);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<CarritoInfo>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }

    public void loadHistorial(String idUser, OnLstObraSalaListener onLstObraSalaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<ArrayList<Carrito>> call = apiCompra.loadHistorial("Carrito.HISTORIAL_CARRITO",idUser);
        call.enqueue(new Callback<ArrayList<Carrito>>() {
            public void onResponse(Call<ArrayList<Carrito>> call, Response<ArrayList<Carrito>> response) {
                if(response.isSuccessful()){
                    ArrayList<Carrito> carrito = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(carrito!=null) {
                        onLstObraSalaListener.loadHistorial(carrito);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Carrito>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }

    public void confirmar(String idUser, OnLstObraSalaListener onLstObraSalaListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiCompra apiCompra = ApiTeatro.getClient().create(ApiCompra.class);
        //petición asíncrona.
        Call<Confirm> call = apiCompra.confirmar("Carrito.CONFIRMAR",idUser);
        call.enqueue(new Callback<Confirm>() {
            public void onResponse(Call<Confirm> call, Response<Confirm> response) {
                if(response.isSuccessful()){
                    Confirm confirm = response.body();// Aquí tengo el JSON
                    System.out.println(response.body());
                    if(confirm!=null) {
                        onLstObraSalaListener.confirmado(confirm);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLstObraSalaListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<Confirm> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                onLstObraSalaListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });
    }
}
