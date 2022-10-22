package com.example.mypetaplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypetaplication.R;
import com.example.mypetaplication.adapter.MascotaAdaptador;
import com.example.mypetaplication.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
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
    }
}
