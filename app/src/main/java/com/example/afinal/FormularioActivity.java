package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.afinal.database.DataBaseApp;
import com.example.afinal.entities.Cuenta;
import com.example.afinal.services.CuentaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormularioActivity extends AppCompatActivity {
    EditText etNombre;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = findViewById(R.id.etNombre);
        btnRegistrar = findViewById(R.id.btnCrear);

        Cuenta cuenta = new Cuenta();
        DataBaseApp data = DataBaseApp.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuenta.nombre =etNombre.getText().toString();
                data.cuentaDao().crearCuenta(cuenta);
                CuentaService service = retrofit.create(CuentaService.class);
                service.crear(cuenta).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }
}