package com.solucionesEDA.datastructures;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 2;

    private T[] stack;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.capacity = initialCapacity;
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void push(T element) {
        ensureCapacity();
        stack[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = stack[--size];
        stack[size] = null;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stack[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size >= capacity) {
            int newCapacity = capacity * GROWTH_FACTOR;
            T[] newStack = (T[]) new Object[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
            capacity = newCapacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}