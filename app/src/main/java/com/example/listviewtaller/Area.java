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

public class Area extends AppCompatActivity {
    private ListView lista_opciones;
    private String[] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        lista_opciones = findViewById(R.id.lstOpciones2);
        opciones = getResources().getStringArray(R.array.areas);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lista_opciones.setAdapter(adapter);
        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        //intent = new Intent(MainActivity.this, Area.class);
                        //startActivity(intent);
                        Log.d("mensaje:" , String.valueOf(position));
                        break;
                    case 1:
                        Log.d("mensaje:" , String.valueOf(position));
                        //intent = new Intent(MainActivity.this, Volumen.class);
                        //startActivity(intent);
                        break;
                    case 2:
                        Log.d("mensaje:" , String.valueOf(position));
                        //intent = new Intent(MainActivity.this, Operaciones.class);
                        //startActivity(intent);
                        break;
                }}
        });

    }

}