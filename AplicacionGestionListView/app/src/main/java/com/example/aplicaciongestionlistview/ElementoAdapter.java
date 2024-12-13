package com.example.aplicaciongestionlistview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.aplicaciongestionlistview.Elemento;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ElementoAdapter extends BaseAdapter {

    private Context context;
    private List<Elemento> elementos;

    // Constructor
    public ElementoAdapter(Context context, List<Elemento> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Si la vista es nula, inflamos la vista de cada ítem
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_elemento, parent, false);
        }

        // Obtener el elemento actual
        Elemento elemento = (Elemento) getItem(position);

        // Configurar las vistas
        ImageView imagen = convertView.findViewById(R.id.imagen);
        TextView titulo = convertView.findViewById(R.id.titulo);
        TextView descripcion = convertView.findViewById(R.id.descripcion);
        TextView fecha = convertView.findViewById(R.id.fecha);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);

        // Establecer los valores

        Picasso.get().load(elemento.getUriImagen()).into(imagen);
        titulo.setText(elemento.getTitulo());
        descripcion.setText(elemento.getDescripcion());
        fecha.setText(elemento.getFechaEntrega());
        ratingBar.setRating(elemento.getPuntuacion());

        return convertView;
    }
}
