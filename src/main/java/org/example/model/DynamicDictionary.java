package org.example.model;

import org.example.model.nodes.DictionaryNode;

public class DynamicDictionary implements Dictionary {

    private DictionaryNode node;

    @Override
    public void add(int key, int value) {
        if (node == null) {
            node = new DictionaryNode(key, value, null);
            return;
        }

        DictionaryNode aux = node;
        while (aux.getNext() != null) {
            if (aux.getKey() == key) {
                if (aux.getValue() == value) {
                    throw new RuntimeException("No se puede agregar porque el par que ya existe");
                }

                throw new RuntimeException("No se puede agregar porque la clave ya existe");
            }

            aux = aux.getNext();
        }

        if (aux.getKey() == key) {
            if (aux.getValue() == value) {
                throw new RuntimeException("No se puede agregar porque el par que ya existe");
            }

            throw new RuntimeException("No se puede agregar porque la clave ya existe");
        }

        aux.setNext(new DictionaryNode(key, value, null));
    }

    @Override
    public void remove(int key) {
        if (node == null) {
            throw new RuntimeException("No se puede eliminar de un diccionario vacío");
        }

        if (node.getKey() == key) {
            node = node.getNext();
            return;
        }

        DictionaryNode aux = node;
        DictionaryNode aux2 = node.getNext();
        while (aux2 != null) {
            if (aux2.getKey() == key) {
                aux.setNext(aux2.getNext());
                return;
            }

            aux = aux2;
            aux2 = aux2.getNext();
        }

        throw new RuntimeException("No se puede eliminar una clave que no existe");
    }

    @Override
    public int get(int key) {
        if (node == null) {
            throw new RuntimeException("No se puede obtener el valor de un diccionario vacío");
        }

        DictionaryNode aux = node;
        while (aux != null) {
            if (aux.getKey() == key) {
                return aux.getValue();
            }

            aux = aux.getNext();
        }

        throw new RuntimeException("No se puede obtener el valor de una clave que no existe");
    }

    @Override
    public Set getKeys() {
        Set keys = new StaticSet();

        DictionaryNode aux = node;
        while (aux != null) {
            keys.add(aux.getKey());
            aux = aux.getNext();
        }

        return keys;
    }

}
