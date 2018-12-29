package com.example.jessi.tae;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class galeriaActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private int galeria;
    private Button boton1;
    private FrameLayout frame;

    View view;
    TextView titulo;
    RecyclerView recyclerViewGaleria;
    ImageView imagen;
    ImageView salir;
    ArrayList<com.example.jessi.tae.Menu> listaMenu;
    RecyclerAdapter adapter;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        galeria = (int)bundle.getSerializable("galeria");
        EstablecerIdioma(usuario.getIdioma());
        setContentView(R.layout.activity_galeria);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.galeriaImagenes);

        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navAmarillo);
        View headerView = navigationView.getHeaderView(0);
        TextView _email = (TextView) headerView.findViewById(R.id.txtemail);
        _email.setText(usuario.getEmail());

        LayoutInflater inflater = (LayoutInflater) this.getLayoutInflater();

        frame = (FrameLayout) findViewById(R.id.frame);

        view = inflater.inflate(R.layout.fragment_galeria, null, false);
        salir = (ImageView)view.findViewById(R.id.salir);
        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagen);
        recyclerViewGaleria = (RecyclerView) view.findViewById(R.id.galeria);
        recyclerViewGaleria.setLayoutManager(new LinearLayoutManager(frame.getContext(), LinearLayoutManager.HORIZONTAL, false));
        listaMenu = new com.example.jessi.tae.Menu().listaMenu(galeria);
        adapter = new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnClickRecycler() {
            @Override
            public void OnclickItemRecycler(com.example.jessi.tae.Menu menu) {
                Glide.with(frame.getContext()).load(menu.getIdImagen()).into(imagen);
                ViewTreeObserver vto = frame.getViewTreeObserver();
                vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                            frame.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        } else {
                            frame.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        }
                        int width  = frame.getMeasuredWidth();
                        int height = imagen.getMeasuredWidth();
                        int ratio = width/height;
                        int heightFinal = height * ratio;

                        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, heightFinal);
                        imagen.setLayoutParams(layoutParams);
                    }
                });

                titulo.setText(menu.getTitulo());
            }
        });

        recyclerViewGaleria.setAdapter(adapter);

        frame.removeAllViews();
        frame.addView(view);
    }

    private void EstablecerIdioma(int idioma) {
        switch (idioma) {
            case 1:
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                break;
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
                Locale actual = getResources().getConfiguration().locale;
                Locale.setDefault(actual);
                Configuration configActual = new Configuration();
                configActual.locale = actual;
                getBaseContext().getResources().updateConfiguration(configActual, getBaseContext().getResources().getDisplayMetrics());
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

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
        Intent amarillo = new Intent(getApplicationContext(),amarilloActivity.class);
        amarillo.putExtra("usuario", (Serializable) usuario);
        startActivity(amarillo);
    }
}
