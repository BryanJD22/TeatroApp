package com.example.teatroapp.login_user;

import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public interface LoginContract {
    public interface View{
        void sucessLogin(ArrayList<Usuario> usuarios);
        void failureLogin(String message);
    }

    public interface Presenter{
        void login(Usuario usuario);


    }

    public interface Model{
        interface OnLoginUserListener{
            void onFinished(ArrayList<Usuario> usuarios);
            void onFailure(String error);
        }
        void getUsuarios( Usuario user, OnLoginUserListener onLoginUserListener);



    }
}
