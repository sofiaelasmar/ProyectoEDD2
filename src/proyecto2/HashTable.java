/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author sofia
 */
public class HashTable {

    NodoHT[] secuencias;
    int size;
    String[][] colisiones;

    public HashTable() {
        this.secuencias = new NodoHT[64];
        this.size = 64;
        this.colisiones = new String[size][size]; 
    }

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

    public void añadir(String secuencia) {
    int indice = this.hash(secuencia);
    
    NodoHT nodo = this.buscar(secuencia);
    
    if (nodo != null) {
       
        nodo.frecuencia += 1;
    } else {
        while (secuencias[indice] != null) {
            for (int j = 0; j < size; j++) {
                if (colisiones[indice][j] == null) {
                    colisiones[indice][j] = secuencias[indice].secuencia;
                    break;
                }
            }
            indice = (indice + 1) % size;
        }
        this.secuencias[indice] = new NodoHT(secuencia);
    }
}

    public String generarReporteColisiones() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE DE COLISIONES ===\n");
        reporte.append("Total de slots en tabla: ").append(size).append("\n");
        reporte.append("Se muestran solo los slots con colisiones\n\n");
        
        int totalColisiones = 0;
        
        for (int i = 0; i < size; i++) {
            int colisionesEnSlot = 0;
            StringBuilder entradasColisionadas = new StringBuilder();
            
            for (int j = 0; j < size; j++) {
                if (colisiones[i][j] != null) {
                    if (colisionesEnSlot > 0) {
                        entradasColisionadas.append(", ");
                    }
                    entradasColisionadas.append(colisiones[i][j]);
                    colisionesEnSlot++;
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

