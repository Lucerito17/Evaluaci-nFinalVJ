package com.example.afinal.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;
import com.example.afinal.RegistrarMovimientosActivity;
import com.example.afinal.entities.Cuenta;
import com.example.afinal.entities.Movimiento;

import java.util.List;

public class MovimientoAdapter extends RecyclerView.Adapter{
    List<Movimiento> datos;
    Button btnMovimientos;

    public MovimientoAdapter (List<Movimiento> cuentaList){
        this.datos = cuentaList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cuenta_item, parent, false);
        return new CuentaAdapter.CuentaApiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView txtMonto = holder.itemView.findViewById(R.id.txtMonto);
        txtMonto.setText(datos.get(position).monto);
        TextView txtMotivo = holder.itemView.findViewById(R.id.txtMotivo);
        txtMonto.setText(datos.get(position).motivo);
        TextView txtTipo = holder.itemView.findViewById(R.id.txtTipo);
        txtMonto.setText(datos.get(position).tipo);
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
