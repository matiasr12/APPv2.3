package com.example.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Modelo.productos;
import com.example.app.R;

import java.util.List;

public class adapterproductos extends RecyclerView.Adapter<adapterproductos.viewholderproductos> {

    List<productos>  productosList;

    public adapterproductos(List<productos> productosList) {
        this.productosList = productosList;
    }

    @NonNull
    @Override
    public viewholderproductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,parent,false);
        viewholderproductos holder = new viewholderproductos(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderproductos holder, int position) {
        productos ms = productosList.get(position);
        holder.tv_direccion.setText(ms.getDireccionDelLocal());
        holder.tv_kog.setText(ms.getKiloOgramos());
        holder.tv_nombre.setText(ms.getNombreProductos());
        holder.tv_nombret.setText(ms.getNombreTienda());
        holder.tv_percio.setText(ms.getPercio());

    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class viewholderproductos extends RecyclerView.ViewHolder {

        TextView tv_direccion,tv_kog,tv_nombre,tv_nombret,tv_percio;
        public viewholderproductos(@NonNull View itemView) {
            super(itemView);

            tv_direccion = itemView.findViewById(R.id.tv_direccion);
            tv_kog = itemView.findViewById(R.id.tv_kog);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_nombret = itemView.findViewById(R.id.tv_nombret);
            tv_percio = itemView.findViewById(R.id.tv_percio);
        }
    }
}
