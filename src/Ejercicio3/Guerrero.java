package Ejercicio3;

public class Guerrero {
    private String nombre;
    private int puntosVida;

    public Guerrero(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void atacar() {
        int damage = 10; // Daño fijo para guerreros
        System.out.println(nombre + " ataca con su espada y causa " + damage + " de daño.");
    }
}
