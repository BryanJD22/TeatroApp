package com.example.teatroapp.Valorar;

import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Sala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public interface ValorarContract {

    public interface View{
        void sendRequestObras(ArrayList<Obra> lstObras);
        void sucessLstValoraciones(ArrayList<Valoracion> lstValoraciones);
        void failureListValoraciones(String message);
    }
    public interface Presenter{
        void getValoraciones(String idObra);//la original

    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstValoracionesListener{
            void onFinished(ArrayList<Valoracion> lstValoraciones);
            void getObrasByid(ArrayList<Obra> lstObras);
            void onFailure(String error);
        }
        void getValoracionesService(ValorarContract.Model.OnLstValoracionesListener OnLstValoracionesListener);


    }
}

