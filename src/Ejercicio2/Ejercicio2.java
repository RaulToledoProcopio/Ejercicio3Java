package Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void run(Scanner sc) {
        Hotel hotel = new Hotel();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("Elige una opción:");
            System.out.println("1. Mostrar habitaciones");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Mostrar reservas activas");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    hotel.mostrarHabitaciones();
                    break;
                case 2:
                    hotel.reservarHabitacion(sc);
                    break;
                case 3:
                    hotel.cancelarReserva(sc);
                    break;
                case 4:
                    hotel.mostrarReservas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Elige una opción válida");
                    break;
            }
        }
    }
}
