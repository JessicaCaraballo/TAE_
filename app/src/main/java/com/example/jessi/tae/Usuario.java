package com.example.jessi.tae;

import java.io.Serializable;

/**
 * Created by Load on 22/02/2018.
 */


@SuppressWarnings("serial")
public class Usuario implements Serializable {
    private int id;
    private String email;
    private String password;
    private boolean activo;

    public Usuario(){
    }

    public Usuario(int id, String email, String password, boolean activo){
        this.id = id;
        this.email = email;
        this.password = password;
        this.activo = activo;
    }

    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public boolean getActivo() {
        return this.activo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setActivo(boolean activo) { this.activo = activo; }
}
