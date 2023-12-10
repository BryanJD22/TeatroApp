package com.example.teatroapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.R;
import com.example.teatroapp.beans.CarritoInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptarCarrito extends RecyclerView.Adapter<AdaptarCarrito.CarritoViewHolder>{
    private Context context;
    private ArrayList<CarritoInfo> lstCarrito;
    private LayoutInflater inflater;


    public AdaptarCarrito(Context context, ArrayList<CarritoInfo> lstCarrito) {

        this.lstCarrito = lstCarrito;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.obra_card_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        CarritoInfo carritoInfo = lstCarrito.get(position);

        holder.CtituloObra.setText(carritoInfo.getTituloObra());
        holder.CnombreSala.setText(carritoInfo.getNombreSala());
        holder.Cduracion.setText(String.valueOf(carritoInfo.getDuracionObra()));
        holder.Cfecha.setText(carritoInfo.getFechaFuncion());

        // Usa Picasso para cargar y mostrar la imagen
        Picasso.get()
                .load(carritoInfo.getImagenObra())
                .placeholder(R.drawable.pruebaimagentoji)
                .into(holder.Cimagen);

        holder.CartItemPrice.setText(String.format("%s €", carritoInfo.getPrecioObra()));

        holder.CartItemCantidad.setText(String.format("x%d", carritoInfo.getCantidad()));

        holder.deleteCarrito.setOnClickListener(v -> {
            // Lógica para eliminar un elemento del carrito aquí
            // Puedes utilizar algún método del presenter o del adaptador para manejar la eliminación
        });
    }

    @Override
    public int getItemCount() {
        return lstCarrito.size();
    }

    public static class CarritoViewHolder extends RecyclerView.ViewHolder {

        public ImageView Cimagen, deleteCarrito;
        public TextView CtituloObra, Cdesc, CnombreSala, Cduracion, Cfecha, CartItemPrice, CartItemCantidad;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);

            Cimagen = itemView.findViewById(R.id.Cimagen);
            CtituloObra = itemView.findViewById(R.id.CtituloObra);
            CnombreSala = itemView.findViewById(R.id.CnombreSala);
            Cduracion = itemView.findViewById(R.id.Cduracion);
            Cfecha = itemView.findViewById(R.id.Cfecha);
            CartItemPrice = itemView.findViewById(R.id.CartItemPrice);
            CartItemCantidad = itemView.findViewById(R.id.CartItemCantidad);
            deleteCarrito = itemView.findViewById(R.id.deleteCarrito);
        }
    }

}
