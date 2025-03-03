package org.example.util;

import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

    public static Stack copy(Stack stack) {
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();

        while (!stack.isEmpty()) {
            aux.push(stack.getTop());
            stack.pop();
        }

        while (!aux.isEmpty()) {
            aux2.push(aux.getTop());
            stack.push(aux.getTop());
            aux.pop();
        }

        return aux2;
    }

    public static void print(Stack stack) {
        Stack copy = copy(stack);

        while(!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.pop();
        }
    }

}
