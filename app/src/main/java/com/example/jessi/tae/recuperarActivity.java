package com.example.jessi.tae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class recuperarActivity extends AppCompatActivity {
    public Usuario usu;
    private TextView mTextErrorLogin;
    private Button mButtonRegistrarse;
    private TextView mEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
    }

    public void recuperar(View view) {
        mEmail = ((EditText) findViewById(R.id.editText));
        final String email = mEmail.getText().toString();
        mTextErrorLogin = (TextView) findViewById(R.id.textErrorLogin2);
        mButtonRegistrarse = (Button) findViewById(R.id.buttonRegistrarse2);
        if(email.equalsIgnoreCase("")){
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mTextErrorLogin.setText("Debe introducir el email");
        }else if(!email.contains("@")){
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mTextErrorLogin.setText("Debe introducir un email");
        }else{
            try {
                Retrofit retrofit = new RetrofitAdapter().getAdapter();
                RetrofitService service = retrofit.create(RetrofitService.class);

                Call<RespuestaLogin> call = service.recuperarUsuario(email);
                call.enqueue(new Callback<RespuestaLogin>() {
                    @Override
                    public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                        RespuestaLogin respuestaLogin = new RespuestaLogin();
                        respuestaLogin.setRespuesta(new Respuesta(response.body().respuesta.codigo, response.body().respuesta.mensaje, response.body().respuesta.funcion, response.body().respuesta.fecha));
                        switch (respuestaLogin.respuesta.codigo) {
                            case 1:
                                respuestaLogin.usuario.setId(response.body().usuario.getId());
                                respuestaLogin.usuario.setEmail(response.body().usuario.getEmail());
                                respuestaLogin.usuario.setPassword(response.body().usuario.getPassword());
                                respuestaLogin.usuario.setActivo(response.body().usuario.getActivo());

                                mEmail.setText("");
                                mTextErrorLogin.setVisibility(View.VISIBLE);
                                mButtonRegistrarse.setVisibility(View.INVISIBLE);
                                mTextErrorLogin.setText("Revise su email para cambiar su contraseña");
                                break;
                            case 2:
                                mTextErrorLogin.setVisibility(View.VISIBLE);
                                mButtonRegistrarse.setVisibility(View.VISIBLE);
                                mTextErrorLogin.setText("El email no existe");
                                break;
                            default:
                                mTextErrorLogin.setVisibility(View.VISIBLE);
                                mButtonRegistrarse.setVisibility(View.INVISIBLE);
                                mTextErrorLogin.setText("Hubo un error al procesar su solicitud");
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                        mTextErrorLogin.setVisibility(View.VISIBLE);
                        mButtonRegistrarse.setVisibility(View.INVISIBLE);
                        mTextErrorLogin.setText("Hubo un error al procesar su solicitud");
                    }
                });
            }catch(Exception ex) {
                mTextErrorLogin.setVisibility(View.VISIBLE);
                mButtonRegistrarse.setVisibility(View.INVISIBLE);
                mTextErrorLogin.setText("Hubo un error al procesar su solicitud");
            }


        }
    }



    public void lanzarPrincipalActivity(View view) {
        Intent principal = new Intent(getApplicationContext(), principalActivity.class);
        Usuario usuario = new Usuario();
        usuario.setEmail("Invitado");
        principal.putExtra("usuario", (Serializable) usuario);
        startActivity(principal);
    }
    public void volver(View view) {
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }
}
