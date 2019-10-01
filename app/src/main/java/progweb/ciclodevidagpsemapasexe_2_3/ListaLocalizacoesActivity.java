package progweb.ciclodevidagpsemapasexe_2_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaLocalizacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_localizacoes);
        Intent origemIntent = getIntent();
        final ListView listaDeLocais = findViewById(R.id.localizacoes_listview);
        LocaisDAO locais = new LocaisDAO();
        final double lat = Localizacao.getLat();
        final double lon = Localizacao.getLon();


        listaDeLocais.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locais.dados()));

        listaDeLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f?", lat, lon));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        /**/
    }
}

