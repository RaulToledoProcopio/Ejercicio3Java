package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private List<Proyecto> proyectos;

    public Usuario() {
        this.proyectos = new ArrayList<>();
    }

    public void crearProyecto(String nombreProyecto) {
        Proyecto proyecto = new Proyecto(nombreProyecto);
        proyectos.add(proyecto);
        System.out.println("'" + nombreProyecto + "' creado.");
    }

    public void añadirTareaProyecto(String nombreProyecto, Tarea tarea) {
        Proyecto proyecto = proyectos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProyecto))
                .findFirst()
                .orElse(null);
        if (proyecto != null) {
            proyecto.añadirTarea(tarea);
        } else {
            System.out.println("'" + nombreProyecto + "' no encontrado.");
        }
    }

    public void marcarTarea(String nombreProyecto, String nombreTarea) {
        Proyecto proyecto = proyectos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProyecto))
                .findFirst()
                .orElse(null);
        if (proyecto != null) {
            Tarea tarea = proyecto.buscarTarea(nombreTarea);
            if (tarea != null) {
                tarea.completar();
            } else {
                System.out.println("'" + nombreTarea + "' no encontrada en '" + nombreProyecto + "'.");
            }
        } else {
            System.out.println("'" + nombreProyecto + "' no encontrado.");
        }
    }
}
