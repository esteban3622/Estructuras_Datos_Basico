package listasimplementeenlazada;

public class Nodo {
    public int dato;        // El valor que guarda el nodo
    public Nodo siguiente;  // La referencia (flechita) al siguiente nodo

    // Constructor para crear un nuevo nodo
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // Cuando se crea, no apunta a ningún otro nodo aún
    }
}