// Archivo: ListaCircularDoblementeEnlazada.java
// package listacirculardoblemente;

public class ListaCircularDoblementeEnlazada {
    private NodoDobleCircular acceso; // Un punto de acceso a la lista, puede ser cualquier nodo

    public ListaCircularDoblementeEnlazada() {
        this.acceso = null;
    }

    public boolean estaVacia() {
        return this.acceso == null;
    }

    public void insertar(int dato) {
        NodoDobleCircular nuevoNodo = new NodoDobleCircular(dato);
        if (estaVacia()) {
            this.acceso = nuevoNodo;
            // El nuevoNodo ya se apunta a sí mismo en su constructor.
        } else {
            // Enlazar el nuevo nodo con el antiguo "último" y la "cabeza"
            nuevoNodo.anterior = this.acceso;
            nuevoNodo.siguiente = this.acceso.siguiente; // La cabeza lógica

            this.acceso.siguiente.anterior = nuevoNodo; // La cabeza lógica apunta atrás al nuevo
            this.acceso.siguiente = nuevoNodo;          // El último apunta adelante al nuevo

            this.acceso = nuevoNodo; // Opcional: hacer que el nuevo sea el punto de acceso
        }
        System.out.println("Se insertó " + dato);
    }

    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("Lista circular doblemente enlazada está vacía.");
            return;
        }
        System.out.print("Elementos: <-> ");
        NodoDobleCircular actual = this.acceso.siguiente; // Empezamos por la cabeza lógica
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != this.acceso.siguiente); // Hasta volver al inicio
        System.out.println("(vuelve a " + this.acceso.siguiente.dato + ")");
    }

    // Se necesitarían métodos para eliminar, buscar, etc.,
    // manejando cuidadosamente los enlaces anterior y siguiente
    // para mantener la circularidad y la doble conexión.

    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada miLista = new ListaCircularDoblementeEnlazada();
        miLista.insertar(10);
        miLista.insertar(20);
        miLista.insertar(30);
        miLista.mostrarLista(); // Debería mostrar: <-> 10 <-> 20 <-> 30 <-> (vuelve a 10)
                                // (El orden exacto dependerá de cómo se defina "acceso"
                                // y dónde inserte exactamente, este es un ejemplo conceptual)
    }
}