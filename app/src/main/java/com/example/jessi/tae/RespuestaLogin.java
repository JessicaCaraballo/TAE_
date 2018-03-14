package com.example.jessi.tae;

import java.util.Date;

/**
 * Created by Load on 14/03/2018.
 */

public class RespuestaLogin {
    public Respuesta respuesta = new Respuesta();
    public Usuario usuario = new Usuario();

    public RespuestaLogin  (){
    }
/*
    public RespuestaLogin  (int codigo, String mensaje, String funcion, Date fecha){
        respuesta.codigo = codigo;
        respuesta.mensaje = mensaje;
        respuesta.funcion = funcion;
        respuesta.fecha = fecha;
    }
*/
    public RespuestaLogin  (int codigo, String mensaje, String funcion, String fecha, Usuario usuario){
        this.respuesta = new Respuesta(codigo, mensaje, funcion, fecha);
        this.usuario = usuario;
    }
    public void setRespuesta(Respuesta respuesta){this.respuesta = respuesta;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
    public Respuesta getRespuesta(){return this.respuesta;}
    public Usuario getUsuario(){return this.usuario;}
}
