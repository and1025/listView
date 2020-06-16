package com.example.listviewtaller;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<OperacionModel> operaciones = new ArrayList();

    public static void guardar(OperacionModel p){
        operaciones.add(p);
    }

    public static ArrayList<OperacionModel> obtener(){
        return operaciones;
    }
}
