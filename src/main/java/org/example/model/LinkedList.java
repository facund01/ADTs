package org.example.model;

import org.example.model.nodes.Node;

public class LinkedList implements List {

    private Node head;

    @Override
    public void add(int a) {
        if (head == null) {
            head = new Node(a, null);
            return;
        }

        Node aux = head;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        aux.setNext(new Node(a, null));
    }

    @Override
    public void remove() {
        if (head == null) {
            throw new RuntimeException("No se puede eliminar de una lista vacía");
        }

        if (head.getNext() == null) {
            head = null;
            return;
        }

        Node aux = head;
        Node aux2 = head.getNext();
        while (aux2.getNext() != null) {
            aux = aux2;
            aux2 = aux2.getNext();
        }

        aux.setNext(null);
    }

    @Override
    public int length() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Node aux = head;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }

        return count;
    }

    @Override
    public int get(int index) {
        if (head == null) {
            throw new RuntimeException("No se puede obtener el elemento de una lista vacía");
        }

        int size = length();
        if (index >= size || index < 0) {
            throw new RuntimeException("El índice está fuera de rango");
        }

        if (index == 0) {
            return head.getValue();
        }

        int count = 1;
        Node aux = head.getNext();
        while (aux != null) {
            if (index == count) {
                return aux.getValue();
            }

            count++;
            aux = aux.getNext();
        }

        return 0;
    }

}
