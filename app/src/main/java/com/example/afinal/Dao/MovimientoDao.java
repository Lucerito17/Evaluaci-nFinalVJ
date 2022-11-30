package com.example.afinal.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.afinal.entities.Movimiento;

import java.util.List;

@Dao
public interface MovimientoDao {
    @Insert
    void almacenar(Movimiento m);

    @Query("SELECT * FROM movimiento")
    List<Movimiento> listaMov();
}
