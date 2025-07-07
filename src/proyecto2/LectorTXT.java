/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author iker
 */
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorTXT {

    private HashTable hashTable; // Tabla hash para almacenar las secuencias
    private BST bstFrecuencias; // Árbol binario de búsqueda para frecuencias

    public LectorTXT() {
        this.hashTable = new HashTable();
        this.bstFrecuencias = new BST();
    }

    /**
     * Método para cargar un archivo de texto y procesar la secuencia de ADN.
     */
    public void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    procesarSecuencia(linea.trim());
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    /**
     * Método para procesar la secuencia de ADN y añadir fragmentos a la tabla
     * hash y al BST.
     *
     * @param secuencia La secuencia de ADN a procesar.
     */
    private void procesarSecuencia(String secuencia) {
        int j = 0;
        for (int i = 0; i <= secuencia.length() - 3; i+=3) {
            String fragmento = secuencia.substring(i, i + 3);
            hashTable.añadir(fragmento, j);
            j++;
        }
        for (int i = 0; i < hashTable.size; i++) {
            try {
                this.bstFrecuencias.insert(hashTable.secuencias[i].frecuencia, hashTable.secuencias[i].secuencia);
            } catch (Exception e) {
                continue;
            }
        }
hashTable.imprimirFrecuenciaTotal();
    }

    /**
     * Método para obtener la tabla hash.
     *
     * @return La tabla hash de secuencias.
     */
    public HashTable getHashTable() {
        return hashTable;
    }

    /**
     * Método para obtener el árbol de frecuencias.
     *
     * @return El árbol binario de búsqueda de frecuencias.
     */
    public BST getBstFrecuencias() {
        return bstFrecuencias;
    }
}
