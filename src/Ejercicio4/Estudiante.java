package Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Double> calificaciones;
    private List<String> cursosAsignados;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
        this.cursosAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Double> getCalificaciones() {
        return calificaciones;
    }

    public List<String> getCursosAsignados() {
        return cursosAsignados;
    }
}
