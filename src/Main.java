import java.util.Scanner;

import Ejercicio1.Ejercicio1;
import Ejercicio2.Ejercicio2;
import Ejercicio3.Ejercicio3;
import Ejercicio4.Ejercicio4;
import Ejercicio5.Ejercicio5;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion = -1;

    while (opcion != 0) { // Bucle que se ejecuta mientras la opción no sea 0.
        System.out.println("Elige una opción:");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
        System.out.println("5. Ejercicio 5");
        System.out.println("0. Salir");

        opcion = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.println("Ejecutando el Ejercicio 1...");
                Ejercicio1.run(sc);
                break;
            case 2:
                System.out.println("Ejecutando el Ejercicio 2...");
                Ejercicio2.run(sc);
                break;
            case 3:
                System.out.println("Ejecutando el Ejercicio 3...");
                Ejercicio3.run(sc);
                break;
            case 4:
                System.out.println("Ejecutando el Ejercicio 4...");
                Ejercicio4.run(sc);
                break;
            case 5:
                System.out.println("Ejecutando el Ejercicio 5...");
                Ejercicio5.run(sc);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Elige una opción válida.");
                break;
        }
    }
    sc.close();
}
