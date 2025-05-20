// package listacirculardoblemente;

public class NodoDobleCircular {
    public int dato;
    public NodoDobleCircular siguiente;
    public NodoDobleCircular anterior;

    public NodoDobleCircular(int dato) {
        this.dato = dato;
        this.siguiente = this; // Apunta a sí mismo inicialmente
        this.anterior = this;  // Apunta a sí mismo inicialmente
    }
}