/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author iker
 */
public class BST {
    private NodoBST root;

    public BST() {
        this.root = null;
    }

    // Método para insertar un nuevo nodo en el BST
    public void insert(int frecuencia, String cadena) {
        root = insertRec(root, frecuencia, cadena);
    }

    private NodoBST insertRec(NodoBST root, int frecuencia, String cadena) {
        if (root == null) {
            root = new NodoBST(frecuencia, cadena);
            return root;
        }

        if (cadena.compareTo(root.cadena) < 0) {
            root.left = insertRec(root.left, frecuencia, cadena);
        } else if (cadena.compareTo(root.cadena) > 0) {
            root.right = insertRec(root.right, frecuencia, cadena);
        } else {
            // Si el patrón ya existe, actualizamos la frecuencia
            root.frecuencia += frecuencia;
        }

        return root;
    }

    // Método para buscar un patrón en el BST
    public NodoBST search(String cadena) {
        return searchRec(root, cadena);
    }

    private NodoBST searchRec(NodoBST root, String cadena) {
        if (root == null || root.cadena.equals(cadena)) {
            return root;
        }

        if (cadena.compareTo(root.cadena) < 0) {
            return searchRec(root.left, cadena);
        }

        return searchRec(root.right, cadena);
    }

    // Método para listar todos los patrones en orden
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(NodoBST root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("Patrón: " + root.cadena + ", Frecuencia: " + root.frecuencia);
            inorderRec(root.right);
        }
    }

    // Método para encontrar el patrón más frecuente
    public NodoBST findMaxFrequent() {
        return findMaxFrequentRec(root);
    }

    private NodoBST findMaxFrequentRec(NodoBST root) {
        if (root == null) {
            return null;
        }

        NodoBST leftMax = findMaxFrequentRec(root.left);
        NodoBST rightMax = findMaxFrequentRec(root.right);

        NodoBST maxNode = root;

        if (leftMax != null && leftMax.frecuencia > maxNode.frecuencia) {
            maxNode = leftMax;
        }
        if (rightMax != null && rightMax.frecuencia > maxNode.frecuencia) {
            maxNode = rightMax;
        }

        return maxNode;
    }

    // Método para encontrar el patrón menos frecuente
    public NodoBST findMinFrequent() {
        return findMinFrequentRec(root);
    }

    private NodoBST findMinFrequentRec(NodoBST root) {
        if (root == null) {
            return null;
        }

        NodoBST leftMin = findMinFrequentRec(root.left);
        NodoBST rightMin = findMinFrequentRec(root.right);

        NodoBST minNode = root;

        if (leftMin != null && leftMin.frecuencia < minNode.frecuencia) {
            minNode = leftMin;
        }
        if (rightMin != null && rightMin.frecuencia < minNode.frecuencia) {
            minNode = rightMin;
        }

        return minNode;
    }
}

