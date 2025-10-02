package com.dayronnotario.tema01;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println();
        System.out.println("HashMap");
        System.out.println();

        MyHashMap hashmap = new MyHashMap(1);
        hashmap.put("FB", 16);
        hashmap.put("Ea", 18);
        System.out.println(hashmap.get("FB"));
        hashmap.remove("Ea");
        System.out.println(hashmap.get("Ea"));

        System.out.println();
        System.out.println("Act1");
        System.out.println();

        Act1 a1 = new Act1("ficheros", "DNIs.txt");
        a1.crearArchivo();

        System.out.println();
        System.out.println("Act3");
        System.out.println();

        Act3 a3 = new Act3("ficheros");
    }
}
