public class ArreglosUnidimensionales {
    public static void main(String[] args) {
        // Declara un arreglo de Strings llamado MiPrimerArreglo con 5 posiciones
        String[] MiPrimerArreglo = new String[5];

        // Asigna valores a cada posición usando su índice (0 a 4)
        MiPrimerArreglo[0] = "Dato 1";
        MiPrimerArreglo[1] = "Dato 2";
        MiPrimerArreglo[2] = "Dato 3";
        MiPrimerArreglo[3] = "Dato 4";
        MiPrimerArreglo[4] = "Dato 5";

        // Para acceder al tercer elemento (índice 2):
        String tercerDato = MiPrimerArreglo[2]; // tercerDato contendrá "Dato 3"

        System.out.println(tercerDato);
    }
}
