package org.example.model;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int MAX = 10000;
    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        values = new int[MAX];
        priorities = new int[MAX];
        count = 0;
    }

    @Override
    public void enqueue(int a, int priority) {
        if (count == MAX) {
            throw new RuntimeException("No se puede encolar un elemento en una cola llena");
        }

        if (isEmpty() || priority >= priorities[count - 1]) {
            values[count] = a;
            priorities[count] = priority;
            count++;
            return;
        }

        if (priority < priorities[0]) {
            for (int i = count - 1; i > 0; i--) {
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }

            values[0] = a;
            priorities[0] = priority;
            count++;
            return;
        }

        int index = findIndex(priority);

        if (index != -1) {
            int candidate = index;
            while (priorities[candidate] == priority) {
                candidate++;
            }

            for (int i = count - 1; i >= candidate; i--) {
                values[i + 1] = values[i];
                priorities[i + 1] = priorities[i];
            }

            values[candidate] = a;
            priorities[candidate] = priority;
            count++;
            return;
        }
        
    }

    private int findIndex(int priority) {
        for (int i = 0; i < count; i++) {
            if (priorities[i] == priority) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }

        for (int i = 0; i < count - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }

        count--;
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el frente de una cola vacía");
        }

        return values[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }

        return priorities[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
