package org.example.model;

public class StaticQueue implements Queue {

    private final static int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticQueue() {
        array = new int[MAX];
        count = 0;
    }

    @Override
    public void enqueue(int a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede encolar un elemento en una cola llena");
        }

        array[count] = a;
        count++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        for (int i = 0; i < count; i++) {
            array[i] = array[i + 1];
        }

        count--;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el frente de una cola vacía");
        }

        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
