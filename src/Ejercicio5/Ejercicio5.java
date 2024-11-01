package Ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void run(Scanner sc) {
        Usuario usuario = new Usuario(); // Crear un usuario
        int opcion;

        do {
            System.out.println("Elige una opción: ");
            System.out.println("1. Crear Proyecto");
            System.out.println("2. Añadir Tarea al Proyecto");
            System.out.println("3. Marcar Tarea como Completada");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del proyecto: ");
                    String nombreProyecto = sc.nextLine();
                    usuario.crearProyecto(nombreProyecto);
                    break;
                case 2:
                    System.out.print("Introduce el nombre del proyecto: ");
                    nombreProyecto = sc.nextLine();
                    System.out.print("Introduce el nombre de la tarea: ");
                    String nombreTarea = sc.nextLine();
                    Tarea tarea = new Tarea(nombreTarea);
                    usuario.añadirTareaProyecto(nombreProyecto, tarea);
                    break;
                case 3:
                    System.out.print("Introduce el nombre del proyecto: ");
                    nombreProyecto = sc.nextLine();
                    System.out.print("Introduce el nombre de la tarea a completar: ");
                    nombreTarea = sc.nextLine();
                    usuario.marcarTarea(nombreProyecto, nombreTarea);
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