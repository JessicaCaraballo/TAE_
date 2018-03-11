package com.example.jessi.tae;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public Usuario usu;
    ArrayList<Usuario> listaUsuarios;
    //private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");*/
    }

    public void login(View view) {
        ProgressBar pb =  findViewById(R.id.loadingProgress);
        pb.setVisibility(View.VISIBLE);
        //mProgress.show();

        try
        {
            Thread.sleep(5000);
            final String email = ((EditText) findViewById(R.id.editText)).getText().toString();
            final String password = ((EditText) findViewById(R.id.editText2)).getText().toString();

            Retrofit retrofit = new RetrofitAdapter().getAdapter();
            RetrofitService service = retrofit.create(RetrofitService.class);

            //Call<TimeFromWeb> call = service.loadTime();
            Call<Usuario> call = service.getLogin(email, password);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    //System.out.println(response.body().getEmail());
                    if(response != null) {
                        Usuario usuario = new Usuario(response.body().getId(), response.body().getEmail(), response.body().getPassword(), response.body().getActivo());
                        if (!usuario.getEmail().equalsIgnoreCase("") && !usuario.getPassword().equalsIgnoreCase("")) {
                            if (usuario.getEmail().equalsIgnoreCase(email) && usuario.getPassword().equalsIgnoreCase(password)) {
                                Intent principal = new Intent(getApplicationContext(), principalActivity.class);
                                principal.putExtra("usuario", (Serializable) usuario);
                                startActivity(principal);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    System.out.println(t.getCause().toString());
                }
            });
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
        pb.setVisibility(View.INVISIBLE);
        //mProgress.dismiss();
    }
    public void lanzarPrincipalActivity(View view) {
        Intent principal = new Intent(getApplicationContext(), principalActivity.class);
        Usuario usuario = new Usuario();
        usuario.setEmail("Invitado");
        principal.putExtra("usuario", (Serializable) usuario);
        startActivity(principal);
    }
}
