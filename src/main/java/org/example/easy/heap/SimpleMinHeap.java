package org.example.easy.heap;

import java.util.Arrays;

/**
 * Priority Queue
 */
public class SimpleMinHeap {

    final static int DEFAULT_INITIAL_CAPACITY = 50;
    int[] heap;
    int size;

    public SimpleMinHeap(int size) {
        this.heap = new int[size];
        this.size = 0;
    }

    public SimpleMinHeap() {
        this.heap = new int[DEFAULT_INITIAL_CAPACITY];
        this.size = 0;
    }

    public SimpleMinHeap(int[] origin) {
        this.heap = new int[origin.length];
        this.size = 0;
    }

    public void add(int element) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = element;
        size++;
        if (size == 1) {
            return;
        }

        int elementIndex = size - 1;
        int parentIndex = parent(elementIndex);

        while (parentIndex >= 0 && heap[elementIndex] < heap[parentIndex]) {
            swap(parentIndex, elementIndex);

            elementIndex = parentIndex;
            parentIndex = parent(elementIndex);
        }

    }

    private void swap(int index1, int index2) {
        int e1 = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = e1;
    }

    private int parent(int elementIndex) {
        return elementIndex == 0 ? -1 : (elementIndex - 1) / 2;
    }

    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    public int peek() {
        checkHeapSize();
        return heap[0];
    }

    public int poll() {
        checkHeapSize();

        int minHeapValue = heap[0];

        if (size > 1) {
            heap[0] = heap[size - 1];
            size--;

            bubbleDown(0);
        }
        return minHeapValue;
    }

    private void checkHeapSize() {
        if (size <= 0) {
            throw new IllegalStateException("Calling poll on an empty heap.");
        }
    }

    private void bubbleDown(int rootIndex) {
        int indexToSwap = rootIndex;
        int parentIndex = indexToSwap;

        while (leftChildIndex(parentIndex) != -1) {
            int leftChildIndex = leftChildIndex(parentIndex);
            int rightChildIndex = rightChildIndex(parentIndex);

            indexToSwap = rightChildIndex != -1 ? minIndexFrom(rightChildIndex, leftChildIndex) : leftChildIndex;
            indexToSwap = minIndexFrom(parentIndex, indexToSwap);

            if (indexToSwap != parentIndex) {
                swap(indexToSwap, parentIndex);
                parentIndex = indexToSwap;
            } else {
                break;
            }
        }
    }

    private int minIndexFrom(int index1, int index2) {
        return heap[index1] < heap[index2] ? index1 : index2;
    }

    private int leftChildIndex(int parentIndex) {
        int leftChildIndex = (2 * parentIndex) + 1;
        return leftChildIndex >= size ? -1 : leftChildIndex;
    }

    private int rightChildIndex(int parentIndex) {
        int rightChildIndex = (2 * parentIndex) + 2;
        return rightChildIndex >= size ? -1 : rightChildIndex;
    }

    public void print() {
        for (int j : heap) {
            System.out.println(j);
        }
    }

    public int size() {
        return size;
    }

}
