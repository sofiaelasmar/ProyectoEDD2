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
 * Clase que representa un conjunto de aminoácidos y sus frecuencias.
 */
public class Aminoacidos {
    private HashTable hashTable; // Tabla hash para almacenar las secuencias
    private NodoAminoacido[] aminoAcidos; // Array de nodos de aminoácidos

    /**
     * Constructor que inicializa la clase con una tabla hash.
     * @param hashTable Tabla hash que contiene las secuencias.
     */
    public Aminoacidos(HashTable hashTable) {
        this.hashTable = hashTable;
        this.aminoAcidos = new NodoAminoacido[64];
        inicializarAminoAcidos(); // Inicializa los aminoácidos
    }

    /**
     * Método privado que inicializa los aminoácidos y sus tripletas.
     */
    private void inicializarAminoAcidos() {
        aminoAcidos[0] = new NodoAminoacido(new String[]{"UUU", "UUC"}, "Phe");
        aminoAcidos[1] = new NodoAminoacido(new String[]{"UUA", "UUG", "CUU", "CUC", "CUA", "CUG"}, "Leu");
        aminoAcidos[2] = new NodoAminoacido(new String[]{"UCU", "UCC", "UCA", "UCG", "AGU", "AGC"}, "Ser");
        aminoAcidos[3] = new NodoAminoacido(new String[]{"UAU", "UAC"}, "Tyr");
        aminoAcidos[4] = new NodoAminoacido(new String[]{"UAA", "UAG", "UGA"}, "STOP");
        aminoAcidos[5] = new NodoAminoacido(new String[]{"UGU", "UGC"}, "Cys");
        aminoAcidos[6] = new NodoAminoacido(new String[]{"UGG"}, "Trp");
        aminoAcidos[7] = new NodoAminoacido(new String[]{"CCU", "CCC", "CCA", "CCG"}, "Pro");
        aminoAcidos[8] = new NodoAminoacido(new String[]{"CAU", "CAC"}, "His");
        aminoAcidos[9] = new NodoAminoacido(new String[]{"CAA", "CAG"}, "Gln");
        aminoAcidos[10] = new NodoAminoacido(new String[]{"CGU", "CGC", "CGA", "CGG", "AGA", "AGG"}, "Arg");
        aminoAcidos[11] = new NodoAminoacido(new String[]{"AUU", "AUC", "AUA"}, "Ile");
        aminoAcidos[12] = new NodoAminoacido(new String[]{"AUG"}, "Met");
        aminoAcidos[13] = new NodoAminoacido(new String[]{"ACU", "ACC", "ACA", "ACG"}, "Thr");
        aminoAcidos[14] = new NodoAminoacido(new String[]{"AAU", "AAC"}, "Asn");
        aminoAcidos[15] = new NodoAminoacido(new String[]{"AAA", "AAG"}, "Lys");
        aminoAcidos[16] = new NodoAminoacido(new String[]{"GUU", "GUC", "GUA", "GUG"}, "Val");
        aminoAcidos[17] = new NodoAminoacido(new String[]{"GCU", "GCC", "GCA", "GCG"}, "Ala");
        aminoAcidos[18] = new NodoAminoacido(new String[]{"GAU", "GAC"}, "Asp");
        aminoAcidos[19] = new NodoAminoacido(new String[]{"GAA", "GAG"}, "Glu");
        aminoAcidos[20] = new NodoAminoacido(new String[]{"GGU", "GGC", "GGA", "GGG"}, "Gly");
    }

    /**
     * Genera un reporte de los aminoácidos y sus frecuencias.
     * @return Un String con el reporte de aminoácidos.
     */
    public String reporte() {
        StringBuilder reporte = new StringBuilder();

        for (int i = 0; i < aminoAcidos.length && aminoAcidos[i] != null; i++) {
            NodoAminoacido amino = aminoAcidos[i];
            reporte.append("Aminoácido: ").append(amino.abreviacion).append("\n");
            reporte.append("Tripletas: ");

            int frecuenciaTotal = 0;
            for (String tripleta : amino.cadenas) {
                NodoHT nodo = hashTable.buscar(tripleta);
                if (nodo != null) {
                    frecuenciaTotal += nodo.frecuencia;
                }
                reporte.append(tripleta).append(" ");
            }

            reporte.append("\nFrecuencia total: ").append(frecuenciaTotal).append("\n\n");
        }

        return reporte.toString();
    }

    /**
     * Calcula la frecuencia total de un aminoácido dado su abreviación.
     * @param abreviacion Abreviación del aminoácido.
     * @return Frecuencia total del aminoácido.
     */
    public int frecAminoacido(String abreviacion) {
        int frecuenciaTotal = 0;
        
        for (int i = 0; i < aminoAcidos.length && aminoAcidos[i] != null; i++) {
            if (aminoAcidos[i].abreviacion.equals(abreviacion)) {
                for (String tripleta : aminoAcidos[i].cadenas) {
                    NodoHT nodo = hashTable.buscar(tripleta);
                    if (nodo != null) {
                        frecuenciaTotal += nodo.frecuencia;
                    }
                }
                break;
            }
        }
        
        return frecuenciaTotal;
    }
}
