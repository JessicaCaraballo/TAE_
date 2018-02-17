package com.example.jessi.tae;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        String email = ((EditText)findViewById(R.id.editText)).getText().toString();
        String password = ((EditText)findViewById(R.id.editText2)).getText().toString();
        if(email.equals("d@d.com") && password.equals("d")){
            Intent principal = new Intent(getApplicationContext(), principalActivity.class);
            principal.putExtra("email", email.toString());
            startActivity(principal);
            TextView textErrorLogin = (TextView)findViewById(R.id.textErrorLogin);
            textErrorLogin.setVisibility(View.INVISIBLE);
        }else{
            TextView textErrorLogin = (TextView)findViewById(R.id.textErrorLogin);
            textErrorLogin.setVisibility(View.VISIBLE);
            textErrorLogin.setTextColor(Color.RED);
        }
    }

    public void lanzarPrincipalActivity(View view)
    {
        Intent principal = new Intent(getApplicationContext(), principalActivity.class);
        principal.putExtra("email", "Invitado");
        startActivity(principal);
    }
    /*
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        /*
        if (id == R.id.action_rutina) {
            //Log.i("ActionBar", "1!"+id+"!"+R.id.action_settings);
            Intent rutina = new Intent(getApplicationContext(), rutinaActivity.class);
            startActivity(rutina);
            return true;
        }
        */
/*
        if (id == R.id.action_settings) {
        //Log.i("ActionBar", "1!"+id+"!"+R.id.action_settings);
        Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(settings);
        return true;
    }

        return super.onOptionsItemSelected(item);
}
     */
}
