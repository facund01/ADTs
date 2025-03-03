package org.example.model;

public class StaticStack implements Stack {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticStack() {
        array = new int[MAX];
        count = 0;
    }

    @Override
    public void push(int a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar un elemento en una pila llena");
        }

        array[count] = a;
        count++;
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede quitar un elemento de una pila vacía");
        }

        count--;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }

        return array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
