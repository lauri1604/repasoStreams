package org.iesteis;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AlumnosStorageCSV {
    private Alumno toAlumno(String[] linea) {
        String nombre = linea[0];
        String curso = linea[1];
        boolean matriculado = Boolean.parseBoolean(linea[2]);
        int edad = Integer.parseInt(linea[3]);
        return new Alumno(nombre, curso, matriculado, edad);
    }

    void cargarDatos() {
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
    void guardarDatos(List<Alumno> alumnos) {
        try {
               Path path = Path.of("data/alumnos2.csv");
               StringBuilder sb = new StringBuilder();
               sb.append("nombre,curso,matriculado,edad\n");
                alumnos.forEach(alumno -> sb.append(alumno.toStringCSV()).append("\n"));
                Files.writeString(path, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}