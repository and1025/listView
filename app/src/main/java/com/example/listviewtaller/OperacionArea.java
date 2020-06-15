package com.example.listviewtaller;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OperacionArea extends AppCompatActivity {

    private TextView tipo;
    private TextView lado;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion_area);
        String valor = getIntent().getStringExtra("tipo");
        tipo = findViewById(R.id.tipo);
        lado = findViewById(R.id.lado1);
        lado.setText(R.string.lado);
        tipo.setText(valor);
    }

    private void calcular(){

    }
}
