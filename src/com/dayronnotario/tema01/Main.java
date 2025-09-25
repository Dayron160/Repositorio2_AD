package com.dayronnotario.tema01;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println();
        System.out.println("HashMap");
        System.out.println();

        HashMap hashmap = new HashMap("Dayron", 1);
        System.out.println(hashmap.getValue("Dayron"));

        System.out.println();
        System.out.println("Act1");
        System.out.println();

        Act1 a1 = new Act1("ficheros", "DNIs.txt");
        a1.crearArchivo();
    }
}
