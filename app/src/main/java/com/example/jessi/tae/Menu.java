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

    public ArrayList<Menu> listaMenu(int idTecnica){
        Menu menu;
        ArrayList<Menu> lista = new ArrayList<Menu>();
        Integer[]idImagenes;
        //Integer[]idImagenes = new Integer[]{R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4};
        switch(idTecnica){
            case 1:
                idImagenes = new Integer[]{R.drawable.f1_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 2:
                idImagenes = new Integer[]{R.drawable.f2_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 3:
                idImagenes = new Integer[]{R.drawable.f3_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 4:
                idImagenes = new Integer[]{R.drawable.f4_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 5:
                idImagenes = new Integer[]{R.drawable.f5_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 6:
                idImagenes = new Integer[]{R.drawable.f6_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 7:
                idImagenes = new Integer[]{R.drawable.f7_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 8:
                idImagenes = new Integer[]{R.drawable.f8_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 9:
                idImagenes = new Integer[]{R.drawable.f9_1, R.drawable.f9_2, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 10:
                idImagenes = new Integer[]{R.drawable.f10_1, R.drawable.f10_2, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 11:
                idImagenes = new Integer[]{R.drawable.f11_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 12:
                idImagenes = new Integer[]{R.drawable.f12_1, R.drawable.f12_2, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 13:
                idImagenes = new Integer[]{R.drawable.f13_1, R.drawable.f13_1, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 14:
                idImagenes = new Integer[]{R.drawable.f14_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 15:
                idImagenes = new Integer[]{R.drawable.f15_1, R.drawable.f15_2, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
            case 16:
                idImagenes = new Integer[]{R.drawable.f16_1, R.drawable.f16_1, R.drawable.foto_falta, R.drawable.foto_falta};
                break;



            default:
                idImagenes = new Integer[]{R.drawable.f8_1, R.drawable.foto_falta, R.drawable.foto_falta, R.drawable.foto_falta};
                break;
        }
        String[]titulos = new String[]{"Foto 1", "Foto 2", "Foto 3", "Foto 4"};

        for(int x = 0; x<idImagenes.length; x++){
            menu= new Menu(idImagenes[x], titulos[x]);
            lista.add(menu);

        }

        return lista;
    }
}
