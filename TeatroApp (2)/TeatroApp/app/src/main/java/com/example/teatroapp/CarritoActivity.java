package com.example.teatroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.teatroapp.Adapter.AdaptarCarrito;
import com.example.teatroapp.Adapter.AdapterHistorial;
import com.example.teatroapp.Compra.CompraContract;
import com.example.teatroapp.Compra.CompraPresenter;
import com.example.teatroapp.Obras.ObraContract;
import com.example.teatroapp.Salas.SalaContract;
import com.example.teatroapp.Salas.SalaPresenter;
import com.example.teatroapp.Valorar.ValorarContract;
import com.example.teatroapp.Valorar.ValorarPresenter;
import com.example.teatroapp.beans.Carrito;
import com.example.teatroapp.beans.CarritoInfo;
import com.example.teatroapp.beans.Confirm;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.ObraSala;
import com.example.teatroapp.beans.Sala;
import com.example.teatroapp.beans.Valoracion;

import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity implements CompraContract.View {
    ArrayList<CarritoInfo> carritoInfos;

    ArrayList<Carrito> carritoHistorial;
    CompraPresenter compraPresenter;
    private RecyclerView recyclerViewCarrito, recyclerViewCarritoHistorial;
    private RecyclerView.Adapter adapterCarrito, adapterHistorial;
    Button confirmarCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        //pedir permisos para enviar notificacion al movil
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(CarritoActivity.this,
                    android.Manifest.permission.POST_NOTIFICATIONS) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(CarritoActivity.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        int idUser = getIntent().getIntExtra("idUser", 0);
        int idobra = getIntent().getIntExtra("idObra", 0);
        int idsala = getIntent().getIntExtra("idSala", 0);
        int idOObraSala = getIntent().getIntExtra("idObraSala", 0);

        compraPresenter = new CompraPresenter(this);



        compraPresenter.loadCarrito(String.valueOf(idUser));

        compraPresenter.loadHistorial(String.valueOf(idUser));
        sucessHistorial(carritoHistorial);


        confirmarCompra = findViewById(R.id.CarritoConfirmarBtn);

        confirmarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compraPresenter.confirmar(String.valueOf(idUser));
                makeNotifiation();
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                intent.putExtra("idSala", idsala);
                intent.putExtra("idObra", idobra);

                intent.putExtra("idUser", idUser);
                startActivity(intent);

            }
        });




    }

    @Override
    public void sucessListFechas(ArrayList<ObraSala> lstobraSala) {

    }

    @Override
    public void sucessCarrito(ArrayList<CarritoInfo> carrito) {
        this.carritoInfos = carrito;
        recyclerViewCarrito = findViewById(R.id.Carrito);
        adapterCarrito = new AdaptarCarrito(this,carrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        recyclerViewCarrito.setAdapter(adapterCarrito);

    }

    @Override
    public void confirmado(Confirm confirm) {

    }

    @Override
    public void sucessHistorial(ArrayList<Carrito> carrito) {
        this.carritoHistorial = carrito;
        recyclerViewCarritoHistorial = findViewById(R.id.CarritoHistorial);
        adapterHistorial = new AdapterHistorial(this,carrito);
        recyclerViewCarritoHistorial.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        recyclerViewCarritoHistorial.setAdapter(adapterHistorial);

    }

    @Override
    public void failureListFechas(String message) {

    }

    public void makeNotifiation(){
        String channelID = "CHANNEL_ID";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelID);
        builder.setSmallIcon(R.drawable.done_icon)
                .setContentTitle("Confirmación de compra")
                .setContentText("Compra de entrada hecha, recibiras un correo en unos segundos .")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(getApplicationContext(), CarritoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelID);
            if(notificationChannel == null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelID, "Canal para notificaciones", importance);
                notificationChannel.setLightColor(R.color.white);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        notificationManager.notify(0, builder.build());
    }
}