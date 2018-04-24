package com.example.jessi.tae;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.Serializable;

public class verdeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private ImageButton mImageButtonPosiciones;
    private ImageButton mImageButtonAtaques;
    private ImageButton mImageButtonDefensas;
    private ImageButton mImageButtonPatadas;
    private ImageButton mImageButtonPoomse;
    private ImageButton mImageButtonPum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        setContentView(R.layout.activity_verde);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.verde);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navverde);
        View headerView = navigationView.getHeaderView(0);
        mImageButtonPosiciones = (ImageButton) findViewById(R.id.imageButton2);
        mImageButtonPosiciones.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdePosiciones = new Intent(getApplicationContext(), verdeposicionesActivity.class);
                verdePosiciones.putExtra("usuario", (Serializable) usuario);
                startActivity(verdePosiciones);
            }
        });
        mImageButtonAtaques = (ImageButton) findViewById(R.id.imageButton1);
        mImageButtonAtaques.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdeAtaques = new Intent(getApplicationContext(), verdeataquesActivity.class);
                verdeAtaques.putExtra("usuario", (Serializable) usuario);
                startActivity(verdeAtaques);
            }
        });
        mImageButtonDefensas = (ImageButton) findViewById(R.id.imageButton3);
        mImageButtonDefensas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdeDefensas = new Intent(getApplicationContext(), verdedefensasActivity.class);
                verdeDefensas.putExtra("usuario", (Serializable) usuario);
                startActivity(verdeDefensas);
            }
        });
        mImageButtonPatadas = (ImageButton) findViewById(R.id.imageButton4);
        mImageButtonPatadas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdePatadas = new Intent(getApplicationContext(), verdepatadasActivity.class);
                verdePatadas.putExtra("usuario", (Serializable) usuario);
                startActivity(verdePatadas);
            }
        });
        mImageButtonPum = (ImageButton) findViewById(R.id.imageButton6);
        mImageButtonPum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdePum = new Intent(getApplicationContext(), verdepumActivity.class);
                verdePum.putExtra("usuario", (Serializable) usuario);
                startActivity(verdePum);
            }
        });
        mImageButtonPoomse = (ImageButton) findViewById(R.id.imageButton5);
        mImageButtonPoomse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent verdePoomse = new Intent(getApplicationContext(), verdepoomseActivity.class);
                verdePoomse.putExtra("usuario", (Serializable) usuario);
                startActivity(verdePoomse);
            }
        });
        TextView _email = (TextView) headerView.findViewById(R.id.txtemail);
        _email.setText(usuario.getEmail());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.historia:
                        Intent historia = new Intent(getApplicationContext(), historiaActivity.class);
                        historia.putExtra("usuario", (Serializable) usuario);
                        startActivity(historia);
                        break;
                    case R.id.saludo:
                        Intent saludo = new Intent(getApplicationContext(), saludoActivity.class);
                        saludo.putExtra("usuario", (Serializable) usuario);
                        startActivity(saludo);
                        break;
                    case R.id.ponercinturon:
                        Intent ponercinturon = new Intent(getApplicationContext(), ponercinturonActivity.class);
                        ponercinturon.putExtra("usuario", (Serializable) usuario);
                        startActivity(ponercinturon);
                        break;
                    case R.id.nivelescinturon:
                        Intent nivelescinturon = new Intent(getApplicationContext(),nivelescinturonActivity.class);
                        nivelescinturon.putExtra("usuario", (Serializable) usuario);
                        startActivity(nivelescinturon);
                        break;
                    case R.id.amarillo:
                        Intent amarillo = new Intent(getApplicationContext(),amarilloActivity.class);
                        amarillo.putExtra("usuario", (Serializable) usuario);
                        startActivity(amarillo);
                        break;
                    case R.id.naranja:
                        Intent naranja = new Intent(getApplicationContext(),naranjaActivity.class);
                        naranja.putExtra("usuario", (Serializable) usuario);
                        startActivity(naranja);
                        break;
                    case R.id.verde:
                        Intent verde = new Intent(getApplicationContext(),verdeActivity.class);
                        verde.putExtra("usuario", (Serializable) usuario);
                        startActivity(verde);
                        break;
                    case R.id.azul:
                        Intent azul = new Intent(getApplicationContext(),azulActivity.class);
                        azul.putExtra("usuario", (Serializable) usuario);
                        startActivity(azul);
                        break;
                    case R.id.marron:
                        Intent marron = new Intent(getApplicationContext(),marronActivity.class);
                        marron.putExtra("usuario", (Serializable) usuario);
                        startActivity(marron);
                        break;
                    case R.id.negro:
                        Intent negro = new Intent(getApplicationContext(),negroActivity.class);
                        negro.putExtra("usuario", (Serializable) usuario);
                        startActivity(negro);
                        break;
                    case R.id.terminologia:
                        Intent terminologia = new Intent(getApplicationContext(),terminologiaActivity.class);
                        terminologia.putExtra("usuario", (Serializable) usuario);
                        startActivity(terminologia);
                        break;
                    case R.id.partescuerpo:
                        Intent partescuerpo = new Intent(getApplicationContext(),partescuerpoActivity.class);
                        partescuerpo.putExtra("usuario", (Serializable) usuario);
                        startActivity(partescuerpo);
                        break;
                    case R.id.salir:
                        finish();
                        System.exit(0);
                        break;
                }
                return true;
            }
        });
    }

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
    }
}
