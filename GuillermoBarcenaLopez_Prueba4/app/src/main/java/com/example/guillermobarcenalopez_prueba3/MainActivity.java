package com.example.guillermobarcenalopez_prueba3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.ListView;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ListView y el WebView
        ListView listView = findViewById(R.id.listView);
        WebView webView = findViewById(R.id.webView);

        // Configura el WebView para abrir URLs en la propia aplicación
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Crea una lista de elementos de ejemplo
        List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento(R.drawable.caravaggio, "CARAVAGGIO", "\nCARAVAGGIO: \"Pintor italiano entre los años de 1593 y 1610. Es considerado como el primer gran exponente de la pintura del Barroco.","http://es.wikipedia.org/wiki/Caravaggio"));
        elementos.add(new Elemento(R.drawable.rafael, "RAFAEL SANZIO", "Pintor y arquitecto italiano del Renacimiento, realizó importantes aportes en la arquitectura y, como inspector de antigüedades.","http://es.wikipedia.org/wiki/Rafael_Sanzio"));
        elementos.add(new Elemento(R.drawable.velazquez, "VELAZQUEZ", "Pintor Barroco nacido en Sevilla en 1599, es considerado uno de los máximos exponentes de la pintura española y maestro de la pintura universal.","http://es.wikipedia.org/wiki/Diego_Vel%C3%A1zquez"));
        elementos.add(new Elemento(R.drawable.miguelangel, "MIGUEL ANGEL", "Arquitecto, escultor y pintor italiano renacentista, considerado uno de los más grandes artistas de la historia.","http://es.wikipedia.org/wiki/Miguel_%C3%81ngel"));
        elementos.add(new Elemento(R.drawable.rembrant, "REMBRANDT", "Pintor y grabador holandés. La historia del arte le considera uno de los mayores maestros barrocos de la pintura y el grabado.","http://es.wikipedia.org/wiki/Rembrandt"));
        elementos.add(new Elemento(R.drawable.boticelli, "BOTICELLI", "Apodado Sandro Botticelli, fue un pintor cuatrocentista italiano. Su obra se ha considerado representativa de la pintura del primer Renacimiento.","http://es.wikipedia.org/wiki/Sandro_Botticelli"));
        elementos.add(new Elemento(R.drawable.leonardo, "LEONARDO DA VINCI", "Notable polímata del Renacimiento italiano (a la vez anatomista, arquitecto, artista, botánico, científico, escritor, escultor, filósofo, ingeniero...)","http://es.wikipedia.org/wiki/Leonardo_da_Vinci"));
        elementos.add(new Elemento(R.drawable.renoir, "RENOIR", "Pintor francés impresionista, interesado por la pintura de cuerpos femeninos en paisajes, inspirados a menudo en pinturas clásicas renacentistas y barrocas.","http://es.wikipedia.org/wiki/Pierre-Auguste_Renoir"));

        // Configura el adapter para el ListView
        ElementoAdapter adapter = new ElementoAdapter(this, elementos);
        listView.setAdapter(adapter);

        // Configura el evento onItemClick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Obtén el elemento seleccionado
                Elemento elementoSeleccionado = elementos.get(position);
                webView.loadUrl(elementoSeleccionado.getURL());
                webView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Cargando: " + elementoSeleccionado.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
