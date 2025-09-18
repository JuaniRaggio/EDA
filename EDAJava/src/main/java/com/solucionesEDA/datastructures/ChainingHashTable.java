package com.solucionesEDA.datastructures;

import java.util.*;

public class ChainingHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int capacity;
    private final double loadFactor;

    @SuppressWarnings("unchecked")
    public ChainingHashTable() {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new LinkedList[capacity];
        this.size = 0;
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    public ChainingHashTable(int initialCapacity) {
        this.capacity = nextPrime(initialCapacity);
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new LinkedList[capacity];
        this.size = 0;
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    public ChainingHashTable(int initialCapacity, double loadFactor) {
        this.capacity = nextPrime(initialCapacity);
        this.loadFactor = loadFactor;
        this.table = new LinkedList[capacity];
        this.size = 0;
        initializeTable();
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            @SuppressWarnings("unchecked")
            Entry<K, V> entry = (Entry<K, V>) obj;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private void initializeTable() {
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if ((double) size / capacity >= loadFactor) {
            resize();
        }

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                V value = entry.value;
                iterator.remove();
                size--;
                return value;
            }
        }

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

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        int oldCapacity = capacity;

        capacity = nextPrime(capacity * 2);
        table = new LinkedList[capacity];
        size = 0;
        initializeTable();

        for (int i = 0; i < oldCapacity; i++) {
            for (Entry<K, V> entry : oldTable[i]) {
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
        for (LinkedList<Entry<K, V>> bucket : table) {
            bucket.clear();
        }
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                keys.add(entry.key);
            }
        }
        return keys;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                values.add(entry.value);
            }
        }
        return values;
    }

    public int getBucketSize(int bucketIndex) {
        if (bucketIndex < 0 || bucketIndex >= capacity) {
            throw new IndexOutOfBoundsException("Invalid bucket index");
        }
        return table[bucketIndex].size();
    }

    public int getMaxBucketSize() {
        int max = 0;
        for (LinkedList<Entry<K, V>> bucket : table) {
            max = Math.max(max, bucket.size());
        }
        return max;
    }

    public double getAverageBucketSize() {
        return (double) size / capacity;
    }

    public int getEmptyBuckets() {
        int count = 0;
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public Map<Integer, Integer> getBucketSizeDistribution() {
        Map<Integer, Integer> distribution = new HashMap<>();
        for (LinkedList<Entry<K, V>> bucket : table) {
            int size = bucket.size();
            distribution.put(size, distribution.getOrDefault(size, 0) + 1);
        }
        return distribution;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
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