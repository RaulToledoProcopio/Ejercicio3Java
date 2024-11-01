package Ejercicio5;

public class Tarea {
    private String nombre;
    private boolean completada; // Estado de la tarea (completada o no)

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.completada = false;
    }

    public void completar() {
        completada = true;
        System.out.println("La tarea '" + nombre + "' ha sido marcada como completada.");
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCompletada() {
        return completada;
    }

    @Override
    public String toString() {
        return nombre + " - " + (completada ? "Completada" : "Pendiente");
    }
}
