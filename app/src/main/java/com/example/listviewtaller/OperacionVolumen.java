package com.example.listviewtaller;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class OperacionVolumen extends AppCompatActivity {
    private TextView tipo, lado, lado2;
    private TextView resultado;
    private EditText input_lado, input_lado2;
    private int tipo_op;
    double lado_input = 0;
    double lado_input2 = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion_volumen);
        int valor = getIntent().getIntExtra("tipo" , 0);
        tipo = findViewById(R.id.tipo);
        lado = findViewById(R.id.lado1);
        lado2 = findViewById(R.id.lado2);
        input_lado = findViewById(R.id.input_lado);
        input_lado2 = findViewById(R.id.input_lado2);
        //lado.setText(R.string.lado);
        tipo_op = valor;
        if(valor == 1){
            lado2.setVisibility(View.GONE);
            input_lado2.setVisibility(View.GONE);
            tipo.setText(R.string.esfera);
            lado.setText(R.string.radio);
        }else if(valor == 2){
            tipo.setText(R.string.cilindro);
            lado.setText(R.string.lado);
            lado2.setText(R.string.altura);
        }else if(valor == 3){
            tipo.setText(R.string.cono);
            lado.setText(R.string.radio);
            lado2.setText(R.string.altura);
        }else if(valor == 4){
            lado.setText(R.string.lado);
            tipo.setText(R.string.cubo);
            lado2.setVisibility(View.GONE);
            input_lado2.setVisibility(View.GONE);
            lado2.setText(R.string.altura);
        }
        resultado = findViewById(R.id.resultado);

    }

    public void calcular(View v){
        OperacionModel o;
        String ope;
        String dato;
        String result;
        double result_final;
        DecimalFormat formato1 = new DecimalFormat("#.##");
        String error_vacio = getResources().getString(R.string.error_vacio);
        if(!input_lado.getText().toString().isEmpty()){
            lado_input = Double.parseDouble(input_lado.getText().toString());
            if(tipo_op == 1){
                result_final = (3.1416 * 4 * Math.pow(lado_input, 3))/3;
                resultado.setText("     "+ getString(R.string.total) + ":" + " " +  formato1.format(result_final) );
                ope = getString(R.string.esfera);
                dato = getString(R.string.radio) + ": " + lado_input;
                input_lado.requestFocus();
            }else if(tipo_op == 2){
                ope = getString(R.string.cilindro);
                if(!input_lado2.getText().toString().isEmpty()){
                    lado_input2 = Double.parseDouble(input_lado2.getText().toString());
                    result_final = ((3.1416 * Math.pow(lado_input, 2)) * lado_input2);
                    resultado.setText("     "+ getString(R.string.total) + ":" + " " +  formato1.format(result_final) );
                    input_lado2.requestFocus();
                    dato = getString(R.string.radio) +": " + input_lado.getText().toString()+ "-" + getString(R.string.altura) +": " +lado_input2 ;
                }else{
                    input_lado2.setError(error_vacio);
                    input_lado2.requestFocus();
                    return;
                }
            }else if(tipo_op == 3){
                ope = getString(R.string.cono);
                if(!input_lado2.getText().toString().isEmpty()){
                    lado_input2 = Double.parseDouble(input_lado2.getText().toString());
                    result_final = ((3.1416 * lado_input * lado_input2)/3);
                    input_lado2.requestFocus();
                    resultado.setText("     "+ getString(R.string.total) + ":" + " " +  formato1.format(result_final) );
                    dato = getString(R.string.radio) +": " + input_lado.getText().toString()+ "-" + getString(R.string.altura) +": " +lado_input2 ;
                }else{
                    input_lado2.setError(error_vacio);
                    input_lado2.requestFocus();
                    return;
                }
            }else{
                result_final = Math.pow(lado_input, 3);
                resultado.setText("     "+ getString(R.string.lado)+ ":" + " " +  result_final );
                ope = getString(R.string.cubo);
                dato = getString(R.string.lado) + ": " + input_lado.getText().toString();
            }
            result = formato1.format(result_final);
            o = new OperacionModel(ope,dato,result);
            o.guardar();
            input_lado.setText("");
            input_lado2.setText("");
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
