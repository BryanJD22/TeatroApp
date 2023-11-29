package com.example.teatroapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.teatroapp.DetallesActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.SalasActivity;
import com.example.teatroapp.beans.Obra;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UObrasAdapter extends RecyclerView.Adapter<UObrasAdapter.ViewHolder> {
    private ArrayList<Obra> lstObras;
    private int idUser;
    Context context;

    public UObrasAdapter(ArrayList<Obra> lstObras, int idUser) {
        this.idUser = idUser;
        this.lstObras = lstObras;
    }

    @NonNull
    @Override
    public UObrasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_obra, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull UObrasAdapter.ViewHolder holder, int position) {
        Obra obra = lstObras.get(position);
        holder.tituloObra.setText(lstObras.get(position).getTituloObra());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(30));

        //holder.pic.setImageResource(R.drawable.sukuna);

        /*Picasso.get()
                .load(obra.getImagenObra()) // Reemplaza con el método que obtiene la URL de la imagen
                .placeholder(R.drawable.sukuna) // Reemplaza con tu recurso de imagen de carga
                .into(holder.pic);*/

        Glide.with(context)
                .load(lstObras.get(position).getImagenObra())
                .apply(requestOptions)
                .placeholder(R.drawable.sukuna)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetallesActivity.class);
            intent.putExtra("idObra", lstObras.get(position).getIdObra());
            intent.putExtra("tituloObra", lstObras.get(position).getTituloObra());
            intent.putExtra("idUser", idUser);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstObras.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tituloObra;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloObra = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
