package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMostrar, btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = findViewById(R.id.btnMostrar);
        btnCrear = findViewById(R.id.btnCreate);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlist();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createcount();
            }
        });
    }

    void  formlist(){
        Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
        startActivity(intent);
    }

    void createcount(){
        Intent intent = new Intent(getApplicationContext(), FormularioActivity.class);
        startActivity(intent);
    }
}