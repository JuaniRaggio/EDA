package com.solucionesEDA.datastructures;

public class OpenAddressingHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final Object DELETED = new Object();

    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    private final double loadFactor;

    @SuppressWarnings("unchecked")
    public OpenAddressingHashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public OpenAddressingHashTable(int initialCapacity) {
        this.capacity = nextPrime(initialCapacity);
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public OpenAddressingHashTable(int initialCapacity, double loadFactor) {
        this.capacity = nextPrime(initialCapacity);
        this.loadFactor = loadFactor;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if ((double) size / capacity >= loadFactor) {
            resize();
        }

        int index = findIndex(key);
        Entry<K, V> entry = table[index];

        if (entry == null || entry.isDeleted) {
            table[index] = new Entry<>(key, value);
            size++;
            return null;
        } else if (entry.key.equals(key)) {
            V oldValue = entry.value;
            entry.value = value;
            entry.isDeleted = false;
            return oldValue;
        }

        return null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);
        int originalIndex = index;

        do {
            Entry<K, V> entry = table[index];
            if (entry == null) {
                return null;
            }
            if (!entry.isDeleted && entry.key.equals(key)) {
                return entry.value;
            }
            index = (index + 1) % capacity;
        } while (index != originalIndex);

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);
        int originalIndex = index;

        do {
            Entry<K, V> entry = table[index];
            if (entry == null) {
                return null;
            }
            if (!entry.isDeleted && entry.key.equals(key)) {
                V value = entry.value;
                entry.isDeleted = true;
                size--;
                return value;
            }
            index = (index + 1) % capacity;
        } while (index != originalIndex);

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public double getLoadFactor() {
        return (double) size / capacity;
    }

    private int findIndex(K key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            Entry<K, V> entry = table[index];
            if (entry == null || entry.isDeleted || entry.key.equals(key)) {
                return index;
            }
            index = (index + 1) % capacity;
        } while (index != originalIndex);

        throw new RuntimeException("Hash table is full");
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = capacity;

        capacity = nextPrime(capacity * 2);
        table = new Entry[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> entry = oldTable[i];
            if (entry != null && !entry.isDeleted) {
                put(entry.key, entry.value);
            }
        }
    }

    private static int nextPrime(int n) {
        if (n <= 1) return 2;

        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public java.util.Set<K> keySet() {
        java.util.Set<K> keys = new java.util.HashSet<>();
        for (Entry<K, V> entry : table) {
            if (entry != null && !entry.isDeleted) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    public java.util.Collection<V> values() {
        java.util.List<V> values = new java.util.ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null && !entry.isDeleted) {
                values.add(entry.value);
            }
        }
        return values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Entry<K, V> entry : table) {
            if (entry != null && !entry.isDeleted) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.key).append("=").append(entry.value);
                first = false;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}