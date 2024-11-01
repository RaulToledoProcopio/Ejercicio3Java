package Ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private final List<Habitacion> habitaciones;
    private final List<Reserva> reservas;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();

        // Creamos 5 habitaciones de prueba
        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public void mostrarHabitaciones() {
        System.out.println("Habitaciones disponibles:");
        for (Habitacion habitacion : habitaciones) {
            String estado = habitacion.isOcupada() ? "Ocupada" : "Disponible";
            System.out.println("Habitación " + habitacion.getNumero() + " - Estado: " + estado);
        }
    }

    public void reservarHabitacion(Scanner scanner) {
        mostrarHabitaciones();
        System.out.println("Introduce el número de la habitación:");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Habitacion habitacion = habitaciones.stream()
                .filter(h -> h.getNumero() == numeroHabitacion)
                .findFirst()
                .orElse(null);

        if (habitacion == null) {
            System.out.println("No se encuentra la habitación");
            return;
        }

        if (habitacion.isOcupada()) {
            System.out.println("La habitación " + habitacion.getNumero() + " ya está ocupada.");
            return;
        }

        System.out.println("Introduce tu nombre:");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente);
        Reserva reserva = new Reserva(cliente, habitacion);

        habitacion.setOcupada(true); // Marcar la habitación como ocupada
        reservas.add(reserva); // Agregar la reserva a la lista
        System.out.println("La habitación " + habitacion.getNumero() + " ha sido reservada a nombre de: " + cliente.getNombre() + ".");
    }

    public void cancelarReserva(Scanner scanner) {
        System.out.println("Introduce el número de la habitación para cancelar la reserva:");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Reserva reserva = reservas.stream()
                .filter(r -> r.getHabitacion().getNumero() == numeroHabitacion)
                .findFirst()
                .orElse(null);

        if (reserva == null) {
            System.out.println("La habitación " + numeroHabitacion + " no está reservada.");
            return;
        }

        reservas.remove(reserva); // Eliminar la reserva de la lista
        reserva.getHabitacion().setOcupada(false); // Marcar la habitación como disponible
        System.out.println("La reserva de la habitación " + reserva.getHabitacion().getNumero() + " ha sido cancelada.");
    }

    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            System.out.println("Reservas actuales:");
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.getCliente().getNombre() + ", Habitación: " + reserva.getHabitacion().getNumero());
            }
        }
    }
}
