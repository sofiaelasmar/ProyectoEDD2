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
 * Clase que representa un nodo de aminoácido con sus cadenas y abreviación.
 */
public class NodoAminoacido {
    String[] cadenas; // Array de cadenas que representan las tripletas
    String abreviacion; // Abre viación del aminoácido

    /**
     * Constructor que inicializa un nodo de aminoácido.
     * @param cadenas Array de cadenas que representan las tripletas.
     * @param abreviacion Abreviación del aminoácido.
     */
    public NodoAminoacido(String[] cadenas, String abreviacion) {
        this.cadenas = cadenas;
        this.abreviacion = abreviacion;
    }
}

