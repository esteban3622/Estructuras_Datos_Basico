/**
 * Implementación del algoritmo de Búsqueda Binaria en Java.
 * Este algoritmo busca un elemento en un array *ordenado*.
 * Compara el elemento buscado con el elemento central del array.
 * Si no son iguales, la mitad en la que el elemento no puede estar es eliminada
 * y la búsqueda continúa en la mitad restante hasta encontrar el elemento o
 * hasta que el subarray restante esté vacío.
 * @author Adaptado de estructura_datos_profundizacion.pdf [cite: 11277]
 */
public class Binaria {

    /**
     * Método principal para demostrar la búsqueda binaria.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Array donde se realizará la búsqueda. Debe estar ORDENADO. [cite: 11270]
        int[] numeros = {3, 22, 27, 47, 57, 67, 89, 91, 95, 99}; // Ya ordenado
        // O si empezara desordenado:
        // int[] numerosDesordenados = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        // Arrays.sort(numerosDesordenados); // Ordenamos primero
        // int[] numeros = numerosDesordenados;

        // Elemento a buscar. [cite: 11277]
        int elementoBuscado = 67;

        System.out.println("Array original (ordenado):");
        imprimirArray(numeros);
        System.out.println("Elemento a buscar: " + elementoBuscado);

        // Llama al método de búsqueda binaria.
        int indiceEncontrado = busquedaBinaria(numeros, elementoBuscado);

        // Imprime el resultado. [cite: 11276, 11277]
        imprimirResultado(elementoBuscado, indiceEncontrado);

        // Prueba con un elemento que no está en el array
        elementoBuscado = 50;
        System.out.println("\nElemento a buscar: " + elementoBuscado);
        indiceEncontrado = busquedaBinaria(numeros, elementoBuscado);
        imprimirResultado(elementoBuscado, indiceEncontrado);
    }

    /**
     * Realiza una búsqueda binaria en un array *ordenado*.
     * @param array El array ordenado donde buscar.
     * @param elementoABuscar El elemento que se busca.
     * @return El índice del elemento si se encuentra, -1 en caso contrario. [cite: 11274]
     */
    public static int busquedaBinaria(int[] array, int elementoABuscar) {
        // Índice inicial del subarray de búsqueda (al principio, todo el array). [cite: 11273]
        int indiceIzquierdo = 0;
        // Índice final del subarray de búsqueda. [cite: 11273]
        int indiceDerecho = array.length - 1;

        // Bucle mientras el índice izquierdo sea menor o igual al derecho. [cite: 11273]
        // Si izquierdo > derecho, el subarray está vacío y el elemento no se encontró.
        while (indiceIzquierdo <= indiceDerecho) {
            // Calcula el índice medio del subarray actual. [cite: 11273]
            // Se usa esta fórmula para evitar desbordamiento si izquierdo y derecho son muy grandes.
            int indiceMedio = indiceIzquierdo + (indiceDerecho - indiceIzquierdo) / 2;

            // Compara el elemento en el índice medio con el elemento buscado.
            // Caso 1: El elemento medio es el buscado. [cite: 11273]
            if (array[indiceMedio] == elementoABuscar) {
                return indiceMedio; // Elemento encontrado, retorna su índice.
            }
            // Caso 2: El elemento medio es mayor que el buscado. [cite: 11274]
            else if (array[indiceMedio] > elementoABuscar) {
                // El elemento buscado (si existe) debe estar en la mitad izquierda.
                // Ajusta el índice derecho para descartar la mitad derecha.
                indiceDerecho = indiceMedio - 1;
            }
            // Caso 3: El elemento medio es menor que el buscado. [cite: 11274]
            else {
                // El elemento buscado (si existe) debe estar en la mitad derecha.
                // Ajusta el índice izquierdo para descartar la mitad izquierda.
                indiceIzquierdo = indiceMedio + 1;
            }
             // Opcional: Imprimir el rango de búsqueda en cada iteración
             System.out.println("Buscando en el rango: [" + indiceIzquierdo + ", " + indiceDerecho + "]");
        }

        // Si el bucle termina, el elemento no se encontró en el array. [cite: 11274]
        return -1;
    }

     /**
     * Imprime si el elemento fue encontrado y en qué posición.
     * @param elementoBuscado El elemento que se buscó.
     * @param indice El índice donde se encontró o -1 si no se encontró. [cite: 11276]
     */
    public static void imprimirResultado(int elementoBuscado, int indice) {
        if (indice != -1) {
            System.out.println(elementoBuscado + " encontrado en el índice: " + indice);
        } else {
            System.out.println(elementoBuscado + " no encontrado.");
        }
    }

    /**
     * Método auxiliar para imprimir los elementos de un array.
     * @param array El array de enteros a imprimir.
     */
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? ", " : "")); // Añade coma excepto al final
        }
        System.out.println(); // Salto de línea al final
    }
}