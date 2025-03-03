package org.example.model;

public interface Queue {

    void enqueue(int a);
    void dequeue();
    int getFirst();
    boolean isEmpty();

}
