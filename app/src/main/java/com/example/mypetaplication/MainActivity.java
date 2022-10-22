package com.example.mypetaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.mypetaplication.adapter.MascotaAdaptador;
import com.example.mypetaplication.adapter.PageAdapter;
import com.example.mypetaplication.fragment.PerfilFragment;
import com.example.mypetaplication.fragment.RecyclerViewFragment;
import com.example.mypetaplication.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        /*listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();*/
    }

    public void irMascotaFavoritos(View v){
        Intent intent =  new Intent(this, MascotaFavoritoActivity.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    /*public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Guilmon", R.drawable.digimon_tentomon, 1));
        mascotas.add(new Mascota("Renamon", R.drawable.digimon_renamon, 2));
        mascotas.add(new Mascota("Agumon", R.drawable.digimon_agumon, 3));
        mascotas.add(new Mascota("Calabazin", R.drawable.digimon_calabaza, 4));
        mascotas.add(new Mascota("Ikakkumon", R.drawable.digimon_ikkakumon, 5));
        mascotas.add(new Mascota("Kabuterimon", R.drawable.digimon_kabuterimon, 6));
        mascotas.add(new Mascota("Shakokku", R.drawable.digimon_shakokku, 7));
    }*/
}