package com.solucionesEDA.datastructures;

public class BoundedQueue<T> {
    private final T[] queue;
    private final int capacity;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public BoundedQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enqueue(T element) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T element = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            queue[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int current = front;
        for (int i = 0; i < size; i++) {
            sb.append(queue[current]);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = (current + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }
}