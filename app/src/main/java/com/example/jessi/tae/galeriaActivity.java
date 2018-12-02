package com.example.jessi.tae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class galeriaActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private Button boton1;
    private FrameLayout frame;

    View view;
    TextView titulo;
    RecyclerView recyclerViewGaleria;
    ImageView imagen;
    ImageView salir;
    ArrayList<com.example.jessi.tae.Menu> listaMenu;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        setContentView(R.layout.activity_galeria);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.galeriaImagenes);
/**/
        LayoutInflater inflater = (LayoutInflater) this.getLayoutInflater();
        //ViewGroup container = (ViewGroup) this.vie

        frame = (FrameLayout) findViewById(R.id.frame);

        view = inflater.inflate(R.layout.fragment_galeria, null, false);
        salir = (ImageView)view.findViewById(R.id.salir);
        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagen);
        recyclerViewGaleria = (RecyclerView) view.findViewById(R.id.galeria);
/*
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
*/
        recyclerViewGaleria.setLayoutManager(new LinearLayoutManager(frame.getContext(), LinearLayoutManager.HORIZONTAL, false));
        listaMenu = new com.example.jessi.tae.Menu().listaMenu();
        adapter = new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnClickRecycler() {
            @Override
            public void OnclickItemRecycler(com.example.jessi.tae.Menu menu) {
                Glide.with(frame.getContext()).load(menu.getIdImagen()).into(imagen);
                titulo.setText(menu.getTitulo());
            }
        });

        recyclerViewGaleria.setAdapter(adapter);

        frame.removeAllViews();
        frame.addView(view);
/**/
        //LayoutInflater inflater = (LayoutInflater) this.getLayoutInflater();
        //ViewGroup container = (ViewGroup) this.findViewById(R.id.frame);

        //View view = GenerarGaleria(inflater, container, savedInstanceState);
    }

    protected void onCreate2(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        setContentView(R.layout.activity_galeria);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.galeriaImagenes);

        GenerarGaleria(inflater, container, savedInstanceState);

        //mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        //mDrawerLayout.addDrawerListener(mToogle);
        //mToogle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //NavigationView navigationView = (NavigationView) findViewById(R.id.navAmarillo);
        //View headerView = navigationView.getHeaderView(0);
        //TextView _email = (TextView) headerView.findViewById(R.id.txtemail);
        //_email.setText(usuario.getEmail());

        /*boton1 = (Button)findViewById(R.id.botonsubir1);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*
                FragmentManager manager = getSupportFragmentManager();
                galeriaFragment galeria = new galeriaFragment();
                galeria.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.transparente);
                galeria.show(manager,"");
                */

                /*Intent galeria = new Intent(getApplicationContext(), galeriaActivity.class);
                galeria.putExtra("usuario", (Serializable) usuario);
                galeria.putExtra("galeria", (Serializable) "amarilloataquesActivity");
                startActivity(galeria);
            }
        });*/
/*
        FragmentManager fm = getSupportFragmentManager();
        fragment = (FrameLayout) findViewById(R.id.frame);
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            //fragment =new galeriaFragment();
            ft.add(android.R.id.content,fragment,"myFragmentTag");
            ft.commit();
        }*/
    }


    public View GenerarGaleria(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {

        frame = (FrameLayout) view.findViewById(R.id.frame);
        view = inflater.inflate(R.layout.fragment_galeria, container, false);
        salir = (ImageView)view.findViewById(R.id.salir);
        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagen);
        recyclerViewGaleria = (RecyclerView) view.findViewById(R.id.galeria);
/*
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
*/
        recyclerViewGaleria.setLayoutManager(new LinearLayoutManager(frame.getContext(), LinearLayoutManager.HORIZONTAL, false));
        listaMenu = new com.example.jessi.tae.Menu().listaMenu();
        adapter = new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnClickRecycler() {
            @Override
            public void OnclickItemRecycler(com.example.jessi.tae.Menu menu) {
                Glide.with(frame.getContext()).load(menu.getIdImagen()).into(imagen);
                titulo.setText(menu.getTitulo());
            }
        });

        recyclerViewGaleria.setAdapter(adapter);

        return view;
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ////this.mMenu = menu;
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.drawermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void Volver(View view) {
        Intent amarillo = new Intent(getApplicationContext(),amarilloActivity.class);
        amarillo.putExtra("usuario", (Serializable) usuario);
        startActivity(amarillo);
    }
}
