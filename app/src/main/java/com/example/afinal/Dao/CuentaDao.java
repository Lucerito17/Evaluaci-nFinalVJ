package com.example.afinal.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.afinal.entities.Cuenta;

import java.util.List;

import retrofit2.Call;

@Dao
public interface CuentaDao {
    @Insert
    void crearCuenta(Cuenta cuenta);

    @Query("SELECT * FROM cuentas")
    List<Cuenta> listarCuentas();
}
