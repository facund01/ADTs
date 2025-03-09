package org.example.model;

import org.example.model.nodes.Node;

import java.util.Random;

public class DynamicSet implements Set {

    private Node node;
    private final Random random;
    private int count;


    public DynamicSet() {
        node = null;
        random = new Random();
    }

    @Override
    public void add(int a) {
        if (isEmpty()) {
            node = new Node(a, null);
            count++;
            return;
        }

        Node aux = node;
        while (aux.getNext() != null) {
            if (aux.getValue() == a) {
                return;
            }

            aux = aux.getNext();
        }

        if (aux.getValue() == a) {
            return;
        }

        aux.setNext(new Node(a, null));
    }

    @Override
    public void remove(int a) {
        if (isEmpty()) {
            return;
        }

        if (node.getValue() == a) {
            node = node.getNext();
            count--;
            return;
        }

        Node aux = node;
        Node aux2 = node.getNext();
        while (aux2 != null) {
            if (aux2.getValue() == a) {
                aux.setNext(aux2.getNext());
                count--;
                return;
            }

            aux = aux2;
            aux2 = aux2.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }

        if (node.getNext() == null) {
            return node.getValue();
        }

        int randomIndex = random.nextInt(count);
        int i = 0;
        Node aux = node;
        while (i < count) {
            if (i == randomIndex) {
                return aux.getValue();
            }

            i++;
            aux = aux.getNext();
        }

        throw new RuntimeException();
    }

}
