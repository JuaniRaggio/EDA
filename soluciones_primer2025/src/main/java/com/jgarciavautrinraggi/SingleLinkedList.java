package com.jgarciavautrinraggi;

public class SingleLinkedList {

    private Node root;


    private final class Node {
        private int data;
        private Node next;

        private Node( int data) {
            this.data = data;
        }

        private Node( int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addFirst( int data ){
        root = new Node( data, root );
    }

    public void print(){
        Node n = root;
        while ( n != null ){
            System.out.println( n.data );
            n = n.next;
        }
    }

    public void reverseFirst( int num ) {
        if (num <= 0 || root == null) return;

        Node prev = null;
        Node current = root;
        Node originalFirst = root;
        int count = 0;

        // Reverse the first num nodes
        while (current != null && count < num) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Update root to the new head of reversed section
        root = prev;

        // Connect the original first node (now last in reversed section) to remaining list
        originalFirst.next = current;
    }


     public static void mainA(String[] args) {
        SingleLinkedList l = new SingleLinkedList();

       
        l.addFirst(10);
        l.addFirst(28);
        l.addFirst(30);
        l.addFirst(12);
        l.addFirst(50);
        
        System.out.println("ORIGINAL");
        l.print();
        System.out.println("REVERSED FIRST");
        l.reverseFirst(3);
        l.print();
    }

    public static void mainB(String[] args) {
        SingleLinkedList l = new SingleLinkedList();

        l.addFirst(5);
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        System.out.println("ORIGINAL");
        l.print();
        System.out.println("REVERSED FIRST");
        l.reverseFirst(5);
        l.print();
    }


    public static void mainC(String[] args) {
        SingleLinkedList l = new SingleLinkedList();

        l.addFirst(25);
        l.addFirst(13);
        l.addFirst(25);
        l.addFirst(12);
        l.addFirst(16);
       
       
        
       
        System.out.println("ORIGINAL");
        l.print();
        System.out.println("REVERSED FIRST");
        l.reverseFirst(1);
        l.print();
    }

    public static void mainD(String[] args) {
        SingleLinkedList l = new SingleLinkedList();

        l.addFirst(10);
        l.addFirst(28);
        l.addFirst(30);
        l.addFirst(12);
        l.addFirst(50);
        
        System.out.println("ORIGINAL");
        l.print();
        System.out.println("REVERSED FIRST");
        l.reverseFirst(33);
        l.print();
    }
}
