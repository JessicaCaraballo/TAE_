package com.example.jessi.tae;

import java.util.Date;

/**
 * Created by Load on 24/02/2018.
 */

public class Respuesta {
    public int codigo;
    public String mensaje;
    public String funcion;
    public String fecha;

    public Respuesta(){
    }
    public Respuesta(int codigo, String mensaje, String funcion, String fecha){
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.funcion = funcion;
        this.fecha = fecha;
    }
    public void setCodigo(int codigo){this.codigo = codigo;}
    public void setMensaje(String mensaje){this.mensaje = mensaje;}
    public void setFuncion(String funcion){this.funcion = funcion;}
    public void setFecha(String fecha){this.fecha = fecha;}
    public int getCodigo(){return this.codigo;}
    public String getMensaje(){return this.mensaje;}
    public String getFuncion(){return this.funcion;}
    public String getFecha(){return this.fecha;}
}
