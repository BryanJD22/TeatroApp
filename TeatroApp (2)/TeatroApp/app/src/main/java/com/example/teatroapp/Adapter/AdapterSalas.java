package com.example.teatroapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.ObrasActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.beans.Sala;

import java.util.ArrayList;

public class AdapterSalas extends RecyclerView.Adapter<AdapterSalas.SalasViewHolder> {
    private ArrayList<Sala> lstsalas;
    private Context context;

    public AdapterSalas(ArrayList<Sala> lstsalas, Context context) {
        this.lstsalas = lstsalas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterSalas.SalasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.salas_row,parent,false);
        return new SalasViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterSalas.SalasViewHolder holder, int position) {
        Sala sala = lstsalas.get(position);

        /*if (sala.getImgSala() != null) {
            Picasso.get()
                    .load(sala.getImgSala())
                    .placeholder(R.drawable.pruebaimagentoji2)
                    .into(holder.imageSala);
        } else {
            // Aquí puedes manejar el caso en que la URL de la imagen sea nula
            // Por ejemplo, puedes establecer una imagen predeterminada o realizar alguna otra acción.
            holder.imageSala.setImageResource(R.drawable.pruebaimagentoji2);
        }*/
        holder.imageSala.setImageResource(R.drawable.sukuna);

        holder.idSala.setText(String.valueOf(lstsalas.get(position).getIdSala()));


        holder.nombreSala.setText(lstsalas.get(position).getNombre());

        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(context, ObrasActivity.class);
            intent.putExtra("idSala", String.valueOf(lstsalas.get(position).getIdSala()));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return lstsalas.size();
    }

    public class SalasViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView idSala;
        ImageView imageSala;
        TextView nombreSala;
        public SalasViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            idSala = itemView.findViewById(R.id.idSala);
            imageSala = itemView.findViewById(R.id.imageView);
            nombreSala = itemView.findViewById(R.id.textView);



        }
    }
}
