package com.dayronnotario.tema01;

import java.io.File;

public class Alumno {
    private String nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    public Alumno(String nia, String nombre, String apellido1, String apellido2, String fechaNacimiento){
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
}
