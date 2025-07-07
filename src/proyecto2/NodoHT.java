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
 * Clase que representa un nodo en la tabla hash.
 */
public class NodoHT {
    String secuencia; // Secuencia de ADN
    int frecuencia; // Frecuencia de la secuencia
    int[] apariciones; // Array de posiciones donde aparece la secuencia
    int tamañoActual; // Tamaño actual del array de apariciones

    /**
     * Constructor que inicializa un nodo HT.
     * @param sec Secuencia de ADN.
     */
    public NodoHT(String sec) {
        this.secuencia = sec;
        this.frecuencia = 1; // Inicializa la frecuencia en 1
        this.apariciones = new int[100]; // Inicializa el array de apariciones
        this.tamañoActual = 0; // Inicializa el tamaño actual
    }

    /**
     * Agrega una aparición de la secuencia en una posición dada.
     * @param posicion Posición donde aparece la secuencia.
     */
    public void agregarAparicion(int posicion) {
        if (tamañoActual >= apariciones.length) {
            int[] nuevoArreglo = new int[apariciones.length * 2];  
            System.arraycopy(apariciones, 0, nuevoArreglo, 0, apariciones.length);
            apariciones = nuevoArreglo; // Duplica el tamaño del array si es necesario
        }
        apariciones[tamañoActual] = posicion; // Agrega la posición
        tamañoActual++; // Incrementa el tamaño actual
    }

    /**
     * Genera una representación en String de las apariciones.
     * @return String formateado con las apariciones.
     */
    public String aparicionesToString() {
        if (tamañoActual == 0) {
            return "[]";
        }
        
        StringBuilder resultado = new StringBuilder("[");
        resultado.append(apariciones[0]); 
        
        for (int i = 1; i < tamañoActual; i++) {
            resultado.append(", ").append(apariciones[i]);
        }
        
        resultado.append("]");
        return resultado.toString();
    }
}

