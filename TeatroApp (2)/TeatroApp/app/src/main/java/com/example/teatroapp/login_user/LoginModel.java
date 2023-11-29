package com.example.teatroapp.login_user;

import android.util.Log;

import com.example.teatroapp.ApiS.ApiTeatro;
import com.example.teatroapp.ApiS.ApiUsers;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.Model{

    private  OnLoginUserListener onLoginUserListener;

    Usuario usuario;

    @Override
    public void getUsuarios(Usuario user, OnLoginUserListener onLoginUserListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiUsers apiUsers = ApiTeatro.getClient().create(ApiUsers.class);
        //petición asíncrona.
        Call<ArrayList<Usuario>> call = apiUsers.getUsuarios("User.FIND_ALL");
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            public void onResponse(Call<ArrayList<Usuario>> call,Response<ArrayList<Usuario>> response) {
                if(response.isSuccessful()){
                    ArrayList<Usuario> usuarios = response.body();// Aquí tengo el JSON
                    if(usuarios!=null) {
                        onLoginUserListener.onFinished(usuarios);

                    }else{
                        Log.d("Bryan Error", "1");
                        onLoginUserListener.onFailure("Fallo: Login");
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make login request", t);
                onLoginUserListener.onFailure("Failed to make login request");
                Log.d("Bryan Error", "1");

            }
        });
    }

    public void login(Usuario user, OnLoginUserListener onLoginUserListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiUsers apiUsers = ApiTeatro.getClient().create(ApiUsers.class);
        //petición asíncrona.
        Call<ArrayList<Usuario>> call = apiUsers.login2("User.LOGIN", user.getEmail(), user.getPassword());
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            public void onResponse(Call<ArrayList<Usuario>> call,Response<ArrayList<Usuario>> response) {
                if(response.isSuccessful()){
                    ArrayList<Usuario> usuarios = response.body();// Aquí tengo el JSON
                    if(usuarios== null || usuarios.size() == 0 ) {
                        Log.d("Bryan Error", "1");
                        onLoginUserListener.onFailure("Fallo: Login");
                    }else{

                        onLoginUserListener.onFinished(usuarios);
                    }
                }else{
                    Log.d("Bryan Error", "1");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

                Log.e("Retrofit Error", "Failed to make login request", t);
                onLoginUserListener.onFailure("Failed to make login request");
                Log.d("Bryan Error", "1");
            }
        });
    }
}
