package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private final List<Libro> libros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();

    public void agregarLibro(Scanner scanner) {
        System.out.println("Introduce el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Introduce el autor del libro:");
        String autor = scanner.nextLine();

        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo() + " por " + libro.getAutor());
    }

    public void registrarUsuario(Scanner scanner) {
        System.out.println("Introduce el nombre del usuario:");
        String nombre = scanner.nextLine();
        Usuario usuario = new Usuario(nombre);
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public void prestarLibro(Scanner scanner) {
        System.out.println("Introduce el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Introduce el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();

        Libro libro = libros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
        Usuario usuario = usuarios.stream().filter(u -> u.getNombre().equalsIgnoreCase(nombreUsuario)).findFirst().orElse(null);

        if (libro == null) {
            System.out.println("El libro '" + titulo + "' no está disponible");
            return;
        }

        if (usuario == null) {
            System.out.println("No se encontró ningún usuario con el nombre '" + nombreUsuario + "'.");
            return;
        }

        if (libro.isPrestado()) {
            System.out.println("El libro '" + titulo + "' ya está prestado a " + libro.getPrestadoA().getNombre() + ".");
        } else {
            libro.setPrestado(true);
            libro.setPrestadoA(usuario);
            System.out.println("El libro '" + titulo + "' ha sido prestado a " + usuario.getNombre() + ".");
        }
    }

    public void devolverLibro(Scanner scanner) {
        System.out.println("Introduce el título del libro que quieres devolver:");
        String titulo = scanner.nextLine();

        Libro libro = libros.stream().filter(l -> l.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);

        if (libro == null) {
            System.out.println("El libro '" + titulo + "' no está en la biblioteca.");
            return;
        }

        if (!libro.isPrestado()) {
            System.out.println("El libro '" + titulo + "' no está prestado.");
        } else {
            libro.setPrestado(false);
            System.out.println("El libro '" + titulo + "' ha sido devuelto a la biblioteca.");
            libro.setPrestadoA(null); // Limpiar la referencia del usuario que tenía el libro
        }
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Libros en la biblioteca:");
            for (Libro libro : libros) {
                String estado = libro.isPrestado() ? "Prestado a " + libro.getPrestadoA().getNombre() : "Disponible";
                System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor() + " [" + estado + "]");
            }
        }
    }
}
