package com.example.teatroapp.Valorar;

import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class ValorarPresenter implements ValorarContract.Presenter{

    private ValorarContract.View vista;
    private ValorarModel modelo;

    public ValorarPresenter(ValorarContract.View vista) {
        this.vista = vista;
        this.modelo = new ValorarModel();
    }

    @Override
    public void getValoraciones() {

    }

    public void getObraById(String idObra){
        this.modelo.getObrasPorID(idObra, new ValorarContract.Model.OnLstValoracionesListener() {
            @Override
            public void onFinished(ArrayList<Valoracion> lstValoraciones) {

            }

            @Override
            public void getObrasByid(ArrayList<Obra> lstObras) {
                vista.sendRequestObras(lstObras);
            }

            @Override
            public void onFailure(String error) {

            }
        });

    }

    public void addValoracion(Valoracion valoracion){
        this.modelo.addValoracion(valoracion, new ValorarContract.Model.OnLstValoracionesListener() {
            @Override
            public void onFinished(ArrayList<Valoracion> lstValoraciones) {
                    vista.sucessLstValoraciones(lstValoraciones);
            }

            @Override
            public void getObrasByid(ArrayList<Obra> lstObras) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
}
