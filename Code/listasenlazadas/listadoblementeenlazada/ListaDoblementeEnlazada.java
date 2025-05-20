package listadoblementeenlazada;

public class ListaDoblementeEnlazada {
    private NodoDoble cabeza;   // Referencia al primer nodo
    private NodoDoble cola;     // Referencia al último nodo (útil para inserciones al final)

    // Constructor: Inicializa una lista doblemente enlazada vacía
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    // 1. Verificar si la lista está vacía
    public boolean estaVacia() {
        return this.cabeza == null;
    }

    // 2. Insertar un elemento al inicio de la lista
    public void insertarAlInicio(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (estaVacia()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo; // Si es el único nodo, también es la cola
        } else {
            nuevoNodo.siguiente = this.cabeza; // El nuevo nodo apunta a la antigua cabeza
            this.cabeza.anterior = nuevoNodo;  // La antigua cabeza ahora apunta hacia atrás al nuevo nodo
            this.cabeza = nuevoNodo;           // La cabeza de la lista ahora es el nuevo nodo
        }
        System.out.println("Se insertó " + dato + " al inicio.");
    }

    // Insertar un elemento al final de la lista
    public void insertarAlFinal(int dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (estaVacia()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            this.cola.siguiente = nuevoNodo; // El antiguo último nodo apunta al nuevo
            nuevoNodo.anterior = this.cola;  // El nuevo nodo apunta hacia atrás al antiguo último
            this.cola = nuevoNodo;           // La cola de la lista ahora es el nuevo nodo
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
        if (this.cabeza == this.cola) { // Si solo hay un nodo
            this.cabeza = null;
            this.cola = null;
        } else {
            this.cabeza = this.cabeza.siguiente; // La cabeza ahora es el segundo nodo
            this.cabeza.anterior = null;         // El enlace anterior de la nueva cabeza es null
        }
        System.out.println("Se eliminó " + datoEliminado + " del inicio.");
    }

    // Eliminar el último elemento de la lista
    public void eliminarAlFinal() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar, la lista está vacía.");
            return;
        }
        int datoEliminado = this.cola.dato;
        if (this.cabeza == this.cola) { // Si solo hay un nodo
            this.cabeza = null;
            this.cola = null;
        } else {
            this.cola = this.cola.anterior; // La cola ahora es el penúltimo nodo
            this.cola.siguiente = null;    // El enlace siguiente de la nueva cola es null
        }
        System.out.println("Se eliminó " + datoEliminado + " del final.");
    }


    // 4. Mostrar los elementos de la lista (recorrido hacia adelante)
    public void mostrarAdelante() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Elementos (adelante): cabeza -> ");
        NodoDoble actual = this.cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // 5. Mostrar los elementos de la lista (recorrido hacia atrás)
    public void mostrarAtras() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Elementos (atrás): cola -> ");
        NodoDoble actual = this.cola;
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }

    // --- Clase principal para probar la lista doblemente enlazada ---
    public static void main(String[] args) {
        ListaDoblementeEnlazada miListaDoble = new ListaDoblementeEnlazada();

        System.out.println("¿Lista vacía? " + miListaDoble.estaVacia());
        miListaDoble.mostrarAdelante();

        miListaDoble.insertarAlInicio(10);
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();

        miListaDoble.insertarAlInicio(20);
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();

        miListaDoble.insertarAlFinal(5);
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();

        miListaDoble.insertarAlFinal(1);
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();


        System.out.println("\n--- Eliminando elementos ---");
        miListaDoble.eliminarAlInicio();
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();

        miListaDoble.eliminarAlFinal();
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();

        miListaDoble.eliminarAlInicio();
        miListaDoble.eliminarAlFinal(); // Lista debería quedar vacía
        miListaDoble.mostrarAdelante();
        miListaDoble.mostrarAtras();
    }
}