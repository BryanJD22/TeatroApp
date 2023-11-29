package com.example.teatroapp.AddObras;

import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public interface AddContract {
    public interface View{
        void sucessAdd(ArrayList<Obra> lstObras);
        void failureListFilms(String message);
    }
    public interface Presenter{
        void add(Obra obra);

    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstObrasListener{
            void onFinished(ArrayList<Obra> lstObras);
            void onFailure(String error);
        }
        void getObrasService(OnLstObrasListener onLstObrasListener);
    }
}
