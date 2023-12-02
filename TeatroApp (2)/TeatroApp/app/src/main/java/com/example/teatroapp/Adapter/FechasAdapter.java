package com.example.teatroapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.CarritoActivity;
import com.example.teatroapp.ObrasActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;

import java.util.ArrayList;

public class FechasAdapter extends RecyclerView.Adapter<FechasAdapter.ViewHolder>{
    ArrayList<ObraSala> listObraSalas;
    Context context;
    int idUser;

    public FechasAdapter(ArrayList<ObraSala> listObraSalas, int idUser) {
        this.listObraSalas = listObraSalas;
        this.idUser = idUser;
    }


    @NonNull
    @Override
    public FechasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FechasAdapter.ViewHolder holder, int position) {

        ObraSala obraSala = listObraSalas.get(position);
        holder.fechaTxt.setText(obraSala.getFecha().toString());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CarritoActivity.class);
            intent.putExtra("idSala", obraSala.getIdSala());
            intent.putExtra("idObra", obraSala.getIdObra());
            intent.putExtra("idUser", idUser);

            context.startActivity(intent);

        });

    }


    @Override
    public int getItemCount() {return 0;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fechaTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fechaTxt = itemView.findViewById(R.id.categoriaTxt);
        }
    }


}
