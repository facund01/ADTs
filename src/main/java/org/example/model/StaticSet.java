package org.example.model;

import java.util.Random;

public class StaticSet implements Set {

    private final static int MAX = 10000;
    private final int[] array;
    private final Random random;
    private int count;

    public StaticSet() {
        array = new int[MAX];
        count = 0;
        random = new Random();
    }

    @Override
    public void add(int a) {
        for (int i = 0; i < count; i++) {
            if (array[i] == a) {
                return;
            }

            array[count] = a;
            count++;
        }
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (array[i] == a) {
                array[i] = array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }

        if (count == 1) {
            return array[0];
        }

        int randomIndex = random.nextInt(count);
        return array[randomIndex];
    }

}
