package com.example.teatroapp.Compra;

import com.example.teatroapp.DetallesActivity;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

public class CompraPresenter implements CompraContract.Presenter{

    private CompraContract.View vista;

    private CompraModel modelo;

    public CompraPresenter(CompraContract.View vista) {
        this.vista = vista;
        this.modelo = new CompraModel();
    }

    @Override
    public void getFechas(String idObra) {
        this.modelo.getFechas(idObra, new CompraContract.Model.OnLstObraSalaListener() {
            @Override
            public void onFinished(ArrayList<ObraSala> lstobraSala) {
                    vista.sucessListFechas(lstobraSala);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
}