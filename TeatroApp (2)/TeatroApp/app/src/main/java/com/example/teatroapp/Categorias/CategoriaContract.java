package com.example.teatroapp.Categorias;

import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public interface CategoriaContract {

    public interface View{
        void sucessListCategorias(ArrayList<Categoria> lstcategoria);



        void failureListCategoria(String message);

        void successListObrasPorCategoria(ArrayList<Obra> lstObras);
    }
    public interface Presenter{
        void getCategoria();//la original


    }
    public interface Model{
        /*Programación Reactiva*/
        interface OnLstCategoriaListener{
            void onFinished(ArrayList<Categoria> lstcategorias);

            void onFailure(String error);

            void obraPorCategoria(ArrayList<Obra> obras);
        }
        void getCategoriasService(CategoriaContract.Model.OnLstCategoriaListener onLstCategoriaListener);
    }
}
