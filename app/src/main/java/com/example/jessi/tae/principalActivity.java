package com.example.jessi.tae;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class principalActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    //private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
        setContentView(R.layout.activity_principal);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.cerrar);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.historia:
                        //showOverflowMenu(true);
                        Intent historia = new Intent(getApplicationContext(), historiaActivity.class);
                        startActivity(historia);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //this.mMenu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, menu);
        return true;
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }*/
/*
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.drawer).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }
    */
/*
    public void showOverflowMenu(boolean showMenu){
        if(mMenu == null)
            return;
        mMenu.setGroupVisible(R.id.drawer, showMenu);
    }*/
    /*
    @Override
public boolean onCreateOptionsMenu(Menu menu)
{
    // inflate menu from xml
    MenuInflater inflater = getSupportMenuInflater();
    inflater.inflate(R.menu.settings, menu);

    if (mState == HIDE_MENU)
    {
        for (int i = 0; i < menu.size(); i++)
            menu.getItem(i).setVisible(false);
    }
}
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

