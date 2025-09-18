package com.open_hashing;

import java.util.LinkedList;

public class OpenHashing <T> {

    static final int INIT_DIM = 16;

    @SuppressWarnings("unchecked")
    LinkedList<T>[] hashTable = (LinkedList<T>[]) new LinkedList[INIT_DIM];

    protected boolean colision(T element) {
        return !hashTable[element.hashCode()].isEmpty();
    }

    public void insert(T element) {
        int hashCode = element.hashCode();
        if (colision(element)) {
            if (hashTable[hashCode % INIT_DIM].contains(element)) {
                return;
            }
            hashTable[hashCode % INIT_DIM].add(element);
        } else {
            hashTable[hashCode % INIT_DIM] = new LinkedList<>();
            hashTable[hashCode % INIT_DIM].add(element);
        }
    }

    public boolean delete(T element) {
        return hashTable[element.hashCode() % INIT_DIM].remove(element);
    }

}

