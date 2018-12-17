package com.example.jessi.tae;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.Locale;

public class mapaActivity extends FragmentActivity implements OnMapReadyCallback {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private MapView mapView;
    //private MapController myMapController;
    private String apikey = "AIzaSyAxNitpuAe1bf4fxCguvSZa_olw3KVeItc";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Log.i("e","e");
        //super.onCreate(savedInstanceState);
        final Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        EstablecerIdioma(usuario.getIdioma());
        //setContentView(R.layout.activity_mapa);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mapa);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        //getSupportFragmentManager().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navMapa);
        View headerView = navigationView.getHeaderView(0);
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
                    case R.id.mapa:
                        Intent mapa = new Intent(getApplicationContext(), mapaActivity.class);
                        mapa.putExtra("usuario", (Serializable) usuario);
                        startActivity(mapa);
                        break;
                    case R.id.ajustes:
                        Intent ajustes = new Intent(getApplicationContext(), ajustesActivity.class);
                        ajustes.putExtra("usuario", (Serializable) usuario);
                        startActivity(ajustes);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Zaragoza.
        LatLng zaragoza = new LatLng(41.648823, -0.889085);
        mMap.addMarker(new MarkerOptions().position(zaragoza).title("Marcador en Zaragoza"));
        //Gimnasios https://www.latlong.net/
        //Eh Kim-Il
        LatLng kimil = new LatLng(41.651200, -0.902610);
        mMap.addMarker(new MarkerOptions().position(kimil).title("Kimil"));
        //Seul
        LatLng seul = new LatLng(41.669880, -0.883430);
        mMap.addMarker(new MarkerOptions().position(seul).title("Seul"));
        //Wha Rang
        LatLng wharang = new LatLng(41.639650, -0.888610);
        mMap.addMarker(new MarkerOptions().position(wharang).title("Wha rang"));
        //Federación Aragonesa de Taekwondo
        LatLng fat = new LatLng(41.672530, 0.898260);
        mMap.addMarker(new MarkerOptions().position(fat).title("Fat"));
        //Gimnasio Kumgan
        LatLng kumgan = new LatLng(41.672180, -0.876950);
        mMap.addMarker(new MarkerOptions().position(kumgan).title("Kumgan"));
        //Taekwondo Garrapinillos
        LatLng garrapinilllos = new LatLng(41.689410, -1.041120);
        mMap.addMarker(new MarkerOptions().position(garrapinilllos).title("Garrapinilllos"));
        //Sad
        LatLng sad = new LatLng(41.640230, -0.897610);
        mMap.addMarker(new MarkerOptions().position(sad).title("Sad"));
        //Seul Santa Isabel
        LatLng seulisabel = new LatLng(41.666530, -0.831770);
        mMap.addMarker(new MarkerOptions().position(seulisabel).title("Seu santa Isabel"));

        //Zoom mapa
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(zaragoza,14));
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    private void EstablecerIdioma(int idioma) {
        switch (idioma) {
            case 2:
                Locale locale2 = new Locale("en");
                Locale.setDefault(locale2);
                Configuration config2 = new Configuration();
                config2.locale = locale2;
                getBaseContext().getResources().updateConfiguration(config2, getBaseContext().getResources().getDisplayMetrics());
                break;

            case 3:
                Locale locale3 = new Locale("fr");
                Locale.setDefault(locale3);
                Configuration config3 = new Configuration();
                config3.locale = locale3;
                getBaseContext().getResources().updateConfiguration(config3, getBaseContext().getResources().getDisplayMetrics());
                break;

            case 4:
                Locale locale4 = new Locale("it");
                Locale.setDefault(locale4);
                Configuration config4 = new Configuration();
                config4.locale = locale4;
                getBaseContext().getResources().updateConfiguration(config4, getBaseContext().getResources().getDisplayMetrics());
                break;

            case 5:
                Locale locale5 = new Locale("pt");
                Locale.setDefault(locale5);
                Configuration config5 = new Configuration();
                config5.locale = locale5;
                getBaseContext().getResources().updateConfiguration(config5, getBaseContext().getResources().getDisplayMetrics());
                break;

            default:
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                break;
        }
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