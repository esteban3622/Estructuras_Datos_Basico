package algoritmosordenamiento;
/**
 * Implementación del algoritmo de ordenamiento Burbuja en Java.
 * Este algoritmo revisa repetidamente la lista, comparando elementos adyacentes
 * e intercambiándolos si están en el orden incorrecto.
 * @author Adaptado de estructura_datos_profundizacion.pdf [cite: 11234]
 */
public class Burbuja {

    /**
     * Método principal para demostrar el ordenamiento burbuja.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Array inicial de números desordenados. [cite: 11226]
        int[] numeros = {2, 2, 4, 7, 1, 3, 5, 7};
        // Variable temporal para el intercambio. [cite: 11226]
        int temporal;

        System.out.println("Array inicial:");
        // Imprime el array original. [cite: 11227, 11235]
        imprimirArray(numeros);

        System.out.println("\nOrdenando con Burbuja...");

        // Bucle externo: controla el número de pasadas sobre el array. [cite: 11228, 11236]
        // En cada pasada, el elemento más grande "burbujea" hasta su posición final.
        // Por eso, en cada pasada i, no necesitamos comparar el último i elementos.
        for (int i = 0; i < numeros.length - 1; i++) {
            // Bucle interno: compara elementos adyacentes. [cite: 11228, 11236]
            // Compara numeros[j] con numeros[j+1].
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente... [cite: 11228, 11230, 11236, 11237]
                if (numeros[j] > numeros[j + 1]) {
                    // ...intercambia los elementos usando la variable temporal. [cite: 11230, 11237]
                    temporal = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temporal;
                }
            }
             // Opcional: Imprimir el estado del array después de cada pasada externa
             System.out.print("Después de la pasada " + (i + 1) + ": ");
             imprimirArray(numeros);
        }

        System.out.println("\nArray Ordenado (Burbuja):");
        // Imprime el array ordenado. [cite: 11231, 11238]
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