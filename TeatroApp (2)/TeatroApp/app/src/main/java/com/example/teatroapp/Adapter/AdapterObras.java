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

import com.example.teatroapp.DetallesActivity;
import com.example.teatroapp.ObrasActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.beans.Obra;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterObras extends RecyclerView.Adapter<AdapterObras.ObrasViewHolder> {

    Context context;
    private ArrayList<Obra> lstObras;
    private LayoutInflater inflater;
    int idObra;

    public AdapterObras(Context context, ArrayList<Obra> lstObras){
        this.lstObras = lstObras;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public AdapterObras.ObrasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.obras_row, parent, false);
        return new ObrasViewHolder(view);
    }




    @Override
    public void onBindViewHolder(ObrasViewHolder holder, int posfila) {
        Obra obra = lstObras.get(posfila);

        holder.AtituloObra.setText(lstObras.get(posfila).getTituloObra());


        holder.Adesc.setText(lstObras.get(posfila).getDescripcionObra());
        // Usa Picasso para cargar y mostrar la imagen
        Picasso.get()
                .load(obra.getImagenObra()) // Reemplaza con el método que obtiene la URL de la imagen
                .placeholder(R.drawable.pruebaimagentoji) // Reemplaza con tu recurso de imagen de carga
                .into(holder.Aimagen);

        holder.itemView.setOnClickListener(e->{
            Intent intent = new Intent(holder.itemView.getContext(), DetallesActivity.class);
            intent.putExtra("idObra", lstObras.get(posfila).getIdObra());
            intent.putExtra("sourceAdapter", "AdapterObras");
            context.startActivity(intent);
        });



        //holder.imagen.setimagelstObras.get(posfila).getImagenObra();


       /* Añadir URL para las imágenes
       String urlImage="http://192.168.104.68:8080/untitle/img/"+

               lstFilms.get(posFila).getUrl()+".png";
       Picasso.get().load(urlImage).into(viewHolder.imagen);


      */
        //  viewHolder.imagen.setImageResource(lstFilms.get(posFila).getImagen());

    }


    public static class ObrasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        CardView cardView;

        public ImageView Aimagen;
        public TextView AtituloObra;

        public TextView Acategoria;
        public TextView Adesc;


        public ObrasViewHolder(View obra) {
            super(obra);
            cardView = obra.findViewById(R.id.cardView2);
            Aimagen = (ImageView) obra.findViewById(R.id.Aimagen);
            AtituloObra = (TextView) obra.findViewById(R.id.AtituloObra);
            //Acategoria = (TextView) obra.findViewById(R.id.Acategoria);
            Adesc = (TextView) obra.findViewById(R.id.Adesc);
            //obra.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }

    }


    /*public AdapterObras(ArrayList<Obra> lstObras) {

        this.lstObras= lstObras;
    }*/

    /*public ObrasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;

        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_obras,
                        viewGroup, false);

        return new ObrasViewHolder(v);
    }*/


    @Override
    public int getItemCount() {
        return lstObras.size();
    }


}
