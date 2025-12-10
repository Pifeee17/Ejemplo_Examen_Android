package com.pife.ejemplo_examen;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivityModificar extends AppCompatActivity {
ArrayList<Personaje> personajes;
Adaptador ada;

ActionBar actionBar;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main_modificar);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            personajes = new MainActivity().generaPersonajes();
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

            ImageView ivFotoPerso = findViewById(R.id.ivFotoPerso);
            EditText etNombre = findViewById(R.id.etNombre);
            RatingBar ratingBar = findViewById(R.id.ratingBar);
            Button bGuardar = findViewById(R.id.bGuardar);

            int pos = getIntent().getIntExtra("posicion", -1);
            Personaje personaje = personajes.get(pos);
            if(pos >= 0){
                  ivFotoPerso.setImageResource(personaje.getImagen());
                  etNombre.setText(personaje.getNombre());
                  ratingBar.setRating(personaje.getValoracion());
            }
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }

            return super.onOptionsItemSelected(item);
      }
}