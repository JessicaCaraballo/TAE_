package com.example.jessi.tae;

import java.io.Serializable;

/**
 * Created by Load on 22/02/2018.
 * Prueba prueba
 */


@SuppressWarnings("serial")
public class Usuario implements Serializable {
    private int id;
    private String email;
    private String password;
    private byte activo;
    private int idioma;
    private String imagen;

    public Usuario(){
    }

    public Usuario(int id, String email, String password, byte activo, int idioma, String imagen){
        this.id = id;
        this.email = email;
        this.password = password;
        this.activo = activo;
        this.idioma = idioma;
        this.imagen = imagen;
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
    public byte getActivo() {
        return this.activo;
    }
    public int getIdioma() {
        return this.idioma;
    }
    public String getImagen() { return this.imagen; }

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setActivo(byte activo) { this.activo = activo; }
    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
