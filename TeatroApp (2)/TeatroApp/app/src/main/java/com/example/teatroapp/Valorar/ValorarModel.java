package com.example.teatroapp.Valorar;

import android.util.Log;

import com.example.teatroapp.AddObras.AddContract;
import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiValorar;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValorarModel implements ValorarContract.Model{

    public void getObrasPorID(String idObra, final ValorarContract.Model.OnLstValoracionesListener OnLstValoracionesListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        //petición asíncrona.
        Call<ArrayList<Obra>> call = apiObras.lst_obrasById("Obra.FINDBY_ID", idObra);
        call.enqueue(new Callback<ArrayList<Obra>>() {
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if(response.isSuccessful()){
                    ArrayList<Obra> obras = response.body();// Aquí tengo el JSON
                    if(obras!=null) {
                        OnLstValoracionesListener.getObrasByid(obras);

                    }else{
                        Log.d("Bryan Error", "1");
                        OnLstValoracionesListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make obras request", t);
                OnLstValoracionesListener.onFailure("Failed to retrieve obras: " + t.getMessage());
            }
        });

    }
    public void addValoracion(Valoracion valoracion, final ValorarContract.Model.OnLstValoracionesListener OnLstValoracionesListener) {
        ApiValorar apiValorar = ApiTeatro.getClient().create(ApiValorar.class);
        Call<ArrayList<Valoracion>> call = apiValorar.addValoracion(
                "Valorar.ADDVALORACION",
                valoracion.getValoracion(),
                valoracion.getIdObra(),
                valoracion.getIdUsuario()
        );
        call.enqueue(new Callback<ArrayList<Valoracion>>() {
            @Override
            public void onResponse(Call<ArrayList<Valoracion>> call, Response<ArrayList<Valoracion>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Valoracion> valoraciones = response.body();
                    if (valoraciones != null) {
                        OnLstValoracionesListener.onFinished(valoraciones);
                    } else {
                        OnLstValoracionesListener.onFailure("Fallo: Agregar valoracion");
                    }
                } else {
                    OnLstValoracionesListener.onFailure("Fallo en la respuesta del servidor");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Valoracion>> call, Throwable t) {
                OnLstValoracionesListener.onFailure("Error en la solicitud: " + t.getMessage());
            }
        });
    }
    @Override
    public void getValoracionesService(OnLstValoracionesListener OnLstValoracionesListener) {

    }
}
