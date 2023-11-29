package com.example.teatroapp.Salas;

import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

public interface SalaContract {
    public interface View{
        void sucessLstSalas(ArrayList<Sala> lstSalas);
        void failureListFilms(String message);
    }
    public interface Presenter{
        void getSalas();//la original

    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstSalasListener{
            void onFinished(ArrayList<Sala> lstSalas);
            void onFailure(String error);
        }
        void getSalasService(OnLstSalasListener onLstSalasListener);
    }
}
