package com.example.guillermobarcenalopez_prueba3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.guillermobarcenalopez_prueba3.Elemento;

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
    public void remove(int i){
        elementos.remove(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Si la vista es nula, inflamos la vista de cada ítem
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.entrada, parent, false);
        }

        // Obtener el elemento actual
        Elemento elemento = (Elemento) getItem(position);

        // Configurar las vistas
        ImageView imagen = convertView.findViewById(R.id.imagen);
        TextView titulo = convertView.findViewById(R.id.titulo);
        TextView descripcion = convertView.findViewById(R.id.descripcion);

        // Establecer los valores
        imagen.setImageResource(elemento.getImagenResId());
        titulo.setText(elemento.getTitulo());
        descripcion.setText(elemento.getDescripcion());

        return convertView;
    }
}
