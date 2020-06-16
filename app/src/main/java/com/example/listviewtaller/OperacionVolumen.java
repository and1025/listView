package com.example.listviewtaller;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OperacionVolumen extends AppCompatActivity {
    private TextView tipo;
    private TextView lado;
    private TextView resultado;
    private EditText input_lado;
    private int tipo_op;
    double lado_input = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion_volumen);
        int valor = getIntent().getIntExtra("tipo" , 0);
        tipo = findViewById(R.id.tipo);
        lado = findViewById(R.id.lado1);
        //lado.setText(R.string.lado);
        tipo_op = valor;
        if(valor == 1){
            tipo.setText(R.string.esfera);
            lado.setText(R.string.radio);
        }else if(valor == 2){
            tipo.setText(R.string.cilindro);
            lado.setText(R.string.lado);
        }else if(valor == 3){
            tipo.setText(R.string.cono);
            lado.setText(R.string.radio);
        }else if(valor == 4){
            lado.setText(R.string.radio);
            tipo.setText(R.string.cubo);
        }
        resultado = findViewById(R.id.resultado);
        input_lado = findViewById(R.id.input_lado);
    }

    public void calcular(View v){
        OperacionModel o;
        String ope;
        String dato;
        String result;
        double result_final;
        String error_vacio = getResources().getString(R.string.error_vacio);
        if(!input_lado.getText().toString().isEmpty()){
            lado_input = Double.parseDouble(input_lado.getText().toString());
            if(tipo_op == 1){
                result_final = (lado_input * lado_input);
                resultado.setText("     Total: " + " " +  result_final );
                ope = "Esfera";
            }else if(tipo_op == 2){
                result_final = (lado_input * lado_input);
                resultado.setText("     Total: " + " " +  result_final );
                ope = "Cilindro";
            }else if(tipo_op == 3){
                result_final = (lado_input * lado_input / 2);
                resultado.setText("     Total: " + " " +  result_final );
                ope = "Cono";
            }else{
                result_final = (3.14 * (lado_input * lado_input));
                resultado.setText("     Total: " + " " +  result_final );
                ope = "Cubo";
            }
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
