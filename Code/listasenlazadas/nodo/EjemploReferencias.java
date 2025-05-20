package nodo;

public class EjemploReferencias {

    public static void main(String[] args) {
        // 1. Creando objetos y asignando referencias
        System.out.println("--- Creando objetos y referencias ---");
        Caja cajaOriginal = new Caja(10); // Se crea un objeto Caja en memoria,
                                          // y 'cajaOriginal' guarda su dirección (referencia).
        Caja otraCaja = cajaOriginal; // 'otraCaja' NO crea un nuevo objeto.
                                      // Ahora 'otraCaja' guarda LA MISMA dirección que 'cajaOriginal'.
                                      // Ambas referencias apuntan al MISMO objeto.
        System.out.println(cajaOriginal.valor);
        System.out.println(otraCaja.valor);

        System.out.println("Referencia de cajaOriginal:" + cajaOriginal);
        System.out.println("Referencia de otraCaja:" + otraCaja);
        
        System.out.print("cajaOriginal: ");
        cajaOriginal.mostrarValor();
        System.out.print("otraCaja: ");
        otraCaja.mostrarValor();
        
        // 2. Modificando el objeto a través de una de las referencias
        System.out.println("\n--- Modificando el objeto ---");
        otraCaja.valor = 20; // Modificamos el valor del ÚNICO objeto existente.
        
        System.out.print("cajaOriginal después de modificar otraCaja: ");
        cajaOriginal.mostrarValor(); // Veremos que también cambió, porque apuntan al mismo objeto.
        System.out.print("otraCaja después de modificarla: ");
        otraCaja.mostrarValor();
        
        // 3. Haciendo que una referencia apunte a un nuevo objeto
        System.out.println("\n--- 'otraCaja' apunta a un nuevo objeto ---");
        otraCaja = new Caja(30); // Ahora 'otraCaja' apunta a un NUEVO objeto Caja.
        // 'cajaOriginal' sigue apuntando al objeto inicial (que ahora tiene valor 20).
        
        System.out.println("Referencia de cajaOriginal:" + cajaOriginal);
        System.out.println("Referencia de otraCaja:" + otraCaja);
        
        System.out.print("cajaOriginal: ");
        cajaOriginal.mostrarValor();
        System.out.print("otraCaja (nuevo objeto): ");
        otraCaja.mostrarValor();

        // 4. Asignando null a una referencia
        System.out.println("\n--- Asignando null ---");
        Caja cajaTemporal = new Caja(50);
        System.out.print("cajaTemporal antes de null: ");
        cajaTemporal.mostrarValor();

        cajaTemporal = null; // 'cajaTemporal' ya no apunta a ningún objeto.
                             // El objeto Caja con valor 50, si no hay OTRA referencia apuntándolo,
                             // se volverá elegible para el recolector de basura.

        // Si intentamos usar cajaTemporal ahora, obtendríamos un NullPointerException
        // System.out.print("cajaTemporal después de null: ");
        // cajaTemporal.mostrarValor(); // Esto daría error
        System.out.println("cajaTemporal ahora es null.");

    }
}
