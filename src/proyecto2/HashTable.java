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

    public HashTable() {
        this.secuencias = new NodoHT[64];
        this.size = 64;
    }

    public int hash(String secuencia) {
        int primo = 31;
        int hash = 0;

        for (int i = 0; i < secuencia.length(); i++) {
            char c = secuencia.charAt(i);
            int charValue = switch (c) {
                case 'A' ->
                    1;
                case 'T' ->
                    2;
                case 'C' ->
                    3;
                case 'G' ->
                    4;
                default ->
                    0;
            };
            hash = primo * hash + charValue;
        }

        return hash;
    }

    public NodoHT buscar(String secuencia) {
        int indice = this.hash(secuencia);
        NodoHT nodo = this.secuencias[indice];
        if (nodo != null) {
            if (nodo.secuencia.equals(secuencia)) {
                nodo.frecuencia += 1;
            }
        }
        return nodo;
    }

    public void añadir(String secuencia) {
        NodoHT nodo = this.buscar(secuencia);
        if (nodo == null) {
            int indice = this.hash(secuencia);
            this.secuencias[indice] = new NodoHT(secuencia);

        }
    }

}
