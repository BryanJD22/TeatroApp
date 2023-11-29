package com.example.teatroapp.ApiS;

import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUsers {

    // http://192.168.104.68:8080/untitled/ServletTeatro?ACTION=User.FIND_ALL

    @GET("ServletTeatro")
    Call<ArrayList<Usuario>> login2(@Query("ACTION") String action,@Query("EMAIL") String email,@Query("PASS") String password);

    @GET("ServletTeatro")
    Call<ArrayList<Usuario>> getUsuarios(@Query("ACTION") String action);

}
