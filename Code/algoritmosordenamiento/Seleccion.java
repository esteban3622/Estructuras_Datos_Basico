package algoritmosordenamiento;
/**
 * Implementación del algoritmo de ordenamiento por Selección en Java.
 * Este algoritmo divide la lista en dos partes: una sublista ordenada que se
 * construye de izquierda a derecha y una sublista desordenada con los elementos
 * restantes. Inicialmente, la sublista ordenada está vacía.
 * En cada paso, encuentra el elemento mínimo en la sublista desordenada y
 * lo intercambia con el primer elemento de la sublista desordenada.
 * @author Adaptado de estructura_datos_profundizacion.pdf [cite: 11259]
 */
public class Seleccion {

    /**
     * Método principal para demostrar el ordenamiento por selección.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Array inicial de números desordenados. [cite: 11252]
        int[] numeros = {2, 2, 4, 7, 1, 3, 5, 7};
        // Variables para índices, el menor elemento encontrado y su posición. [cite: 11252]
        int i, j, indiceMenor, temporal;

        System.out.println("Array inicial:");
        // Imprime el array original. [cite: 11253]
        imprimirArray(numeros);

        System.out.println("\nOrdenando por Selección...");

        // Bucle externo: recorre el array para colocar el elemento correcto en cada posición i. [cite: 11256]
        // Se detiene en el penúltimo elemento, ya que el último quedará ordenado automáticamente.
        for (i = 0; i < numeros.length - 1; i++) {
            // Asume que el elemento actual (en la posición i) es el menor del subarray desordenado. [cite: 11256]
            indiceMenor = i;

            // Bucle interno: busca el elemento realmente menor en el resto del array (desde i+1). [cite: 11256]
            for (j = i + 1; j < numeros.length; j++) {
                // Si encuentra un elemento menor que el actual 'menor'... [cite: 11256]
                if (numeros[j] < numeros[indiceMenor]) {
                    // ...actualiza el índice del menor. [cite: 11256]
                    indiceMenor = j;
                }
            }

            // Si el índice del menor encontrado es diferente del índice actual i... [cite: 11256]
            // (esto significa que el elemento en i no era el menor del subarray desordenado)
            if (indiceMenor != i) {
                // ...intercambia el elemento actual (en i) con el menor encontrado (en indiceMenor). [cite: 11256]
                temporal = numeros[i];
                numeros[i] = numeros[indiceMenor];
                numeros[indiceMenor] = temporal;
            }

            // Opcional: Imprimir el estado del array después de colocar el elemento i
             System.out.print("Después de colocar el elemento en la posición " + i + ": ");
             imprimirArray(numeros);
        }

        System.out.println("\nArray Ordenado (Selección):");
        // Imprime el array ordenado. [cite: 11256]
        imprimirArray(numeros);
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