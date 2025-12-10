package com.pife.ejemplo_examen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

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
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });
//            personajes = new MainActivity().generaPersonajes();
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

            ImageView ivFotoPerso = findViewById(R.id.ivFotoPerso);
            EditText etNombre = findViewById(R.id.etNombre);
            RatingBar ratingBar = findViewById(R.id.ratingBar);
            Button bGuardar = findViewById(R.id.bGuardar);

//            int pos = getIntent().getIntExtra("posicion", -1);
            Personaje personaje = (Personaje) getIntent().getSerializableExtra("perso");
            if(personaje!=null){
                  ivFotoPerso.setImageResource(personaje.getImagen());
                  etNombre.setText(personaje.getNombre());
                  ratingBar.setRating(personaje.getValoracion());
            }

            bGuardar.setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {
                        etNombre.setText("");
                        ratingBar.setRating(0);
                        return true;
                  }
            });

            bGuardar.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        String nombre = etNombre.getText().toString().trim();

                        if (!nombre.isEmpty()) {
                              float rating = ratingBar.getRating();

                              Intent it= new Intent(MainActivityModificar.this, MainActivity.class);
                              it.putExtra("nombre", nombre);
                              it.putExtra("valoracion", rating);
                              setResult(RESULT_OK, it);
                              finish();

                        } else {
                              Toast.makeText(MainActivityModificar.this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
                        }
                  }
            });
      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }

            return super.onOptionsItemSelected(item);
      }
}