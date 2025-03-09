package org.example.util;

import org.example.model.Set;
import org.example.model.StaticSet;

public class SetUtil {

    public static Set copy(Set set) {
        Set copy = new StaticSet();
        Set aux = new StaticSet();

        while (!set.isEmpty()) {
            int element = set.choose();
            copy.add(element);
            aux.add(element);
            set.remove(element);
        }

        while (!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        return copy;
    }

}
