package com.example.mypetaplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetaplication.adapter.MascotaAdaptador;
import com.example.mypetaplication.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFavoritoActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotafavorito);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Renamon", R.drawable.digimon_renamon, 2));
        mascotas.add(new Mascota("Agumon", R.drawable.digimon_agumon, 3));
        mascotas.add(new Mascota("Calabazin", R.drawable.digimon_calabaza, 4));
        mascotas.add(new Mascota("Ikakkumon", R.drawable.digimon_ikkakumon, 5));
        mascotas.add(new Mascota("Shakokku", R.drawable.digimon_shakokku, 7));
    }
}
