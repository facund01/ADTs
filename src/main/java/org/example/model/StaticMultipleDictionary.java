package org.example.model;

public class StaticMultipleDictionary implements MultipleDictionary {

    private static final int MAX = 10000;
    private final int[][] matrix;
    private int count;

    public StaticMultipleDictionary() {
        matrix = new int[MAX][200];
        count = 0;
    }

    @Override
    public void add(int key, int value) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar un valor en un diccionario lleno");
        }

        if (count == 0) {
            matrix[0][0] = key;
            matrix[0][1] = 1;
            matrix[0][2] = value;
            count++;
            return;
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                matrix[i][matrix[i][1] + 2] = value;
                matrix[i][1]++;
                return;
            }

            matrix[count][0] = key;
            matrix[count][1] = 1;
            matrix[count][2] = value;
            count++;
        }
    }

    @Override
    public void remove(int key, int value) {
        if (count == 0) {
            throw new RuntimeException("No se puede eliminar de un diccionario vacío");
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                if (matrix[i][1] == 1) {
                    if (matrix[i][2] == value) {
                        if (count == 1) {
                            matrix[0] = null;
                            count = 0;
                            return;
                        }

                        for (int j = 1; j < count; j++) {
                            matrix[i] = matrix[i + 1];
                        }

                        count--;
                        return;
                    }

                    throw new RuntimeException("No existe el valor para la clave indicada");
                }

                for (int j = 0; j < matrix[i][1]; j++) {
                    if (matrix[i][j + 2] == value) {
                        for (int k = j + 2; k < matrix[i][1] - 1; k++) {
                            matrix[i][k] = matrix[i][k + 1];
                        }

                        matrix[i][1]--;
                        return;
                    }
                }

                throw new RuntimeException("No existe el valor para la clave indicada");
            }

            throw new RuntimeException("La clave no existe");
        }
    }

    @Override
    public List get(int key) {
        if (count == 0) {
            throw new RuntimeException("No se pueden obtener valores de un diccionario vacío");
        }

        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                List values = new LinkedList();
                for (int j = 2; i < matrix[i][1]; j++) {
                    values.add(matrix[i][j]);
                }

                return values;
            }
        }

        throw new RuntimeException("La clave no existe");
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
