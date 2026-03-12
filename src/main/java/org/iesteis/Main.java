package org.iesteis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static void pruebas() {
        List<Integer> list = Arrays.asList(10, 2, 31, 54, 27, 9, 1);
        //        System.out.println(list.stream().sorted().filter(i -> i > 10).toList());
        //        System.out.println(list.stream().filter(i -> i % 2 == 0).toList());
        //        System.out.println(list.stream().filter(i -> i % 2 == 0).mapToDouble(Integer::doubleValue).sum());

        List<String> list2 = Arrays.asList("hola", "DAM", "IES de Teis", "DAW", "ciaoo!");
        //        System.out.println(list2.stream().map(i -> i.toUpperCase()).toList());
        //        System.out.println(list2.stream().map(String::toUpperCase).toList());
        //        System.out.println(list2.stream().map(i -> i.startsWith("D")).toList());
        //        System.out.println(list2.stream().map(i -> i.matches("^[Dd].*s")).toList());
        // CASE_INSENSITIVE_ORDER es un comparador que compara cadenas de texto sin tener en cuenta mayúsculas o minúsculas
        System.out.println(list2.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed()).toList());
        System.out.println(list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "PAR" : "IMPAR")));
        Map<String, List<Integer>> map = list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0 ? "PAR" : "IMPAR"));
        System.out.println(map);
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("María", "DAM2", 20));
        alumnos.add(new Alumno("Antón", "DAW2", 19));
        alumnos.add(new Alumno("Laura", "DAM2", 20));
        alumnos.add(new Alumno("Breixo", "Ciber", false, 21));
        Map<String, List<String>> map2 = alumnos.stream().collect(Collectors.groupingBy(Alumno::getCurso, Collectors.mapping(Alumno::getNombre, Collectors.toList())));
        System.out.println(map2);
        Map<String, List<Alumno>> map3 = alumnos.stream().collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println(map3);
        Map<String, List<Alumno>> map4 = alumnos.stream().filter(Alumno -> Alumno.isMatriculado()).collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println(map4);
        Map<String, Double> map5 = alumnos.stream().collect(Collectors.groupingBy(Alumno::getCurso, Collectors.averagingDouble(Alumno::getEdad)));
        System.out.println(map5);
        System.out.println(alumnos.stream().map(Alumno::getNombre).collect(Collectors.joining(", ")));
        System.out.println(alumnos.stream().mapToDouble(Alumno::getEdad).average().getAsDouble());
        System.out.println(alumnos.stream().collect(Collectors.averagingDouble(Alumno::getEdad)));
    }

        public static void main(String[] args) {
            AlumnosStorage alumnos = new AlumnosStorage();
            alumnos.cargarDatosCSV();
        }
    }