package org.iesteis;
import java.util.List;

public class Alumno {
    private String nombre;
    private String curso;
    private boolean matriculado;
    private int edad;

    public Alumno(String nombre, String curso, int edad) {
        this.nombre = nombre;
        this.curso = curso;
        this.edad = edad;
        this.matriculado = true;
    }

    public Alumno(String nombre, String curso, boolean matriculado, int edad) {
        this.nombre = nombre;
        this.curso = curso;
        this.matriculado = matriculado;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return "org.iesteis.Alumno: " + nombre + " " + curso + " " + matriculado + " " + edad;
    }
}