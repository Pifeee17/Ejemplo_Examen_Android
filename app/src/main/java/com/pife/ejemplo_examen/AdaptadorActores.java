package com.pife.ejemplo_examen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorActores extends RecyclerView.Adapter<AdaptadorActores.MiCeldaActores>{
      ArrayList<Personaje> personajes;

      public AdaptadorActores(ArrayList<Personaje> personajes) {
            this.personajes = personajes;
      }

      @NonNull
      @Override
      public MiCeldaActores onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View Celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celdaactores, parent,false);
            return new MiCeldaActores(Celda);
      }

      @Override
      public void onBindViewHolder(@NonNull MiCeldaActores holder, int position) {
      Personaje personaje = personajes.get(position);
      holder.ivActores.setImageResource(personaje.getImagenActor());
      holder.tvActores.setText(personaje.getNombre() + "\n" + personaje.getActorOriginal());
      }

      @Override
      public int getItemCount() {
            return personajes.size();
      }

      public class MiCeldaActores extends RecyclerView.ViewHolder {
            ImageView ivActores;
            TextView tvActores;
            public MiCeldaActores(@NonNull View itemView) {
                  super(itemView);
                  ivActores = itemView.findViewById(R.id.ivActores);
                  tvActores = itemView.findViewById(R.id.tvActores);
            }
      }
}
