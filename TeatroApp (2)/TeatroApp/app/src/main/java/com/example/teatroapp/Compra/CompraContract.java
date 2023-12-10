package com.example.teatroapp.Compra;

import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Confirm;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

public interface CompraContract {

    public interface View{
        void sucessListFechas(ArrayList<ObraSala> lstobraSala);
        void sucessCarrito(ArrayList<CarritoInfo> carrito);

        void confirmado(Confirm confirm);

        void sucessHistorial(ArrayList<Carrito> carrito);

        void failureListFechas(String message);

    }
    public interface Presenter{

        void getFechas(String idObra);//la original


    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstObraSalaListener{
            void add(ArrayList<Carrito> lstcarrito);
            void loadCarrito(ArrayList<CarritoInfo> carrito);
            void loadHistorial(ArrayList<Carrito> carrito);

            void confirmado(Confirm confirm);

            void onFinished(ArrayList<ObraSala> lstobraSala);

            void onFailure(String error);

        }
        void getFechas(String idObra, CompraContract.Model.OnLstObraSalaListener onLstObraSalaListener);
    }
}
