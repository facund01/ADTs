package org.example.model;

import org.example.model.nodes.Node;

public class DynamicStack implements Stack {

    private Node top;

    public DynamicStack() {
        top = null;
    }

    @Override
    public void push(int a) {
        top = new Node(a, top);
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede quitar un elemento de una pila vacía");
        }

        top = top.getNext();
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }

        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
