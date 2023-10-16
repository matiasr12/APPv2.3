package com.example.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Modelo.Productos;
import com.example.app.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ProductosAdapter extends FirestoreRecyclerAdapter<Productos,ProductosAdapter.ViewHolder>{
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProductosAdapter(@NonNull FirestoreRecyclerOptions<Productos> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Productos model) {
      holder.nombreProductos.setText(model.getNombreProductos());
      holder.precio.setText(model.getPercio());
      holder.kiloOgramos.setText(model.getKiloOgramos());


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,parent,false);
        return  new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreProductos, precio,kiloOgramos;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreProductos = itemView.findViewById(R.id.nombreProductos);
            precio = itemView.findViewById(R.id.precio);
            kiloOgramos = itemView.findViewById(R.id.kiloOgramos);

        }
    }
}
