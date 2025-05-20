/**
 * Implementación del algoritmo de Búsqueda Secuencial (o Lineal) en Java.
 * Este algoritmo busca un elemento comparándolo secuencialmente con cada
 * elemento del array hasta encontrarlo o llegar al final del array.
 * @author Adaptado de estructura_datos_profundizacion.pdf [cite: 11269]
 */
public class Secuencial {

    /**
     * Método principal para demostrar la búsqueda secuencial.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Array donde se realizará la búsqueda. [cite: 11268]
        int[] numeros = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99};
        // Elemento a buscar. [cite: 11268]
        int elementoBuscado = 67;

        System.out.println("Array original:");
        imprimirArray(numeros);
        System.out.println("Elemento a buscar: " + elementoBuscado);

        // Llama al método de búsqueda lineal.
        int indiceEncontrado = busquedaLineal(numeros, elementoBuscado);

        // Imprime el resultado. [cite: 11267, 11268]
        imprimirResultado(elementoBuscado, indiceEncontrado);

        // Prueba con un elemento que no está en el array
        elementoBuscado = 100;
        System.out.println("\nElemento a buscar: " + elementoBuscado);
        indiceEncontrado = busquedaLineal(numeros, elementoBuscado);
        imprimirResultado(elementoBuscado, indiceEncontrado);
    }

    /**
     * Realiza una búsqueda lineal en un array.
     * @param array El array donde buscar.
     * @param elementoABuscar El elemento que se busca.
     * @return El índice del elemento si se encuentra, -1 en caso contrario. [cite: 11265]
     */
    public static int busquedaLineal(int[] array, int elementoABuscar) {
        // Recorre el array desde el inicio hasta el final. [cite: 11264]
        for (int indice = 0; indice < array.length; indice++) {
            // Compara el elemento actual del array con el elemento buscado. [cite: 11264]
            if (array[indice] == elementoABuscar) {
                // Si son iguales, retorna el índice actual. [cite: 11264]
                return indice;
            }
        }
        // Si el bucle termina sin encontrar el elemento, retorna -1. [cite: 11265]
        return -1;
    }

     /**
     * Imprime si el elemento fue encontrado y en qué posición.
     * @param elementoBuscado El elemento que se buscó.
     * @param indice El índice donde se encontró o -1 si no se encontró. [cite: 11267]
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