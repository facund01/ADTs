package org.example.model;

import org.example.model.nodes.Node;

public class DynamicQueue implements Queue {

    private Node front;

    public DynamicQueue() {
        front = null;
    }

    @Override
    public void enqueue(int a) {
        if (isEmpty()) {
            front = new Node(a, null);
            return;
        }

        Node aux = front;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        aux.setNext(new Node(a, null));
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        front = front.getNext();
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el frente de una cola vacía");
        }

        return front.getValue();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

}
