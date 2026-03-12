package org.iesteis;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AlumnosStorage {
    private Alumno toAlumno(String[] linea) {
        String nombre = linea[0];
        String curso = linea[1];
        boolean matriculado = Boolean.parseBoolean(linea[2]);
        int edad = Integer.parseInt(linea[3]);
        return new Alumno(nombre, curso, matriculado, edad);
    }

    void cargarDatosCSV() {
        try {
            //Opcion 1: obtener Array de Strings
            List<String> list = Files.readAllLines(Path.of("data/alumnos.txt"));
            list.forEach(System.out::println);
            //Opcion 2: obtener Array de Alumnos
            List<Alumno> alumnos = Files.lines(Path.of("data/alumnos.csv"))
                    .skip(1)//Aquí se salta la primera línea del archivo, que suele ser el encabezado
                    .map(line -> line.split(","))//Aquí se obtiene un Stream separado por comas
                    .map(this::toAlumno)//Aquí se obtiene un Stream de Alumnos
                    .toList();
            System.out.println(alumnos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}