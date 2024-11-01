package Ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    private static Biblioteca biblioteca = new Biblioteca(); // Instancia de la biblioteca

    public static void run (Scanner sc) {
        int opcion = -1; // Inicialización de la variable que almacenará la opción del menú.

        while (opcion != 0) { // Bucle que se ejecuta mientras la opción no sea 0.
            System.out.println("Elige una opción:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar lista completa de libros");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    biblioteca.agregarLibro(sc);
                    break;
                case 2:
                    biblioteca.registrarUsuario(sc);
                    break;
                case 3:
                    biblioteca.prestarLibro(sc);
                    break;
                case 4:
                    biblioteca.devolverLibro(sc);
                    break;
                case 5:
                    biblioteca.mostrarLibros();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Elige una opción válida");
            }
        }
    }
}
