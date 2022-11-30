package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.example.afinal.Dao.MovimientoDao;
import com.example.afinal.database.DataBaseApp;
import com.example.afinal.entities.Movimiento;
import com.google.gson.Gson;

import java.util.List;

public class RegistrarMovimientosActivity extends AppCompatActivity {

    EditText etMonto,etMotivo,etLatitud,etLongitud,etUrlImagen;
    Button btnRegistro,btnFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_movimientos);

        Spinner spntipos = findViewById(R.id.spnTypes);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.tipos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spntipos.setAdapter(adapter);

        Movimiento movimiento = new Movimiento();
        DataBaseApp data = DataBaseApp.getInstance(this);

        etMonto = findViewById(R.id.etMonto);
        etMotivo = findViewById(R.id.etMotivo);
        etLatitud = findViewById(R.id.etLatitud);
        etLongitud = findViewById(R.id.etLongitud);
        etUrlImagen = findViewById(R.id.etUrlImagen);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnFotos = findViewById(R.id.btnFotos);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movimiento.monto = Integer.parseInt(etMonto.getText().toString());
                movimiento.motivo = etMotivo.getText().toString();
                movimiento.longitud= etLongitud.getText().toString();
                movimiento.latitud = etLatitud.getText().toString();
                movimiento.tipo = spntipos.getSelectedItem().toString();

                data.movimientoDao().almacenar(movimiento);
                List<Movimiento> movimiento = data.movimientoDao().listaMov();
                Log.i("MAIN_APP", new Gson().toJson(movimiento));
            }
        });
    }
}