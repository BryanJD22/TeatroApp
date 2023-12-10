package com.example.teatroapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.R; // Asegúrate de cambiar esto al paquete correcto
import com.example.teatroapp.beans.Carrito;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterHistorial extends RecyclerView.Adapter<AdapterHistorial.HistorialViewHolder> {
    private Context context;
    private ArrayList<Carrito> lstHistorial;
    private LayoutInflater inflater;

    public AdapterHistorial(Context context, ArrayList<Carrito> lstHistorial) {
        this.lstHistorial = lstHistorial;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.historial_card, parent, false);
        return new HistorialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
        Carrito carrito = lstHistorial.get(position);

        holder.CarritoHistorialId.setText(String.valueOf(carrito.getIdCompra()));
        holder.CarritoHistorialFecha.setText(carrito.getFechaAgregado());
        holder.CarritoHistorialPrecio.setText(String.format("%s €", carrito.getCantidad()));

        // Puedes agregar lógica adicional aquí para cargar y mostrar imágenes si es necesario
    }

    @Override
    public int getItemCount() {
        return lstHistorial.size();
    }

    public static class HistorialViewHolder extends RecyclerView.ViewHolder {
        public TextView CarritoHistorialId, CarritoHistorialFecha, CarritoHistorialPrecio;

        public HistorialViewHolder(@NonNull View itemView) {
            super(itemView);

            CarritoHistorialId = itemView.findViewById(R.id.CarritoHistorialId);
            CarritoHistorialFecha = itemView.findViewById(R.id.CarritoHistorialFecha);
            CarritoHistorialPrecio = itemView.findViewById(R.id.CarritoHistorialPrecio);
        }
    }
}
