package com.dayronnotario.tema01;

import java.io.File;
import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
    private String nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    public Alumno(String nia, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento){
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(nia, alumno.nia);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nia);
    }
}
