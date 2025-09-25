package com.dayronnotario.tema01;

import java.io.*;

public class Act1 {
    private File file;
    private String directorio;
    private String fichero;
    public Act1(String directorio, String fichero){
        this.directorio = directorio;
        this.fichero = fichero;
        file = new File(directorio + "/" + fichero);
    }
    public void setFile(String directorio, String fichero){
        this.directorio = directorio;
        this.fichero = fichero;
        file = new File(directorio + "/" + fichero);
    }
    public File getFile(){
        return file;
    }

    /**
     * Recibe un fichero con 20 dnis sin letra y crea un nuevo fichero con estos dnis con la letra
     * @throws IOException
     */
    public void crearArchivo() throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("El archivo " + file.getAbsolutePath() + " no existe");
        } else {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(new File(directorio + "/" + fichero.substring(0, fichero.lastIndexOf(".")) + "_conLetras" + fichero.substring(fichero.lastIndexOf("."), fichero.length())));
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                String linea;
                int contador = 1;
                while ((linea = br.readLine()) != null && contador <= 20) {
                    if (linea.length() > 8) {
                        throw new IOException("La linea tiene más cáracteres que un DNI");
                    } else {
                        if (linea.length() < 8) {
                            StringBuilder sb = new StringBuilder(linea);
                            for (int i = linea.length(); i < 8; i++) {
                                sb.insert(0, "0");
                            }
                            linea = sb.toString();
                        }
                        int dni = Integer.parseInt(linea);
                        int resto = dni % 23;
                        char letra = ' ';

                        switch (resto) {
                            case 0:
                                letra = 'T';
                                break;
                            case 1:
                                letra = 'R';
                                break;
                            case 2:
                                letra = 'W';
                                break;
                            case 3:
                                letra = 'A';
                                break;
                            case 4:
                                letra = 'G';
                                break;
                            case 5:
                                letra = 'M';
                                break;
                            case 6:
                                letra = 'Y';
                                break;
                            case 7:
                                letra = 'F';
                                break;
                            case 8:
                                letra = 'P';
                                break;
                            case 9:
                                letra = 'D';
                                break;
                            case 10:
                                letra = 'X';
                                break;
                            case 11:
                                letra = 'B';
                                break;
                            case 12:
                                letra = 'N';
                                break;
                            case 13:
                                letra = 'J';
                                break;
                            case 14:
                                letra = 'Z';
                                break;
                            case 15:
                                letra = 'S';
                                break;
                            case 16:
                                letra = 'Q';
                                break;
                            case 17:
                                letra = 'V';
                                break;
                            case 18:
                                letra = 'H';
                                break;
                            case 19:
                                letra = 'L';
                                break;
                            case 20:
                                letra = 'C';
                                break;
                            case 21:
                                letra = 'K';
                                break;
                            case 22:
                                letra = 'E';
                                break;
                        }
                        bw.write(linea + letra + "\n");
                        contador++;
                    }
                }
            } finally{
            br.close();
            fr.close();
            bw.close();
            fw.close();
        }
    }
    }
}
