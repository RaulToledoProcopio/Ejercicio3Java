package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaJuego {
    private List<Guerrero> guerreros;
    private List<Mago> magos;
    private Scanner scanner;

    public SistemaJuego() {
        this.guerreros = new ArrayList<>();
        this.magos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Metodo para crear un Guerrero

    public void crearGuerrero() {
        System.out.println("Introduce el nombre del Guerrero:");
        String nombre = scanner.nextLine();
        guerreros.add(new Guerrero(nombre, 100));
        System.out.println(nombre + " creado.");
    }

    // Metodo para crear un Mago

    public void crearMago() {
        System.out.println("Introduce el nombre del Mago:");
        String nombre = scanner.nextLine();
        magos.add(new Mago(nombre, 100)); // Mago con 100 puntos de vida
        System.out.println(nombre + " creado.");
    }

    // Metodo para mostrar los personajes

    public void mostrarPersonajes() {
        if (guerreros.isEmpty() && magos.isEmpty()) {
            System.out.println("No hay personajes creados.");
            return;
        }

        System.out.println("Personajes creados:");
        for (Guerrero guerrero : guerreros) {
            System.out.println(guerrero.getNombre() + " - Guerrero");
        }
        for (Mago mago : magos) {
            System.out.println(mago.getNombre() + " - Mago");
        }
    }

    // Metodo para realizar una acción

    public void realizarAccion() {
        System.out.println("Selecciona un personaje:");
        mostrarPersonajes();

        System.out.println("Introduce el nombre del personaje que quieres usar:");
        String nombre = scanner.nextLine();

        // Buscamos el personaje en la lista
        Guerrero guerrero = guerreros.stream().filter(g -> g.getNombre().equals(nombre)).findFirst().orElse(null);
        Mago mago = magos.stream().filter(m -> m.getNombre().equals(nombre)).findFirst().orElse(null);

        if (guerrero != null) {
            guerrero.atacar();
        } else if (mago != null) {
            mago.usarHechizo();
        } else {
            System.out.println("Personaje no encontrado.");
        }
    }
}
