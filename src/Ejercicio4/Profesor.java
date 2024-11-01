package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profesor {
    private List<Estudiante> estudiantes;

    public Profesor() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Scanner scanner) {
        System.out.print("Ingresa el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        Estudiante estudiante = new Estudiante(nombreEstudiante);
        estudiantes.add(estudiante);
        System.out.println("'" + nombreEstudiante + "' agregado.");
    }

    public void agregarCurso(Scanner scanner) {
        System.out.print("Ingresa el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            System.out.print("Ingresa el nombre del curso: ");
            String nombreCurso = scanner.nextLine();
            estudiante.getCursosAsignados().add(nombreCurso);
            System.out.println("'" + nombreCurso + "' asignado a " + estudiante.getNombre() + ".");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void agregarCalificacion(Scanner scanner) {
        System.out.print("Ingresa el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            System.out.print("Ingresa la calificación: ");
            Double calificacion = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea
            estudiante.getCalificaciones().add(calificacion);
            System.out.println("Calificación " + calificacion + " agregada a " + estudiante.getNombre() + ".");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void calcularNotaMedia(Scanner scanner) {
        System.out.print("Ingresa el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        Estudiante estudiante = buscarEstudiante(nombreEstudiante);
        if (estudiante != null) {
            List<Double> calificaciones = estudiante.getCalificaciones();
            if (calificaciones.isEmpty()) {
                System.out.println(estudiante.getNombre() + " no tiene calificaciones.");
            } else {
                double promedio = calificaciones.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                System.out.println(estudiante.getNombre() + " - Nota media: " + promedio);
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private Estudiante buscarEstudiante(String nombre) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}
