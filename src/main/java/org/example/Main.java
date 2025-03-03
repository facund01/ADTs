package org.example;

import org.example.model.*;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {
        Queue queue = new DynamicQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();

        System.out.println(queue.getFirst());

    }
}