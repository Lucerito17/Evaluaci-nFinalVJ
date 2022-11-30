package com.example.afinal.services;

import com.example.afinal.entities.Cuenta;
import com.example.afinal.entities.Movimiento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MovimientoService {
     @POST("Movimiento")
     Call<Void> crear(@Body Movimiento movimiento);

     @GET("Cuenta")
     Call<List<Movimiento>> listarmov();
}
