package algoritmosordenamiento;
/**
 * Implementación del algoritmo de ordenamiento por Inserción en Java.
 * Este algoritmo construye la lista ordenada final un elemento a la vez.
 * Toma cada elemento del array de entrada y lo inserta en su posición correcta
 * dentro del subarray ya ordenado a la izquierda.
 * @author Adaptado de estructura_datos_profundizacion.pdf [cite: 11247]
 */
public class Insercion {

    /**
     * Método principal para demostrar el ordenamiento por inserción.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Array inicial de números desordenados. [cite: 11243]
        int[] numeros = {2, 2, 4, 7, 1, 3, 5, 7};
        // Variable auxiliar para guardar el elemento a insertar. [cite: 11248]
        int aux;
        // Variables para los índices. [cite: 11243]
        int i, j;

        System.out.println("Array inicial:");
        // Imprime el array original. [cite: 11244, 11248]
        imprimirArray(numeros);

        System.out.println("\nOrdenando por Inserción...");

        // Bucle externo: recorre el array desde el segundo elemento (índice 1). [cite: 11249]
        // Consideramos que el primer elemento (índice 0) ya forma un subarray ordenado.
        for (i = 1; i < numeros.length; i++) {
            // Guarda el elemento actual que queremos insertar en su lugar correcto. [cite: 11249]
            aux = numeros[i];
            // Inicializa j al índice del elemento anterior al actual. [cite: 11249]
            j = i - 1;

            // Bucle interno (while): desplaza los elementos mayores que 'aux' hacia la derecha. [cite: 11246, 11249]
            // Continúa mientras j sea válido (mayor o igual a 0) Y el elemento en numeros[j]
            // sea mayor que el elemento auxiliar ('aux') que estamos insertando.
            while (j >= 0 && numeros[j] > aux) {
                // Desplaza el elemento numeros[j] una posición a la derecha (a numeros[j+1]). [cite: 11249]
                numeros[j + 1] = numeros[j];
                // Decrementa j para comparar con el siguiente elemento a la izquierda. [cite: 11249]
                j--;
            }
            // Inserta el elemento auxiliar ('aux') en la posición correcta (j+1). [cite: 11246, 11249]
            // Esta es la posición donde el bucle while se detuvo, porque se encontró
            // un elemento menor o igual que 'aux', o se llegó al inicio del array.
            numeros[j + 1] = aux;

            // Opcional: Imprimir el estado del array después de insertar cada elemento
            System.out.print("Después de insertar " + aux + ": ");
            imprimirArray(numeros);
        }

        System.out.println("\nArray Ordenado (Inserción):");
        // Imprime el array ordenado.
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