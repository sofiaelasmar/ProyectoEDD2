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
    
    
    public HashTable(){
        this.secuencias = new NodoHT[64];
        this.size = 64;
    }
}
