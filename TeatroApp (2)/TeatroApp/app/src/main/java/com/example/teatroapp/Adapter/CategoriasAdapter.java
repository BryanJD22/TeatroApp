package com.example.teatroapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.ObrasActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.beans.Categoria;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.ViewHolder> {
    ArrayList<Categoria> listCategorias;
    Context context;

    public CategoriasAdapter(ArrayList<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }

    @NonNull
    @Override
    public CategoriasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasAdapter.ViewHolder holder, int position) {

        Categoria categoria = listCategorias.get(position);
        holder.categoriaTxt.setText(categoria.getNombre_categoria());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ObrasActivity.class);
            intent.putExtra("categoria", categoria.getNombre_categoria());
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return listCategorias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoriaTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoriaTxt = itemView.findViewById(R.id.categoriaTxt);
        }
    }
}
