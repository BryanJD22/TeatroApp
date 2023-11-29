package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teatroapp.beans.Usuario;
import com.example.teatroapp.login_user.LoginContract;
import com.example.teatroapp.login_user.LoginPresenter;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    private EditText edtPass;
    private EditText edtEmail;

    private Button btnEnviar;

    private String valorEmail="";
    private String valorPass="";

    Usuario user = new Usuario();

     LoginPresenter presenter =
            new LoginPresenter(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);



        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPass);


        btnEnviar=findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valorEmail=edtEmail.getText().toString();
                valorPass=edtPass.getText().toString();

                user.setEmail(valorEmail);
                user.setPassword(valorPass);

                //1ºValidamos el formato de los datos insertados
                if(comprobarEmail(valorEmail) && comprobarPass(valorPass)){
                    presenter.login2(user);


                }

                }
        });


    }

    private boolean comprobarEmail(String email) {
        if(email.isEmpty()){
            edtEmail.setError("El email no puede quedar vacío");
            return false;

        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Email no válido");
            return false;

        }else{

            edtEmail.setError(null);
            return true;

        }
    }

    private boolean comprobarPass(String pass) {
        if(pass.isEmpty() || pass.equals("")){
            edtPass.setError("La contraseña no puede quedar vacía");
            return false;
        }

        return true;
    }

    @Override
    public void sucessLogin(ArrayList<Usuario> usuarios) {
        System.out.println("Login Hecho");
        int userId = usuarios.get(0).getUserId();

        if (isAdministrador(userId)) {
            // Caso de administrador
            Intent adminIntent = new Intent(LoginActivity.this, SalasActivity.class);
            startActivity(adminIntent);
        } else {
            //Caso Usuario
            Intent userIntent = new Intent(LoginActivity.this, UserActivity.class);
            startActivity(userIntent);
        }

    }
    private boolean isAdministrador(int userId) {
        return userId == 1 || userId == 2 || userId == 3;
    }
    @Override
    public void failureLogin(String message) {

    }

}