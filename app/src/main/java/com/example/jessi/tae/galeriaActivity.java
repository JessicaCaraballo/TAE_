package com.example.jessi.tae;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class galeriaActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {

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
            return false;
        }
    }
