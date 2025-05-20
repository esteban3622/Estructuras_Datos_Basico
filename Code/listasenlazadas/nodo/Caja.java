package nodo;

// Definimos una clase simple llamada Caja
class Caja {
    public int valor; // Un atributo para guardar un entero

    // Constructor para inicializar la Caja con un valor
    public Caja(int valor) {
        this.valor = valor;
        System.out.println("Se creó una Caja con valor: " + this.valor);
    }

    public void mostrarValor() {
        System.out.println("El valor de esta Caja es: " + this.valor);
    }
}

