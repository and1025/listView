package com.example.listviewtaller;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OperacionArea extends AppCompatActivity {
    private String valor = getIntent().getStringExtra("tipo");
    private TextView tipo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion_area);
        if(valor.toString() == "1"){
            tipo.setText(R.string.cuadrado);
        }else if(valor.toString()  == "2"){
            tipo.setText(R.string.rectangulo);
        }else if(valor.toString() == "3"){
            tipo.setText(R.string.triangulo);
        }else if(valor.toString() == "4"){
            tipo.setText(R.string.circulo);
        }
        Log.d("valor",valor);
        tipo = findViewById(R.id.tipo);

    }

    private void calcular(){

    }
}
