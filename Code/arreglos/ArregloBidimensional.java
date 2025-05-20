public class ArregloBidimensional {
    public static void main(String[] args) {
        // Declara una matriz de Strings con 2 filas y 4 columnas
        String[][] MiSegundoArreglo = new String[2][4];

        // Asigna valores usando [fila][columna] (índices desde 0)
        MiSegundoArreglo[0][0] = "Dato 1"; // Fila 0, Columna 0
        MiSegundoArreglo[0][1] = "Dato 2";
        MiSegundoArreglo[0][2] = "Dato 3";
        MiSegundoArreglo[0][3] = "Dato 4";

        MiSegundoArreglo[1][0] = "Dato 5"; // Fila 1, Columna 0
        MiSegundoArreglo[1][1] = "Dato 6";
        MiSegundoArreglo[1][2] = "Dato 7";
        MiSegundoArreglo[1][3] = "Dato 8";

        // Para acceder al elemento en la Fila 1, Columna 2:
        String datoEspecifico = MiSegundoArreglo[1][3]; // datoEspecifico contendrá "Dato 7"
        System.out.println(datoEspecifico);
    }
}
