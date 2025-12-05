package com.pife.ejemplo_examen;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiCelda>{
      ArrayList<Personaje> personajes;

      int pos = RecyclerView.NO_POSITION;

      public int getPos() {
            return pos;
      }

      public void setPos(int posPulsado) {
            if(this.pos == posPulsado){
                  this.pos = RecyclerView.NO_POSITION;
                  notifyItemChanged(posPulsado);
            }else{
                  notifyItemChanged(pos);
                  this.pos = posPulsado;
                  notifyItemChanged(pos);
            }
      }

      public Adaptador(ArrayList<Personaje> personajes ) {
            this.personajes = personajes;
      }

      @NonNull
      @Override
      public MiCelda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View Celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent,false);
            return new MiCelda(Celda);
      }

      @Override
      public void onBindViewHolder(@NonNull MiCelda holder, int position) {
      Personaje personaje = personajes.get(position);
      holder.ivFoto.setImageResource(personaje.getImagen());
      holder.tvPosicion.setText(position + "");
      holder.tvNombre.setText(personaje.getNombre());

      if(position == this.pos){
            holder.itemView.setBackgroundResource(R.color.Marcado);
            Toast.makeText(holder.itemView.getContext(), personaje.getNombre()+"\n"+ personaje.getPelicula()+"\n"+ personaje.getValoracion(), Toast.LENGTH_SHORT).show();
      }else{
            holder.itemView.setBackgroundResource(R.color.NoMarcado);
      }
      }

      @Override
      public int getItemCount() {
            return personajes.size();
      }

      public class MiCelda extends RecyclerView.ViewHolder{
      TextView tvPosicion, tvNombre;
      ImageView ivFoto;
            public MiCelda(@NonNull View itemView) {
                  super(itemView);
                  this.ivFoto = itemView.findViewById(R.id.ivFoto);
                  this.tvNombre = itemView.findViewById(R.id.tvNombre);
                  this.tvPosicion = itemView.findViewById(R.id.tvPosicion);
                  itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                              int pos = getAbsoluteAdapterPosition();
                              setPos(pos);
                              //El get context se usa para traer la main al adaptador
                              //Traemos la posicion de arriba y si esta marcada ponemos el nombre de personaje como titulo de la actionBar
                              //Si no se pone Hotel Transilvania
                              MainActivity main = (MainActivity) itemView.getContext();
                               if (getPos() !=RecyclerView.NO_POSITION) {
                                     main.actionBar.setTitle(personajes.get(pos).getNombre());
                               }else main.actionBar.setTitle("Hotel Transilvania");
                        }
                  });
            }
      }
}
