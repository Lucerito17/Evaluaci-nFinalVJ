package com.example.afinal.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movimiento")
public class Movimiento {
    @PrimaryKey(autoGenerate = true)
    public int idMov;
    public String tipo;
    public int monto;
    public String motivo;
    public String imagen;
    public String latitud;
    public String longitud;
}
