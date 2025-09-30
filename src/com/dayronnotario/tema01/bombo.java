package com.dayronnotario.tema01;

import java.util.ArrayList;
import java.util.Random;

public class bombo {
    private final int[] numeros;
    private int cantidad;

    public bombo (int cantidad, int min) {
        numeros = new int[cantidad];
        this.cantidad = cantidad;
        int valor = min;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = valor++;
        }
    }

    public int getBola(){
        Random random = new Random();
        int posicion = random.nextInt(cantidad);
        int bola = numeros[posicion];
        numeros[posicion] = numeros[cantidad - 1];
        numeros[cantidad - 1] = bola;
        cantidad --;
        return bola;
    }

    public void reiniciar(){
        cantidad = numeros.length;
    }
}
