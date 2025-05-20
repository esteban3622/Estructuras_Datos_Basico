package listadoblementeenlazada;

public class NodoDoble {
    public int dato;
    public NodoDoble siguiente; // Referencia al siguiente nodo
    public NodoDoble anterior;  // Referencia al nodo anterior

    // Constructor
    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null; // Al crearse, no tiene siguiente
        this.anterior = null;  // Al crearse, no tiene anterior
    }
}