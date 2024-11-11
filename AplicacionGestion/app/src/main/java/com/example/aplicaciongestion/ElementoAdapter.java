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
        holder.descriptionTextView.setText(elemento.getDescripcion()); // Ahora se usa descripcion
        holder.ratingBar.setRating(elemento.getPuntuacion());
        holder.fechaEntregaTextView.setText(elemento.getFechaEntrega()); // Aquí se usa fecha de entrega
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView descriptionTextView;  // Cambiado a descriptionTextView
        RatingBar ratingBar;
        TextView fechaEntregaTextView; // Cambiado de webTextView a fechaEntregaTextView

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.hola);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView); // Asegúrate de que el layout tenga este ID
            ratingBar = itemView.findViewById(R.id.ratingBar);
            fechaEntregaTextView = itemView.findViewById(R.id.fechaEntregaTextView); // Asegúrate de que el layout tenga este ID
        }
    }
}
