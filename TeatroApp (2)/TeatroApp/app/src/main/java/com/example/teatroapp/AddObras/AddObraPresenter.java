package com.example.teatroapp.AddObras;

import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class AddObraPresenter implements AddContract.Presenter{

    private AddContract.View vista;
    private AddObrasModel model;


    public AddObraPresenter(AddContract.View vista) {
        this.vista = vista;
        this.model = new AddObrasModel();
    }

    @Override
    public void add(Obra obra) {
        this.model.addObra(obra, new AddContract.Model.OnLstObrasListener() {
            @Override
            public void onFinished(ArrayList<Obra> lstObras) {
                vista.sucessAdd(lstObras);
            }

            @Override
            public void onFailure(String error) {

            }
        });

    }
}
