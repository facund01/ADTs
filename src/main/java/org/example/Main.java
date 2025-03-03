package org.example;

import org.example.model.LinkedList;
import org.example.model.List;
import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(2));

    }
}