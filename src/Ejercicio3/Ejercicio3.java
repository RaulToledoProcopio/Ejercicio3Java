package Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void run(Scanner sc) {
        SistemaJuego juego = new SistemaJuego();
        int opcion = -1;

        while (opcion != 0) { // Bucle que se ejecuta mientras la opción no sea 0.
            System.out.println("Elige una opción:");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Mostrar personajes");
            System.out.println("4. Realizar acción");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1 -> juego.crearGuerrero();
                case 2 -> juego.crearMago();
                case 3 -> juego.mostrarPersonajes();
                case 4 -> juego.realizarAccion();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Elige una opción válida");
            }
        }
    }
}
