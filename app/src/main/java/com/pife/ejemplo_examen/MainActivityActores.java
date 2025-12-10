package com.pife.ejemplo_examen;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivityActores extends AppCompatActivity {

      ActionBar actionBar;
      GridLayoutManager gridLayoutManager;
      AdaptadorActores ada;
      RecyclerView rv;
      ArrayList<Personaje> personajes;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main_actores);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                  return insets;
            });

            personajes = new MainActivity().generaPersonajes();

            actionBar = getSupportActionBar();
            actionBar.setTitle("Actores");
            actionBar.setDisplayHomeAsUpEnabled(true);

            rv = findViewById(R.id.rv2);

            gridLayoutManager = new GridLayoutManager(this,2);
            rv.setLayoutManager(gridLayoutManager);

            ada = new AdaptadorActores(personajes);

            rv.setAdapter(ada);

      }

      @Override
      public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home){
                  getOnBackPressedDispatcher().onBackPressed();
            }
            return super.onOptionsItemSelected(item);
      }
}