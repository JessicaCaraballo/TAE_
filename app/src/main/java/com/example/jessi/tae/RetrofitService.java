package com.example.jessi.tae;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Load on 26/02/2018.
 */

public interface RetrofitService {
    @GET("api/json/west/now")
    Call<TimeFromWeb> loadTime();
    @GET("usuarios/id/1/")
    Call<Usuario> getLogin2();
    @GET("usuarios/login/{email}/{pass}/")
    Call<RespuestaLogin> getLogin(@Path("email") String email, @Path("pass") String pass);
}