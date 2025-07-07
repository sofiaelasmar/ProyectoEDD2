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
 * Clase que representa un árbol binario de búsqueda (BST) para almacenar frecuencias y cadenas.
 */
public class BST {
    private NodoBST root; // Nodo raíz del árbol

    /**
     * Constructor que inicializa el árbol vacío.
     */
    public BST() {
        this.root = null;
    }

    /**
     * Inserta un nuevo nodo en el árbol.
     * @param frecuencia Frecuencia del nodo a insertar.
     * @param cadena Cadena asociada al nodo.
     */
    public void insert(int frecuencia, String cadena) {
        root = insertRec(root, frecuencia, cadena);
    }

    /**
     * Método recursivo para insertar un nodo en el árbol.
     * @param root Nodo actual en el árbol.
     * @param frecuencia Frecuencia del nodo a insertar.
     * @param cadena Cadena asociada al nodo.
     * @return Nodo actualizado.
     */
    private NodoBST insertRec(NodoBST root, int frecuencia, String cadena) {
        if (root == null) {
            return new NodoBST(frecuencia, cadena);
        }

        if (frecuencia <= root.frecuencia && !root.cadena.equals(cadena)) {
            root.left = insertRec(root.left, frecuencia, cadena);
        } else if (frecuencia > root.frecuencia && !root.cadena.equals(cadena)) {
            root.right = insertRec(root.right, frecuencia, cadena);
        } else {
            root.frecuencia += 1; // Incrementa la frecuencia si la cadena ya existe
        }

        return root;
    }

    /**
     * Busca un nodo en el árbol por frecuencia.
     * @param frecuencia Frecuencia a buscar.
     * @return Nodo encontrado o null.
     */
    public NodoBST search(int frecuencia) {
        return searchRec(root, frecuencia);
    }

    /**
     * Método recursivo para buscar un nodo en el árbol.
     * @param root Nodo actual en el árbol.
     * @param frecuencia Frecuencia a buscar.
     * @return Nodo encontrado o null.
     */
    private NodoBST searchRec(NodoBST root, int frecuencia) {
        if (root == null || root.frecuencia == frecuencia) {
            return root;
        }

        if (frecuencia <= root.frecuencia) {
            return searchRec(root.left, frecuencia);
        }

        return searchRec(root.right, frecuencia);
    }

    /**
     * Convierte el árbol en un array en orden.
     * @return Array de nodos en orden.
     */
    public NodoBST[] inorderArray() {
        int size = countNodes(root);
        NodoBST[] result = new NodoBST[size];
        inorderArrayRec(root, result, new int[]{0});
        return result;
    }

    /**
     * Cuenta el número de nodos en el árbol.
     * @param node Nodo actual.
     * @return Número de nodos.
     */
    private int countNodes(NodoBST node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    /**
     * Método recursivo para llenar un array con los nodos en orden.
     * @param node Nodo actual.
     * @param array Array donde se almacenan los nodos.
     * @param index Índice actual en el array.
     */
    private void inorderArrayRec(NodoBST node, NodoBST[] array, int[] index) {
        if (node != null) {
            inorderArrayRec(node.left, array, index);
            array[index[0]++] = node;
            inorderArrayRec(node.right, array, index);
        }
    }

    /**
     * Encuentra el nodo con la frecuencia máxima.
     * @return Nodo con la frecuencia máxima.
     */
    public NodoBST findMaxFrequent() {
        return findMaxRec(root);
    }

    /**
     * Método recursivo para encontrar el nodo con la frecuencia máxima.
     * @param root Nodo actual.
     * @return Nodo con la frecuencia máxima.
     */
    private NodoBST findMaxRec(NodoBST root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return findMaxRec(root.right);
    }

    /**
     * Encuentra el nodo con la frecuencia mínima.
     * @return Nodo con la frecuencia mínima.
     */
    public NodoBST findMinFrequent() {
        return findMinRec(root);
    }

    /**
     * Método recursivo para encontrar el nodo con la frecuencia mínima.
     * @param root Nodo actual.
     * @return Nodo con la frecuencia mínima.
     */
    private NodoBST findMinRec(NodoBST root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMinRec(root.left);
    }
}
