package com.example.teatroapp.Compra;

import com.example.teatroapp.DetallesActivity;
import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Confirm;
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
            public void add(ArrayList<Carrito> lstcarrito) {

            }

            @Override
            public void loadCarrito(ArrayList<CarritoInfo> carrito) {

            }

            @Override
            public void loadHistorial(ArrayList<Carrito> carrito) {

            }

            @Override
            public void confirmado(Confirm confirm) {

            }

            @Override
            public void onFinished(ArrayList<ObraSala> lstobraSala) {
                    vista.sucessListFechas(lstobraSala);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void agregarAlCarrito(String idUser, String idObraSala, String i) {
        this.modelo.addCarrito(idUser, idObraSala,i,new CompraContract.Model.OnLstObraSalaListener() {
            @Override
            public void add(ArrayList<Carrito> lstcarrito) {

            }

            @Override
            public void loadCarrito(ArrayList<CarritoInfo> carrito) {

            }

            @Override
            public void loadHistorial(ArrayList<Carrito> carrito) {

            }

            @Override
            public void confirmado(Confirm confirm) {

            }

            @Override
            public void onFinished(ArrayList<ObraSala> lstobraSala) {
                vista.sucessListFechas(lstobraSala);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void loadCarrito(String idUser) {
        this.modelo.loadCarrito(idUser,new CompraContract.Model.OnLstObraSalaListener() {
            @Override
            public void add(ArrayList<Carrito> lstcarrito) {

            }

            @Override
            public void loadCarrito(ArrayList<CarritoInfo> carrito) {
                    vista.sucessCarrito(carrito);
            }

            @Override
            public void loadHistorial(ArrayList<Carrito> carrito) {
                    vista.sucessHistorial(carrito);
            }

            @Override
            public void confirmado(Confirm confirm) {

            }

            @Override
            public void onFinished(ArrayList<ObraSala> lstobraSala) {
                vista.sucessListFechas(lstobraSala);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void loadHistorial(String idUser) {
        this.modelo.loadHistorial(idUser,new CompraContract.Model.OnLstObraSalaListener() {
            @Override
            public void add(ArrayList<Carrito> lstcarrito) {

            }

            @Override
            public void loadCarrito(ArrayList<CarritoInfo> carrito) {
                vista.sucessCarrito(carrito);
            }

            @Override
            public void loadHistorial(ArrayList<Carrito> carrito) {
                vista.sucessHistorial(carrito);
            }

            @Override
            public void confirmado(Confirm confirm) {

            }

            @Override
            public void onFinished(ArrayList<ObraSala> lstobraSala) {
                vista.sucessListFechas(lstobraSala);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
    public void confirmar(String idUser) {
        this.modelo.confirmar(idUser,new CompraContract.Model.OnLstObraSalaListener() {
            @Override
            public void add(ArrayList<Carrito> lstcarrito) {

            }

            @Override
            public void loadCarrito(ArrayList<CarritoInfo> carrito) {
                vista.sucessCarrito(carrito);
            }

            @Override
            public void loadHistorial(ArrayList<Carrito> carrito) {
                vista.sucessHistorial(carrito);
            }

            @Override
            public void confirmado(Confirm confirm) {
                vista.confirmado(confirm);
            }

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
