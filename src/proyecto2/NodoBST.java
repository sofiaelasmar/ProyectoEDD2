/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author iker
 */
public class NodoBST {
    int frecuencia;
    String cadena;
    NodoBST left;
    NodoBST right;
    public NodoBST(int f, String c){
        this.cadena = c;
        this.frecuencia = f;
        this.left = this.right = null;
    }
}
