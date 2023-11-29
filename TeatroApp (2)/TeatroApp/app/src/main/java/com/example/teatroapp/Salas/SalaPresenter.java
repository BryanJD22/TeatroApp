package com.example.teatroapp.Salas;

import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

public class SalaPresenter implements  SalaContract.Presenter{
    private SalaContract.View vista;

    private SalaModel modelo;

    public SalaPresenter(SalaContract.View vista) {
        this.vista = vista;
        this.modelo = new SalaModel();
    }

    @Override
    public void getSalas() {

        this.modelo.getSalasService(new SalaContract.Model.OnLstSalasListener() {
            @Override
            public void onFinished(ArrayList<Sala> lstSalas) {
                vista.sucessLstSalas(lstSalas);
            }

            @Override
            public void onFailure(String error) {

            }
        });

    }
}
