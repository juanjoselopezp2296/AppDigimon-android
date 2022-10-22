package com.example.mypetaplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetaplication.pojo.Mascota;
import com.example.mypetaplication.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que el obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFotoMascota());
        holder.tvNombreMascota.setText(mascota.getNombreMascota());
        holder.tvLikeMascota.setText(String.valueOf(mascota.getLikeMascota()));

        holder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombreMascota(),
                                Toast.LENGTH_SHORT).show();
                //Agregamos el nuevo like
                mascotas.get(position).setLikeMascota(mascota.getLikeMascota() + 1);
                //Asignamos el nuevo valor al textView de Like
                holder.tvLikeMascota.setText(String.valueOf(mascota.getLikeMascota()));
            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView  tvNombreMascota;
        private TextView  tvLikeMascota;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikeMascota = (TextView) itemView.findViewById(R.id.tvLikeCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
