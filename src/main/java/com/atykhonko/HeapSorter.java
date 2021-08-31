package com.atykhonko;

public class HeapSorter implements Sorter {
    @Override
    public String[] sort(String[] inputData) {
        int size = inputData.length;
        String temp;
        for (int i = size / 2 - 1; i >= 0; i--) {
            inputData = heapify(inputData, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            temp = inputData[0];
            inputData[0] = inputData[i];
            inputData[i] = temp;
            inputData = heapify(inputData, i, 0);
        }
        return inputData;
    }

    private String[] heapify(String[] subArray, int size, int i) {
        String temp;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && equalsMarks(subArray[left], subArray[largest]))
            largest = left;

        if (right < size && equalsMarks(subArray[right], subArray[largest]))
            largest = right;

        if (largest != i) {
            temp = subArray[i];
            subArray[i] = subArray[largest];
            subArray[largest] = temp;
            heapify(subArray, size, largest);
        }
        return subArray;
    }
}
