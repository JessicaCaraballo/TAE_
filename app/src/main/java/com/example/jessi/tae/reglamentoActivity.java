package com.example.jessi.tae;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.internal.Util;

public class reglamentoActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    private Usuario usuario;
    private Button mBotonDescarga;
    private String downloadUrl = "http://www.pdf995.com/samples/pdf.pdf";
    private static final String TAG = reglamentoActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "reglamento2017.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    ProgressDialog mProgressDialog;
    TextView tv_loading;

    private Button btnDownload;
    String URL = "https://www.fetaekwondo.net/images/2017/03/Reglamento2017.pdf";
    String URL2 = "https://www.fetaekwondo.net/images/2017/03/Reglamento2017.pdf";
    //String URL = "http://www.pdf995.com/samples/pdf.pdf";
    //String URL = "http://mueblesdecocinaenzaragoza.es/reglamento.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("e","e");
        super.onCreate(savedInstanceState);
        final Bundle bundle = getIntent().getExtras();
        usuario = (Usuario)bundle.getSerializable("usuario");
        EstablecerIdioma(usuario.getIdioma());
        setContentView(R.layout.activity_reglamento);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.reglamento);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navReglamento);
        View headerView = navigationView.getHeaderView(0);

        btnDownload = (Button) findViewById(R.id.button1);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadTask(reglamentoActivity.this, URL);
                NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(reglamentoActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Documento descargado")
                                .setContentText("Se ha descargado el Reglamento 2017");
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // mId allows you to update the notification later on.
                int mId = 1001;
                mNotificationManager.notify(mId, mBuilder.build());
                        /*
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder (reglamentoActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Documento descargado")
                        .setContentText("Se ha descargado el Reglamento 2017")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        */
                /*
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                String url = "content://media/internal/TAE/Reglamento2017.pdf"; //Environment.getExternalStorageDirectory() + "content://media/internal/TAE/Reglamento2017.pdf";
                File file = new File(url); //new File("YOUR_SONG_URI"); // set your audio path
                intent.setDataAndType(Uri.fromFile(file), "pdf/*");

                PendingIntent pIntent = PendingIntent.getActivity(reglamentoActivity.this, 0, intent, 0);

                Notification noti = new Notification.Builder(reglamentoActivity.this) //NotificationCompat.Builder(this)
                        .setContentTitle("Descarga completada")
                        .setContentText("Reglamento 2017")
                        .setSmallIcon(R.drawable.ic_launcher);
                        //.setContentIntent(pIntent).build();

                //noti.flags |= Notification.FLAG_AUTO_CANCEL;

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, noti);
                */
            }
        });

/*
        String extStorageDirectory = Environment.getExternalStorageDirectory()
                .toString();
        File folder = new File(extStorageDirectory, "pdf");
        folder.mkdir();
        File file = new File(folder, "Reglamento.pdf");
        try {
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Downloader.DownloadFile("https://www.fetaekwondo.net/images/2017/03/Reglamento2017.pdf", file);
*/
        //showPdf();
/*
        pdfView= (PDFView)findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);
*/
/*
        mProgressDialog = new ProgressDialog(reglamentoActivity.this);
        mProgressDialog.setMessage("Descargando");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);*/


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


/*
    private void descargar(){
        DownloadTask dt = new DownloadTask(;
        context,target File,dialog message)
    }*/


/*
    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                //.onPageChange(this)
                .enableAnnotationRendering(true)
                //.onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }*/

/*
    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }*/
/*
    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }


    public void showPdf(){
        File file = new File(Environment.getExternalStorageDirectory()+"/pdf/temp.pdf");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/pdf");
        startActivity(intent);
    }*/

    /*public void showPdf()
    {
        File file2 = new File(Environment.getExternalStorageDirectory()+"/pdf/Reglamento.pdf");
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(file2);
        intent.setDataAndType(uri, "application/pdf");
        startActivity(intent);
    }*/

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
