package com.example.afinal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.afinal.Dao.CuentaDao;
import com.example.afinal.Dao.MovimientoDao;
import com.example.afinal.entities.Cuenta;
import com.example.afinal.entities.Movimiento;
import com.example.afinal.services.CuentaService;

@Database(entities = {Cuenta.class, Movimiento.class}, version = 2)
public abstract class DataBaseApp extends RoomDatabase {
    public abstract CuentaDao cuentaDao();
    public abstract MovimientoDao movimientoDao();

    public static DataBaseApp getInstance(Context context){
        return Room.databaseBuilder(context, DataBaseApp.class,"com.example.afinal.database_DB")
                .allowMainThreadQueries().build();
    }
}
