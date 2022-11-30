package com.example.afinal.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.ListadoActivity;
import com.example.afinal.MostrarMovimientoActivity;
import com.example.afinal.R;
import com.example.afinal.RegistrarMovimientosActivity;
import com.example.afinal.entities.Cuenta;

import java.util.List;

public class CuentaAdapter extends RecyclerView.Adapter {

    List<Cuenta> datos;
    Button btnMovimientos,btnver;

    public CuentaAdapter (List<Cuenta> cuentaList){
        this.datos = cuentaList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cuenta_item, parent, false);
        return new CuentaApiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView txtName = holder.itemView.findViewById(R.id.txtName);
        txtName.setText(datos.get(position).nombre);
        btnMovimientos = holder.itemView.findViewById(R.id.btnMovimientos);

        btnMovimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), RegistrarMovimientosActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        btnver = holder.itemView.findViewById((R.id.btnVerMov));
        btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MostrarMovimientoActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class CuentaApiViewHolder extends RecyclerView.ViewHolder{
        public CuentaApiViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
