package org.example.model;


import org.example.model.nodes.PriorityNode;

public class DynamicPriorityQueue implements PriorityQueue {

    private PriorityNode front;

    public DynamicPriorityQueue() {
        front = null;
    }

    @Override
    public void enqueue(int a, int priority) {
        if (isEmpty()) {
            front = new PriorityNode(a, priority, null);
            return;
        }

        if (front.getNext() == null) {
            if (priority >= front.getPriority()) {
                front.setNext(new PriorityNode(a, priority, null));
                return;
            }

            front = new PriorityNode(a, priority, front);
            return;
        }

        if (priority < front.getPriority()) {
            front = new PriorityNode(a, priority, front);
            return;
        }

        
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
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }

        return front.getPriority();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

}
