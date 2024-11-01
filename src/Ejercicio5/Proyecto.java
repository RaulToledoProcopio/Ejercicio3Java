package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public void añadirTarea(Tarea tarea) {
        tareas.add(tarea);
        System.out.println("'" + tarea.getNombre() + "' añadida a '" + nombre + "'.");
    }

    public Tarea buscarTarea(String nombreTarea) {
        return tareas.stream()
                .filter(tarea -> tarea.getNombre().equalsIgnoreCase(nombreTarea))
                .findFirst()
                .orElse(null);
    }

    public String getNombre() {
        return nombre;
    }
}
