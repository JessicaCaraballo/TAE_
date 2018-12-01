package com.example.jessi.tae;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class galeriaFragment extends DialogFragment {
    View view;
    TextView titulo;
    RecyclerView recyclerViewGaleria;
    ImageView imagen;
    ImageView salir;
    ArrayList<Menu> listaMenu;
    RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_galeria, container, false);
        salir = (ImageView)view.findViewById(R.id.salir);
        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagen);
        recyclerViewGaleria = (RecyclerView) view.findViewById(R.id.galeria);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        recyclerViewGaleria.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        listaMenu = new Menu().listaMenu();
        adapter = new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnClickRecycler() {
            @Override
            public void OnclickItemRecycler(Menu menu) {
                Glide.with(getContext()).load(menu.getIdImagen()).into(imagen);
                titulo.setText(menu.getTitulo());
            }
        });

        recyclerViewGaleria.setAdapter(adapter);

        return view;
    }
}
