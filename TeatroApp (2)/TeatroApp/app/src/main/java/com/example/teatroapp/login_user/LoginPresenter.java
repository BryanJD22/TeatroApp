package com.example.teatroapp.login_user;

import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.Model.OnLoginUserListener{

    private LoginContract.View vista;
    private LoginModel modelo;

    public LoginPresenter(LoginContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginModel();
    }
    @Override
    public void login(Usuario usuario) {
        this.modelo.getUsuarios(usuario, this);

    }
    public void login2(Usuario usuario) {
        this.modelo.login(usuario, this);

    }

    @Override
    public void onFinished(ArrayList<Usuario> usuarios) {

        vista.sucessLogin(usuarios);
    }

    @Override
    public void onFailure(String error) {

    }
}
