package com.example.teatroapp.Obras;

import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Usuario;

import java.util.ArrayList;

public class ObraPresenter extends ArrayList<Obra> implements ObraContract.Presenter {

    private ObraContract.View vista;
    private ObraModel modelo;

    public ObraPresenter(ObraContract.View vista) {
        this.vista = vista;
        this.modelo = new ObraModel();
    }


    @Override
    public void getObra() {
        this.modelo.getObrasService(new ObraContract.Model.OnLstObrasListener(){

            @Override
            public void onFinished(ArrayList<Obra> lstObras) {

                vista.sucessListObras(lstObras);
            }



            @Override
            public void onFailure(String error) {

            }
        });


    }
    public void getObrasPorSala(String idSala) {
        this.modelo.getObrasPorSala(idSala, new ObraContract.Model.OnLstObrasListener(){
            @Override
            public void onFinished(ArrayList<Obra> lstObras) {

                vista.sucessListObras(lstObras);
            }



            @Override
            public void onFailure(String error) {

            }

        });
    }


    public void getObraTopVentas() {
        this.modelo.getObrasTopVentas(new ObraContract.Model.OnLstObrasListener(){

            @Override
            public void onFinished(ArrayList<Obra> lstObras) {

                vista.sendRequestTopVentas(lstObras);
            }



            @Override
            public void onFailure(String error) {

            }
        });


    }

    public void getObraTopPopular() {
        this.modelo.getObrasTopPopular(new ObraContract.Model.OnLstObrasListener() {
            @Override
            public void onFinished(ArrayList<Obra> lstObras) {
                vista.sendRequestTopPopular(lstObras);
            }



            @Override
            public void onFailure(String error) {
                vista.failureListObras(error);
            }
        });
    }







}
