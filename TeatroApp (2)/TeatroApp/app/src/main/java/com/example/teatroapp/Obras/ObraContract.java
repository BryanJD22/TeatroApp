package com.example.teatroapp.Obras;

import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public interface ObraContract {

    public interface View{
        void sucessListObras(ArrayList<Obra> lstObras);

        void sucessObraPorTitulo(ArrayList<Obra> lstObras);


        void sendRequestTopVentas(ArrayList<Obra> lstObras);
        void sendRequestTopPopular(ArrayList<Obra> lstObras);

        void failureListObras(String message);
    }
    public interface Presenter{
        void getObra();//la original
        void getObraTopVentas();

        void getObraTopPopular();



    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstObrasListener{
            void onFinished(ArrayList<Obra> lstObras);

            public void obraportitulo(ArrayList<Obra> lstObras);

            void onFailure(String error);
        }
        void getObrasService(OnLstObrasListener onLstObrasListener);
    }
}
