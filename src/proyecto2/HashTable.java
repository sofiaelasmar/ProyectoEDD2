/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author sofia
 */
/**
 * Clase que implementa una tabla hash para almacenar secuencias de ADN.
 */
public class HashTable {
    public NodoHT[] secuencias; // Array de nodos que almacenan las secuencias
    public int size; // Tamaño de la tabla
    private String[][] colisiones; // Matriz para manejar colisiones

    /**
     * Constructor que inicializa la tabla hash.
     */
    public HashTable() {
        this.secuencias = new NodoHT[64];
        this.size = 64;
        this.colisiones = new String[size][size];
    }

    /**
     * Función hash para calcular el índice de una secuencia.
     * @param secuencia Secuencia a hashear.
     * @return Índice calculado.
     */
    public int hash(String secuencia) {
        int primo = 31;
        int hash = 0;

        for (int i = 0; i < secuencia.length(); i++) {
            char c = secuencia.charAt(i);
            int charValue = switch (c) {
                case 'A' -> 1;
                case 'T' -> 2;
                case 'C' -> 3;
                case 'G' -> 4;
                default -> 0;
            };
            hash = primo * hash + charValue;
        }

        return Math.abs(hash) % size;
    }

    /**
     * Busca una secuencia en la tabla hash.
     * @param secuencia Secuencia a buscar.
     * @return NodoHT encontrado o null.
     */
    public NodoHT buscar(String secuencia) {
        int indice = this.hash(secuencia);
        int originalIndex = indice;

        while (secuencias[indice] != null) {
            if (secuencias[indice].secuencia.equals(secuencia)) {
                return secuencias[indice];
            }
            indice = (indice + 1) % size;
            if (indice == originalIndex) {
                break;
            }
        }
        return null;
    }

    /**
     * Añade una secuencia a la tabla hash.
     * @param secuencia Secuencia a añadir.
     * @param index Índice de aparición.
     */
    public void añadir(String secuencia, int index) {
        int indice = this.hash(secuencia);

        NodoHT nodo = this.buscar(secuencia);

        if (nodo != null) {
            nodo.frecuencia += 1; // Incrementa la frecuencia si ya existe
            nodo.agregarAparicion(index);
        } else {
            while (secuencias[indice] != null) {
                indice = (indice + 1) % size; // Manejo de colisiones
            }
            this.secuencias[indice] = new NodoHT(secuencia);
            this.secuencias[indice].agregarAparicion(index);
        }
    }

    /**
     * Genera un reporte de colisiones en la tabla hash.
     * @return String con el reporte de colisiones.
     */
    public String generarReporteColisiones() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE DE COLISIONES ===\n");
        reporte.append("Total de slots en tabla: ").append(size).append("\n");
        reporte.append("Se muestran solo los slots con colisiones\n\n");

        int totalColisiones = 0;

        for (int i = 0; i < size; i++) {
            int colisionesEnSlot = 0;
            StringBuilder entradasColisionadas = new StringBuilder();

            if (secuencias[i] != null) {
                for (int j = 0; j < size; j++) {
                    if (secuencias[j] != null && j != i) {
                        if (hash(secuencias[j].secuencia) == i) {
                            if (colisionesEnSlot > 0) {
                                entradasColisionadas.append(", ");
                            }
                            entradasColisionadas.append(secuencias[j].secuencia);
                            colisionesEnSlot++;
                        }
                    }
                }
            }

            if (colisionesEnSlot > 0) {
                totalColisiones += colisionesEnSlot;
                reporte.append("Slot #").append(i).append(": ")
                        .append(colisionesEnSlot).append(" colisiones → ")
                        .append(entradasColisionadas.toString()).append("\n");
            }
        }

        reporte.append("\nTotal de colisiones registradas: ").append(totalColisiones).append("\n");
        reporte.append("=== FIN DEL REPORTE ===");

        return reporte.toString();
    }

    /**
     * Imprime la frecuencia total de todas las secuencias en la tabla.
     */
    public void imprimirFrecuenciaTotal() {
        int frecuenciaTotal = 0;

        // Recorrer el array de secuencias
        for (NodoHT nodo : secuencias) {
            if (nodo != null) {
                frecuenciaTotal += nodo.frecuencia; // Sumar la frecuencia de cada nodo
            }
        }

        // Imprimir la frecuencia total
        System.out.println("Frecuencia total de todas las secuencias: " + frecuenciaTotal);
    }
}
