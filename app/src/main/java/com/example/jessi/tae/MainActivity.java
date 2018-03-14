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
import java.util.Date;

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
            //Thread.sleep(5000);
            final String email = ((EditText) findViewById(R.id.editText)).getText().toString();
            final String password = ((EditText) findViewById(R.id.editText2)).getText().toString();

            Retrofit retrofit = new RetrofitAdapter().getAdapter();
            RetrofitService service = retrofit.create(RetrofitService.class);

            //Call<TimeFromWeb> call = service.loadTime();
            Call<RespuestaLogin> call = service.getLogin(email, password);
            call.enqueue(new Callback<RespuestaLogin>() {
                @Override
                public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                    RespuestaLogin respuestaLogin = new RespuestaLogin();
                    respuestaLogin.setRespuesta(new Respuesta(response.body().respuesta.codigo, response.body().respuesta.mensaje, response.body().respuesta.funcion, response.body().respuesta.fecha));
                    switch (respuestaLogin.respuesta.codigo){
                        case 1:
                            respuestaLogin.usuario.setId(response.body().usuario.getId());
                            respuestaLogin.usuario.setEmail(response.body().usuario.getEmail());
                            respuestaLogin.usuario.setPassword(response.body().usuario.getPassword());
                            respuestaLogin.usuario.setActivo(response.body().usuario.getActivo());

                            if(respuestaLogin.usuario.getActivo() == 1) {
                                Intent principal = new Intent(getApplicationContext(), principalActivity.class);
                                principal.putExtra("usuario", (Serializable) respuestaLogin.usuario);
                                startActivity(principal);
                            }else{
                                // no activo
                            }
                        break;
                        default:
                            // no existe
                        break;
                    }
                }

                @Override
                public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                    // Hubo un error
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
