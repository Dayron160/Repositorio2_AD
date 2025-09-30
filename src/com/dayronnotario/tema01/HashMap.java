package com.dayronnotario.tema01;

import java.util.ArrayList;

public class HashMap {
    private ArrayList<String> keys = new ArrayList<String>();
    private ArrayList<Object> values = new ArrayList<Object>();
    private int position = 0;
    public HashMap(String key, Object value){
        keys.add(0, key);
        values.add(0, value);
        position++;
    }

    /**
     * Añade un nuevo valor enlazado a una clave String a la lista
     * @param key
     * @param value
     */
    public void anyadir(String key, Object value){
        keys.add(position, key);
        values.add(position, value);
        position++;
    }

    /**
     * Devuelve el valor que esté enlazado a una key en concreto
     * @param key
     * @return value2 o null
     */
    public Object getValue(String key){
        int contador = 0;
        for (String i: keys) {
            if (key.equals(i)) {
                Object value2 = values.get(contador);
                return(value2);
            }
            contador++;
        }
        return null;
    }
}
