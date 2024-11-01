package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void run(Scanner sc) {
        Profesor profesor = new Profesor();
        int opcion;

        do {
            System.out.println("Elige una opción");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Asignar curso a estudiante");
            System.out.println("3. Agregar nota a estudiante");
            System.out.println("4. Calcular nota media del estudiante");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    profesor.agregarEstudiante(sc);
                    break;
                case 2:
                    profesor.agregarCurso(sc);
                    break;
                case 3:
                    profesor.agregarCalificacion(sc);
                    break;
                case 4:
                    profesor.calcularNotaMedia(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Elige una opción válida");
                    break;
            }
        } while (opcion != 0);
    }
}
