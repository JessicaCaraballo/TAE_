package com.example.jessi.tae;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Load on 30/11/2018.
 */

public class Menu {
    private int idImagen;
    private String titulo;

    public Menu(){
        idImagen = 0;
        titulo = "";
    }
    public Menu(int idImagen, String titulo){
        this.idImagen = idImagen;
        this.titulo = titulo;
    }

    public int getIdImagen(){
        return idImagen;
    }
    public String getTitulo(){
        return titulo;
    }

    public ArrayList<Menu> listaMenu(){
        Menu menu;
        ArrayList<Menu> lista = new ArrayList<Menu>();

        Integer[]idImagenes = new Integer[]{R.drawable.foto, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4};
        String[]titulos = new String[]{"Foto 1", "Foto 2", "Foto 3", "Foto 4"};

        for(int x = 0; x<idImagenes.length; x++){
            menu= new Menu(idImagenes[x], titulos[x]);
            lista.add(menu);

        }

        return lista;
    }
}
