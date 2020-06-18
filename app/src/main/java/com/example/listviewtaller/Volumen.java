package com.example.listviewtaller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumen extends AppCompatActivity {
    private ListView lista_opciones;
    private String[] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        lista_opciones = findViewById(R.id.lstOpciones3);
        opciones = getResources().getStringArray(R.array.volumenes);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);
        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        intent = new Intent(Volumen.this, OperacionVolumen.class);
                        intent.putExtra("tipo", 1);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Volumen.this, OperacionVolumen.class);
                        intent.putExtra("tipo", 2);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Volumen.this, OperacionVolumen.class);
                        intent.putExtra("tipo", 3);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Volumen.this, OperacionVolumen.class);
                        intent.putExtra("tipo", 4);
                        startActivity(intent);
                        break;
                }}
        });

    }

}