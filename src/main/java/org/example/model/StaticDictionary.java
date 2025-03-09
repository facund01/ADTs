package org.example.model;

public class StaticDictionary implements Dictionary {

    private final static int MAX = 10000;
    private final int[][] matrix;
    private int count;

    public StaticDictionary() {
        matrix = new int[MAX][2];
        count = 0;
    }


    @Override
    public void add(int key, int value) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar un par en un diccionario lleno");
        }

        if (count == 0) {
            matrix[0][0] = key;
            matrix[0][1] = value;
            count++;
            return;
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                if (matrix[i][1] == value) {
                    throw new RuntimeException("No se puede agregar porque el par que ya existe");
                }

                throw new RuntimeException("No se puede agregar porque la clave ya existe");
            }
        }

        matrix[count][0] = key;
        matrix[count][1] = value;
        count++;
    }

    @Override
    public void remove(int key) {
        if (count == 0) {
            throw new RuntimeException("No se puede eliminar de un diccionario vacío");
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                matrix[i][0] = matrix[count - 1][0];
                matrix[i][1] = matrix[count - 1][1];
                count--;
                return;
            }
        }

        throw new RuntimeException("No se puede eliminar una clave que no existe");
    }

    @Override
    public int get(int key) {
        if (count == 0) {
            throw new RuntimeException("No se puede obtener el valor de un diccionario vacío");
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                return matrix[i][1];
            }
        }

        throw new RuntimeException("No se puede obtener el valor de una clave que no existe");
    }

    @Override
    public Set getKeys() {
        Set keys = new StaticSet();

        for (int i = 0; i < count; i++) {
            keys.add(matrix[i][0]);
        }

        return keys;
    }

}
