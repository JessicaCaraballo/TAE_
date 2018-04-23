package com.example.jessi.tae;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

public class registrarseActivity extends AppCompatActivity {
    public Usuario usu;
    private TextView mTextErrorLogin;
    private Button mButtonRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }

    public void registrarse(View view) {
        final String email = ((EditText) findViewById(R.id.editText)).getText().toString();
        final String password = ((EditText) findViewById(R.id.editText2)).getText().toString();
        mTextErrorLogin = (TextView) findViewById(R.id.textErrorLogin2);
        mButtonRegistrarse = (Button) findViewById(R.id.buttonRegistrarse2);
        if(email.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mTextErrorLogin.setText("Debe introducir el email y la contraeña");
        }else if(password.length()<6){
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mTextErrorLogin.setText("La contraeña debe tener al menos 6 caracteres");
        }else if(!email.contains("@")){
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mTextErrorLogin.setText("Debe introducir un email");
        }else{
            //TODO: dar de alta
            mTextErrorLogin.setVisibility(View.VISIBLE);
            mButtonRegistrarse.setVisibility(View.INVISIBLE);
            mTextErrorLogin.setText("Revise su email para confirmar su registro");

        }
    }
    public void lanzarPrincipalActivity(View view) {
        Intent principal = new Intent(getApplicationContext(), principalActivity.class);
        Usuario usuario = new Usuario();
        usuario.setEmail("Invitado");
        principal.putExtra("usuario", (Serializable) usuario);
        startActivity(principal);
    }
}
