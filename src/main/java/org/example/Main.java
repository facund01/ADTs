package org.example;

import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.util.StackUtil;

public class Main {
    public static void main(String[] args) {
        Stack stack = new StaticStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Stack copy = StackUtil.copy(stack);

        StackUtil.print(stack);
    }
}