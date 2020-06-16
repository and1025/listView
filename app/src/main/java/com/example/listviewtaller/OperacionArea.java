package com.example.listviewtaller;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OperacionArea extends AppCompatActivity {
    private TextView tipo;
    private TextView lado;
    private TextView resultado;
    private EditText input_lado;

    double lado_input = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion_area);
        String valor = getIntent().getStringExtra("tipo");
        tipo = findViewById(R.id.tipo);
        lado = findViewById(R.id.lado1);
        lado.setText(R.string.lado);
        tipo.setText(valor);
        resultado = findViewById(R.id.resultado);
        input_lado = findViewById(R.id.input_lado);
    }

    public void calcular(View v){
        OperacionModel o;
        String ope , dato, result;
        String error_vacio = getResources().getString(R.string.error_vacio);
        if(!input_lado.getText().toString().isEmpty()){
            Log.d("lado", String.valueOf(input_lado));
            lado_input = Double.parseDouble(input_lado.getText().toString());
            resultado.setText("     Total: " + " " + (lado_input * lado_input));
            ope = getIntent().getStringExtra("tipo");
            dato = input_lado.getText().toString();
            result = String.valueOf((lado_input * lado_input));
            o = new OperacionModel(ope,dato,result);
            o.guardar();
            input_lado.setText("");
            input_lado.requestFocus();
        }
        else {
            input_lado.setError(error_vacio);
            input_lado.requestFocus();
            return;
        }
        //Integer.parseInt(String.valueOf(lado));
    }

    public void borrar(View v){
        input_lado.setText(String.valueOf(0));
        input_lado.requestFocus();
    }
}
