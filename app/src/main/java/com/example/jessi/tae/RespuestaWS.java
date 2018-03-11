package com.example.jessi.tae;

import java.util.Date;

/**
 * Created by Load on 24/02/2018.
 */

public class RespuestaWS {
    public static class RespuestaLogin {
        public String funcion;
        public Date fecha;
        public int error;
        public String mensajeError;
        public int id;
        public String email;
        public String password;


        public RespuestaLogin  (){
        }

        public RespuestaLogin  (String funcion, Date fecha, int error, String mensajeError, int id, String email, String password){
            this.funcion = funcion;
            this.fecha = fecha;
            this.error = error;
            this.mensajeError = mensajeError;
            this.id = id;
            this.email = email;
            this.password = password;
        }
    }
}
