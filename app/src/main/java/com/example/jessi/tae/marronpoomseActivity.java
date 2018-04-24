package com.example.jessi.tae;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.Serializable;

public class marronpoomseActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private VideoView mVideoView;
    private String youtubeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        setContentView(R.layout.activity_marronpoomse);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.marronpoomse);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navmarron);
        View headerView = navigationView.getHeaderView(0);
        TextView _email = (TextView) headerView.findViewById(R.id.txtemail);
        InsertarVideo();
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

    private void InsertarVideo() {
        mVideoView =(VideoView)findViewById(R.id.videoView4);
        MediaController mc = new MediaController(this);
        mVideoView.setMediaController(mc);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pumse7);
        mVideoView.setVideoURI(uri);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
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

    public void Volver(View view) {
        Intent marron = new Intent(getApplicationContext(),marronActivity.class);
        marron.putExtra("usuario", (Serializable) usuario);
        startActivity(marron);
    }
}