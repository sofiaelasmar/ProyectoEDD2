/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author iker
 */
/**
 * Clase que representa un nodo en un árbol binario de búsqueda (BST).
 */
public class NodoBST {
    int frecuencia; // Frecuencia del nodo
    String cadena; // Cadena asociada al nodo
    NodoBST left; // Hijo izquierdo
    NodoBST right; // Hijo derecho
    int[] apariciones; // Array de posiciones donde aparece la cadena

    /**
     * Constructor que inicializa un nodo BST.
     * @param f Frecuencia del nodo.
     * @param c Cadena asociada al nodo.
     */
    public NodoBST(int f, String c) {
        this.cadena = c;
        this.frecuencia = f;
        this.left = this.right = null;
        this.apariciones = new int[100]; // Inicializa el array de apariciones
    }
}
