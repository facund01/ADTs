package org.example.model;

public interface MultipleDictionary {

    void add(int key, int value);
    void remove(int key, int value);
    List get(int key);
    Set getKeys();

}
