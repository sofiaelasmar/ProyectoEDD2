/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author iker
 */
import java.util.ArrayList;
import java.util.List;

public class BST {
    private NodoBST root;

    public BST() {
        this.root = null;
    }

    public void insert(int frecuencia, String cadena) {
        root = insertRec(root, frecuencia, cadena);
    }

    private NodoBST insertRec(NodoBST root, int frecuencia, String cadena) {
        if (root == null) {
            return new NodoBST(frecuencia, cadena);
        }

        if (frecuencia <= root.frecuencia && !root.cadena.equals(cadena)) {
            root.left = insertRec(root.left, frecuencia, cadena);
        } else if (frecuencia > root.frecuencia && !root.cadena.equals(cadena)) {
            root.right = insertRec(root.right, frecuencia, cadena);
        } else {
            root.cadena = cadena; 
        }

        return root;
    }

    public NodoBST search(int frecuencia) {
        return searchRec(root, frecuencia);
    }

    private NodoBST searchRec(NodoBST root, int frecuencia) {
        if (root == null || root.frecuencia == frecuencia) {
            return root;
        }

        if (frecuencia <= root.frecuencia) {
            return searchRec(root.left, frecuencia);
        }

        return searchRec(root.right, frecuencia);
    }

public NodoBST[] inorderArray() {
    int size = countNodes(root);
    NodoBST[] result = new NodoBST[size];
    inorderArrayRec(root, result, new int[]{0});
    return result;
}

private int countNodes(NodoBST node) {
    if (node == null) {
        return 0;
    }
    return 1 + countNodes(node.left) + countNodes(node.right);
}

private void inorderArrayRec(NodoBST node, NodoBST[] array, int[] index) {
    if (node != null) {
        inorderArrayRec(node.left, array, index);
        array[index[0]++] = node;
        inorderArrayRec(node.right, array, index);
    }
}

    public NodoBST findMaxFrequent() {
        return findMaxRec(root);
    }

    private NodoBST findMaxRec(NodoBST root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return findMaxRec(root.right);
    }

    public NodoBST findMinFrequent() {
        return findMinRec(root);
    }

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
