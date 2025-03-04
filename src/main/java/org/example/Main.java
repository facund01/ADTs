package org.example;

import org.example.model.*;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new StaticPriorityQueue();

        priorityQueue.enqueue(10, 1);
        priorityQueue.enqueue(20, 2);
        priorityQueue.enqueue(30, 2);
        priorityQueue.enqueue(40, 3);



    }
}