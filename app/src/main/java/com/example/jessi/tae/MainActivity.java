package com.example.jessi.tae;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    public TextView mTextErrorLogin;
    private ProgressBar mProgress;
    //private ProgressDialog mProgress;
    private int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        /*mProgress =new ProgressDialog(this);
        String titleId="Signing in...";
        mProgress.setTitle(titleId);
        mProgress.setMessage("Please Wait...");*/
    }


    public void login(View view) {
        //ProgressBar pb =  findViewById(R.id.loadingProgress);
        //pb.setVisibility(View.VISIBLE);
        mProgress.setVisibility(View.VISIBLE);
        mTextErrorLogin =  (TextView) findViewById(R.id.textErrorLogin);
        //mProgressBar.setVisibility(View.VISIBLE);
        //mProgressBar.setProgress(0);

        try {
            //Thread.sleep(5000);
            final String email = ((EditText) findViewById(R.id.editText)).getText().toString();
            final String password = ((EditText) findViewById(R.id.editText2)).getText().toString();
            if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                mTextErrorLogin.setText("Debe rellenar el usuario y el password");
                mTextErrorLogin.setVisibility(View.VISIBLE);
            }else{
                Retrofit retrofit = new RetrofitAdapter().getAdapter();
                RetrofitService service = retrofit.create(RetrofitService.class);


                //Call<TimeFromWeb> call = service.loadTime();
                Call<RespuestaLogin> call = service.getLogin(email, password);
                call.enqueue(new Callback<RespuestaLogin>() {
                    @Override
                    public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                        RespuestaLogin respuestaLogin = new RespuestaLogin();
                        respuestaLogin.setRespuesta(new Respuesta(response.body().respuesta.codigo, response.body().respuesta.mensaje, response.body().respuesta.funcion, response.body().respuesta.fecha));
                        switch (respuestaLogin.respuesta.codigo) {
                            case 1:
                                mProgress.setVisibility(View.GONE);
                                respuestaLogin.usuario.setId(response.body().usuario.getId());
                                respuestaLogin.usuario.setEmail(response.body().usuario.getEmail());
                                respuestaLogin.usuario.setPassword(response.body().usuario.getPassword());
                                respuestaLogin.usuario.setActivo(response.body().usuario.getActivo());

                                if (respuestaLogin.usuario.getActivo() == 1) {
                                    Intent principal = new Intent(getApplicationContext(), principalActivity.class);
                                    principal.putExtra("usuario", (Serializable) respuestaLogin.usuario);
                                    startActivity(principal);
                                } else {
                                    mTextErrorLogin.setText("El usuario no está activo");
                                    mTextErrorLogin.setVisibility(View.VISIBLE);
                                }
                                break;
                            case 2:
                                mTextErrorLogin.setText("Usuario no encontrado");
                                mTextErrorLogin.setVisibility(View.VISIBLE);
                                break;
                            default:
                                mTextErrorLogin.setText("Hubo un error al procesar la petición");
                                mTextErrorLogin.setVisibility(View.VISIBLE);
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                        // Hubo un error
                    }
                });
            }
        }catch(Exception ex) {
            mProgress.setVisibility(View.GONE);
        }
        mProgress.setVisibility(View.GONE);
        //pb.setVisibility(View.INVISIBLE);
        //mProgress.dismiss();
    }
    /*
    class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (; contador <= params[0]; contador++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(contador);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Tarea completa!. =)";
        }
        @Override
        protected void onPostExecute(String result) {
            mProgressBar.setVisibility(View.GONE);
        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);
        }
    }
    */
    public void lanzarPrincipalActivity(View view) {
        Intent principal = new Intent(getApplicationContext(), principalActivity.class);
        Usuario usuario = new Usuario();
        usuario.setEmail("Invitado");
        principal.putExtra("usuario", (Serializable) usuario);
        startActivity(principal);
    }
    public void registrarse(View view) {
        Intent registrarse = new Intent(getApplicationContext(), registrarseActivity.class);
        Usuario usuario = new Usuario();
        usuario.setEmail("Invitado");
        registrarse.putExtra("usuario", (Serializable) usuario);
        startActivity(registrarse);
    }
}
