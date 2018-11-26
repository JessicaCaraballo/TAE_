package com.example.jessi.tae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;

public class azulActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_azul);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.azul);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navazul);
        View headerView = navigationView.getHeaderView(0);
        mImageButtonPosiciones = (ImageButton) findViewById(R.id.imageButtonPosicion);
        mImageButtonPosiciones.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulPosiciones = new Intent(getApplicationContext(), azulposicionesActivity.class);
                azulPosiciones.putExtra("usuario", (Serializable) usuario);
                startActivity(azulPosiciones);
            }
        });
        mImageButtonAtaques = (ImageButton) findViewById(R.id.imageButtonAtaque);
        mImageButtonAtaques.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulAtaques = new Intent(getApplicationContext(), azulataquesActivity.class);
                azulAtaques.putExtra("usuario", (Serializable) usuario);
                startActivity(azulAtaques);
            }
        });
        mImageButtonDefensas = (ImageButton) findViewById(R.id.imageButtonDefensa);
        mImageButtonDefensas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulDefensas = new Intent(getApplicationContext(), azuldefensasActivity.class);
                azulDefensas.putExtra("usuario", (Serializable) usuario);
                startActivity(azulDefensas);
            }
        });
        mImageButtonPatadas = (ImageButton) findViewById(R.id.imageButtonPatada);
        mImageButtonPatadas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulPatadas = new Intent(getApplicationContext(), azulpatadasActivity.class);
                azulPatadas.putExtra("usuario", (Serializable) usuario);
                startActivity(azulPatadas);
            }
        });
        mImageButtonPum = (ImageButton) findViewById(R.id.imageButtonPum);
        mImageButtonPum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulPum = new Intent(getApplicationContext(), azulpumActivity.class);
                azulPum.putExtra("usuario", (Serializable) usuario);
                startActivity(azulPum);
            }
        });
        mImageButtonPoomse = (ImageButton) findViewById(R.id.imageButtonPumse);
        mImageButtonPoomse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent azulPoomse = new Intent(getApplicationContext(), azulpoomseActivity.class);
                azulPoomse.putExtra("usuario", (Serializable) usuario);
                startActivity(azulPoomse);
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
                    case R.id.sobrenosotros:
                        Intent sobrenosotros = new Intent(getApplicationContext(), sobrenosotrosActivity.class);
                        sobrenosotros.putExtra("usuario", (Serializable) usuario);
                        startActivity(sobrenosotros);
                        break;
                    case R.id.frases:
                        Intent frases = new Intent(getApplicationContext(), frasesActivity.class);
                        frases.putExtra("usuario", (Serializable) usuario);
                        startActivity(frases);
                        break;
                    case R.id.federaciones:
                        Intent federaciones = new Intent(getApplicationContext(), federacionesActivity.class);
                        federaciones.putExtra("usuario", (Serializable) usuario);
                        startActivity(federaciones);
                        break;
                    case R.id.reglamento:
                        Intent reglamento = new Intent(getApplicationContext(), reglamentoActivity.class);
                        reglamento.putExtra("usuario", (Serializable) usuario);
                        startActivity(reglamento);
                        break;
                    case R.id.salir:
                        finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
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
