package org.iesteis;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AlumnosStorageJSON {
    void cargarDatos() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File f = new File("data/alumnos.json");
            if (!f.exists()) {
                throw new RuntimeException("No se ha encontrado el archivo");}
                List<Alumno> alumnos = mapper.readValue(f, new TypeReference<List<Alumno>>() {});
                alumnos.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void guardarDatos(List<Alumno> alumnos) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File f = new File("data/alumnos2.json");
            mapper.writeValue(f, alumnos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}