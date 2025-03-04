package org.example.model;

public interface PriorityQueue {

    void enqueue(int a, int priority);
    void dequeue();
    int getFirst();
    int getPriority();
    boolean isEmpty();

}
