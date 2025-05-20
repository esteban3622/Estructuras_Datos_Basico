// package listacircularsimplemente;

public class ListaCircularSimplementeEnlazada {
    private Nodo ultimo; // Referencia al "último" nodo; su 'siguiente' será la cabeza

    public ListaCircularSimplementeEnlazada() {
        this.ultimo = null;
    }

    // 1. Verificar si la lista está vacía
    public boolean estaVacia() {
        return this.ultimo == null;
    }

    // 2. Insertar un elemento (lo haremos de forma que el nuevo sea el "último")
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            this.ultimo = nuevoNodo;
            this.ultimo.siguiente = this.ultimo; // Apunta a sí mismo
        } else {
            nuevoNodo.siguiente = this.ultimo.siguiente; // El nuevo apunta a la antigua cabeza
            this.ultimo.siguiente = nuevoNodo;           // El antiguo último ahora apunta al nuevo
            this.ultimo = nuevoNodo;                     // El nuevo nodo es ahora el último
        }
        System.out.println("Se insertó " + dato + " (ahora es el último y apunta a la cabeza).");
    }

    // 3. Eliminar un elemento (simplificado: eliminar la "cabeza" lógica)
    // Para una eliminación general se necesitaría buscar y manejar el predecesor.
    public void eliminarCabezaLogica() {
        if (estaVacia()) {
            System.out.println("No se puede eliminar, la lista está vacía.");
            return;
        }
        int datoEliminado;
        if (this.ultimo.siguiente == this.ultimo) { // Solo hay un nodo
            datoEliminado = this.ultimo.dato;
            this.ultimo = null;
        } else {
            Nodo cabezaLogica = this.ultimo.siguiente;
            datoEliminado = cabezaLogica.dato;
            this.ultimo.siguiente = cabezaLogica.siguiente; // El último apunta al que seguía a la cabeza
            // cabezaLogica queda sin referencia y será recolectado
        }
        System.out.println("Se eliminó la cabeza lógica: " + datoEliminado);
    }

    // 4. Mostrar los elementos de la lista
    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista circular está vacía.");
            return;
        }
        System.out.print("Elementos de la lista circular: ");
        Nodo actual = this.ultimo.siguiente; // Empezamos por la cabeza lógica
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != this.ultimo.siguiente); // Recorremos hasta volver a la cabeza
        System.out.println("(vuelve a " + this.ultimo.siguiente.dato + ")");
    }

    public static void main(String[] args) {
        ListaCircularSimplementeEnlazada miListaCircular = new ListaCircularSimplementeEnlazada();

        System.out.println("¿Lista vacía? " + miListaCircular.estaVacia());
        miListaCircular.mostrarLista();

        miListaCircular.insertar(10);
        miListaCircular.mostrarLista();
        miListaCircular.insertar(20);
        miListaCircular.mostrarLista();
        miListaCircular.insertar(30);
        miListaCircular.mostrarLista();

        System.out.println("\n--- Eliminando elementos ---");
        miListaCircular.eliminarCabezaLogica(); // Elimina el 10
        miListaCircular.mostrarLista();
        miListaCircular.eliminarCabezaLogica(); // Elimina el 20
        miListaCircular.mostrarLista();
        miListaCircular.eliminarCabezaLogica(); // Elimina el 30
        miListaCircular.mostrarLista(); // Debería estar vacía
        miListaCircular.eliminarCabezaLogica();
    }
}