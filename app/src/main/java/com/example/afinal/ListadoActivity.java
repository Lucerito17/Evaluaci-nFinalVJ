package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.afinal.adapters.CuentaAdapter;
import com.example.afinal.database.DataBaseApp;
import com.example.afinal.entities.Cuenta;
import com.example.afinal.services.CuentaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoActivity extends AppCompatActivity {

    RecyclerView rvListado;
    List<Cuenta> cuentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        DataBaseApp data = DataBaseApp.getInstance(this);

        rvListado = findViewById(R.id.rvListado);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        CuentaService service = retrofit.create(CuentaService.class);
        List <Cuenta> list = data.cuentaDao().listarCuentas();
        Call<List<Cuenta>> call = service.listarCuentas();


        call.enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                cuentas = response.body();
                CuentaAdapter adapter = new CuentaAdapter(cuentas);
                rvListado.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvListado.setHasFixedSize(true);
                rvListado.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });

    }
}