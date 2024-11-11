package com.example.aplicaciongestion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ElementoViewHolder> {

    private List<Elemento> elementos;

    public ElementoAdapter(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_elemento, parent, false);
        return new ElementoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {
        Elemento elemento = elementos.get(position);
        holder.imageView.setImageResource(elemento.getImagenResId());
        holder.titleTextView.setText(elemento.getTitulo());
        holder.contentTextView.setText(elemento.getContenido());
        holder.ratingBar.setRating(elemento.getPuntuacion());
        holder.webTextView.setText(elemento.getWeb());
        holder.phoneTextView.setText(elemento.getTelefono());
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView contentTextView;
        RatingBar ratingBar;
        TextView webTextView;
        TextView phoneTextView;

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.hola);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            webTextView = itemView.findViewById(R.id.webTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
        }
    }
}
