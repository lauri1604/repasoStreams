package org.iesteis;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Alumno {
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("curso")
    private String curso;
    @JsonProperty("matriculado")
    private boolean matriculado;
    @JsonProperty("edad")
    private int edad;

    public Alumno(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("curso") String curso,
            @JsonProperty("edad") int edad) {
        this.nombre = nombre;
        this.curso = curso;
        this.edad = edad;
        this.matriculado = true;
    }
    @JsonCreator
    public Alumno(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("curso") String curso,
            @JsonProperty("matriculado") boolean matriculado,
            @JsonProperty("edad") int edad) {
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
        return "Alumno: " + nombre + " " + curso + " " + matriculado + " " + edad;
    }

    public String toStringCSV() {
        return nombre + "," + curso + "," + matriculado + "," + edad;
    }

}