package Ejercicio3;

public class Mago {
    private String nombre;
    private int puntosVida;
    private final String hechizoNombre = "Bola de fuego"; // Nombre del único hechizo
    private final int damage = 15; // Daño fijo del hechizo

    public Mago(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void usarHechizo() {
        System.out.println(nombre + " lanza " + hechizoNombre + " y causa " + damage + " de daño.");
    }
}
