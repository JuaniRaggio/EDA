package com.solucionesEDA.datastructures;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Consumer;

public class BinaryTree implements BinaryTreeService {

    private Node root;

    private Scanner inputScanner;

    public BinaryTree(String fileName) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, FileNotFoundException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

        if (is == null)
            throw new FileNotFoundException(fileName);

        inputScanner = new Scanner(is);
        inputScanner.useDelimiter("\\s+");

        buildTree();

        inputScanner.close();
    }

    private void buildTree() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {

        Queue<NodeHelper> pendingOps = new LinkedList<>();
        String token;

        root = new Node();
        pendingOps.add(new NodeHelper(root, n -> {}));

        while (inputScanner.hasNext()) {

            token = inputScanner.next();

            NodeHelper aPendingOp = pendingOps.remove();
            Node currentNode = aPendingOp.getNode();

            if (token.equals("?")) {
                // no hace falta poner en null al L o R porque ya esta con null

                // reservar el espacio en Queue aunque NULL no tiene hijos para aparear
                pendingOps.add(new NodeHelper(null, n -> {})); // como si hubiera izq
                pendingOps.add(new NodeHelper(null, n -> {})); // como si hubiera der
            } else {
                aPendingOp.getAction().accept(currentNode);

                // armo la info del izq, der o el root
                currentNode.data = token;

                // hijos se postergan
                pendingOps.add(new NodeHelper(currentNode, n -> n = n.setLeftTree(new Node())));
                pendingOps.add(new NodeHelper(currentNode, n -> n = n.setRightTree(new Node())));
            }
        }

        if (root.data == null) // no entre al ciclo jamas
            root = null;

    }

    public void toFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {



            if (writer != null) {
                writer.close();
            }
            System.out.println("Archivo creado exitosamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean equals(BinaryTree bt) {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BinaryTree bt this.equals(bt);
    }

    public int getHeight() {
        int counter = 0;
        return counter;
    }

    @Override
    public void preorder() {
        // COMPLETE
    }

    @Override
    public void postorder() {
        // COMPLETE
    }

    class Node {
        private String data;
        private Node left;
        private Node right;

        public Node setLeftTree(Node aNode) {
            left = aNode;
            return left;
        }

        public Node setRightTree(Node aNode) {
            right = aNode;
            return right;
        }

        public Node() {
            // TODO Auto-generated constructor stub
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }

    } // end Node class

    static class NodeHelper {
        private Node aNode;
        private Consumer<Node> action;

        public NodeHelper(Node aNode, Consumer<Node> action) {
            this.aNode = aNode;
            this.action = action;
        }

        public Node getNode() {
            return aNode;
        }

        public Consumer<Node> getAction() {
            return action;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        BinaryTreeService rta = new BinaryTree("data0_1");
        rta.preorder();
        rta.postorder();

    }

}
