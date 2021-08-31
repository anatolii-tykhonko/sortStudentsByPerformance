package com.atykhonko;

public class BubbleSorter implements Sorter {
    @Override
    public String[] sort(String[] inputData) {
        boolean unsorted = true;
        String temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < inputData.length - 1; i++) {
                if (equalsMarks(inputData[i], inputData[i + 1])) {
                    temp = inputData[i];
                    inputData[i] = inputData[i + 1];
                    inputData[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
        return inputData;
    }
}
