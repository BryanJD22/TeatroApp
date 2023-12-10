package com.example.teatroapp.Compra;

import com.example.teatroapp.Categorias.CategoriaContract;
import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

public interface CompraContract {

    public interface View{
        void sucessListFechas(ArrayList<ObraSala> lstobraSala);

        void failureListFechas(String message);

    }
    public interface Presenter{

        void getFechas(String idObra);//la original


    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstObraSalaListener{
            void add(ArrayList<Carrito> lstcarrito);
            void onFinished(ArrayList<ObraSala> lstobraSala);

            void onFailure(String error);

        }
        void getFechas(String idObra, CompraContract.Model.OnLstObraSalaListener onLstObraSalaListener);
    }
}
