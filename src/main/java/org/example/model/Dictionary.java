package org.example.model;

public interface Dictionary {

    void add(int key, int value);
    void remove(int key);
    int get(int key);
    Set getKeys();

}
