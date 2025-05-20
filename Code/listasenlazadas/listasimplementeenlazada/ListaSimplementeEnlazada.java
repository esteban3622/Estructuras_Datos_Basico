package listasimplementeenlazada;

public class ListaSimplementeEnlazada {
    private Nodo cabeza; // Referencia al primer nodo de la lista (la cabeza)

    // Constructor: Inicializa una lista vacía
    public ListaSimplementeEnlazada() {
        this.cabeza = null; // Una lista vacía no tiene cabeza
    }

    // OPERACIONES BÁSICAS:

    // 1. Verificar si la lista está vacía
    public boolean estaVacia() {
        return this.cabeza == null;
    }

    // 2. Insertar un elemento al inicio de la lista
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato); // Creamos el nuevo nodo
        if (estaVacia()) {
            this.cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo es la cabeza
        } else {
            nuevoNodo.siguiente = this.cabeza; // El nuevo nodo apunta a la antigua cabeza
            this.cabeza = nuevoNodo;           // La cabeza de la lista ahora es el nuevo nodo
        }
        System.out.println("Se insertó " + dato + " al inicio.");
    }

    // Insertar un elemento al final de la lista (Más complejo sin referencia a la cola)
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            this.cabeza = nuevoNodo;
        } else {
            Nodo actual = this.cabeza;
            while (actual.siguiente != null) { // Recorremos hasta el último nodo
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo; // Enlazamos el último nodo con el nuevo
        }
        System.out.println("Se insertó " + dato + " al final.");
    }


    // 3. Eliminar el primer elemento de la lista
    public void eliminarAlInicio() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar, la lista está vacía.");
            return;
        }
        int datoEliminado = this.cabeza.dato;
        this.cabeza = this.cabeza.siguiente; // La cabeza ahora es el que le seguía al antiguo primero
        System.out.println("Se eliminó " + datoEliminado + " del inicio.");
        // El recolector de basura se encargará del nodo que quedó sin referencia
    }

    // 4. Buscar un elemento en la lista
    public boolean buscar(int dato) {
        Nodo actual = this.cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                System.out.println("Se encontró el dato: " + dato);
                return true; // Dato encontrado
            }
            actual = actual.siguiente;
        }
        System.out.println("No se encontró el dato: " + dato);
        return false; // Dato no encontrado
    }

    // 5. Recorrer y mostrar los elementos de la lista
    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Elementos de la lista: ");
        Nodo actual = this.cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null"); // Para indicar el final de la lista
    }

    // --- Clase principal para probar la lista (puede ir en otro archivo o aquí mismo) ---
    public static void main(String[] args) {
        ListaSimplementeEnlazada miLista = new ListaSimplementeEnlazada();

        System.out.println("¿Lista vacía? " + miLista.estaVacia());
        miLista.mostrarLista();

        miLista.insertarAlInicio(10);
        miLista.mostrarLista();
        miLista.insertarAlInicio(20);
        miLista.mostrarLista();
        miLista.insertarAlFinal(5);
        miLista.mostrarLista();
        miLista.insertarAlInicio(30);
        miLista.mostrarLista();

        System.out.println("\n¿Lista vacía? " + miLista.estaVacia());

        miLista.buscar(10);
        miLista.buscar(100);

        System.out.println("\n--- Eliminando elementos ---");
        miLista.eliminarAlInicio();
        miLista.mostrarLista();
        miLista.eliminarAlInicio();
        miLista.mostrarLista();
        miLista.eliminarAlInicio();
        miLista.mostrarLista();
        miLista.eliminarAlInicio();
        miLista.mostrarLista(); // Debería estar vacía
        miLista.eliminarAlInicio(); // Intentar eliminar de lista vacía
    }
}