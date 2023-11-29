package com.example.teatroapp.AddObras;

import com.example.teatroapp.ApiS.ApiObras;
import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiUsers;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddObrasModel implements AddContract.Model {

    public void addObra(Obra obra, final OnLstObrasListener onLstObrasListener) {
        ApiObras apiObras = ApiTeatro.getClient().create(ApiObras.class);
        Call<ArrayList<Obra>> call = apiObras.addObra(
                "Obra.ADD",
                obra.getTituloObra(),
                obra.getDescripcionObra(),
                obra.getDuracionMin(),
                obra.getPrecio()
        );
        call.enqueue(new Callback<ArrayList<Obra>>() {
            @Override
            public void onResponse(Call<ArrayList<Obra>> call, Response<ArrayList<Obra>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Obra> obras = response.body();
                    if (obras != null) {
                        onLstObrasListener.onFinished(obras);
                    } else {
                        onLstObrasListener.onFailure("Fallo: Agregar obra");
                    }
                } else {
                    onLstObrasListener.onFailure("Fallo en la respuesta del servidor");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Obra>> call, Throwable t) {
                onLstObrasListener.onFailure("Error en la solicitud: " + t.getMessage());
            }
        });
    }

    @Override
    public void getObrasService(OnLstObrasListener onLstObrasListener) {

    }


}
