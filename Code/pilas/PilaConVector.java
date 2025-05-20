package pilas;

public class PilaConVector {

    private int[] arregloPila; // Usaremos un arreglo de enteros para almacenar los elementos
    private int cima; // Este índice indicará la posición del último elemento (la cima)
    private int capacidad; // El tamaño máximo de la pila

    // Constructor: Define el tamaño máximo de la pila
    public PilaConVector(int tamano) {
        this.capacidad = tamano;
        this.arregloPila = new int[capacidad];
        this.cima = -1; // Inicializamos cima en -1 para indicar que la pila está vacía
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        // Si cima es -1, no hay elementos en la pila
        return (cima == -1);
    }

    // Método para verificar si la pila está llena
    public boolean estaLlena() {
        // Si cima alcanzó el último índice válido (capacidad - 1), la pila está llena
        return (cima == capacidad - 1);
    }

    // Método para añadir un elemento a la cima de la pila (Push)
    public void push(int elemento) {
        // 1. Verificar si la pila ya está llena (Overflow)
        if (estaLlena()) {
            System.out.println("Error: La pila está llena. No se puede añadir " + elemento);
            // Opcional: lanzar una excepción aquí
            return;
        }

        // 2. Incrementar el índice 'cima'
        cima++;

        // 3. Colocar el nuevo elemento en la posición indicada por 'cima'
        arregloPila[cima] = elemento;

        System.out.println(elemento + " añadido a la pila.");
    }

    // Método para eliminar y retornar el elemento de la cima (Pop)
    public int pop() {
        // 1. Verificar si la pila está vacía (Underflow)
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía. No se puede eliminar.");
            // Opcional: lanzar una excepción o retornar un valor especial (como -1 o null si fuera un objeto)
            return -1; // Retornamos -1 como indicador de error en este ejemplo simple
        }

        // 2. Obtener el elemento que está en la cima actual
        int elementoCima = arregloPila[cima];

        // 3. Decrementar el índice 'cima'
        // (Conceptualmente, esto remueve el elemento de la pila, aunque el valor siga en el arreglo)
        cima--;

        // 4. Retornar el elemento obtenido
        System.out.println(elementoCima + " eliminado de la pila.");
        return elementoCima;
    }

    // Método para ver el elemento de la cima sin eliminarlo (Peek)
    public int peek() {
        // 1. Verificar si la pila está vacía
        if (estaVacia()) {
            System.out.println("Error: La pila está vacía. No hay elemento en la cima.");
            return -1; // Indicador de error
        }

        // 2. Retornar el elemento en la posición 'cima'
        return arregloPila[cima];
    }

    // Método principal para demostrar el uso de la Pila
    public static void main(String[] args) {
        // Creamos una pila con capacidad máxima de 5 elementos
        PilaConVector miPila = new PilaConVector(5);

        System.out.println("¿Está la pila vacía al inicio? " + miPila.estaVacia()); // Debería ser true

        // --- PASO A PASO: Operaciones Push ---
        System.out.println("\n--- Realizando operaciones Push ---");
        miPila.push(10); // cima = 0, arregloPila: [10, _, _, _, _]
        miPila.push(20); // cima = 1, arregloPila: [10, 20, _, _, _]
        miPila.push(30); // cima = 2, arregloPila: [10, 20, 30, _, _]
        miPila.push(40); // cima = 3, arregloPila: [10, 20, 30, 40, _]
        miPila.push(50); // cima = 4, arregloPila: [10, 20, 30, 40, 50]

        System.out.println("Elemento en la cima: " + miPila.peek()); // Debería ser 50
        System.out.println("¿Está la pila llena? " + miPila.estaLlena()); // Debería ser true

        // Intentar añadir un elemento más (debería mostrar error de pila llena)
        miPila.push(60);

        // --- PASO A PASO: Operaciones Pop ---
        System.out.println("\n--- Realizando operaciones Pop ---");
        miPila.pop(); // cima = 3. Elimina 50. arregloPila: [10, 20, 30, 40, 50(dato antiguo)]
        // miPila.push(60);
        System.out.println("Elemento en la cima después de pop: " + miPila.peek()); // Debería ser 40

        miPila.pop(); // cima = 2. Elimina 40.
        System.out.println("Elemento en la cima después de pop: " + miPila.peek()); // Debería ser 30

        miPila.pop(); // cima = 1. Elimina 30.
        miPila.pop(); // cima = 0. Elimina 20.
        miPila.pop(); // cima = -1. Elimina 10.

        System.out.println("¿Está la pila vacía después de pops? " + miPila.estaVacia()); // Debería ser true

        // Intentar eliminar un elemento más (debería mostrar error de pila vacía)
        miPila.pop();
    }
}