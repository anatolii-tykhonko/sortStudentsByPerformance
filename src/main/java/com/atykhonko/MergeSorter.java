package com.atykhonko;

public class MergeSorter implements Sorter {
    @Override
    public String[] sort(String[] inputData) {
        if (inputData.length < 2) {
            return inputData;
        }
        int lengthNewArray = inputData.length / 2;
        String[] leftSubArray = new String[lengthNewArray];
        System.arraycopy(inputData, 0, leftSubArray, 0, lengthNewArray);

        lengthNewArray = inputData.length - inputData.length / 2;
        String[] rightSubArray = new String[lengthNewArray];
        System.arraycopy(inputData, inputData.length / 2, rightSubArray, 0, lengthNewArray);

        leftSubArray = sort(leftSubArray);
        rightSubArray = sort(rightSubArray);
        return mergeArrays(leftSubArray, rightSubArray);
    }

    private String[] mergeArrays(String[] leftArray, String[] rightArray) {
        String[] result = new String[leftArray.length + rightArray.length];
        int indexLeft = 0;
        int indexRight = 0;
        int indexResult = 0;
        while (leftArray.length > indexLeft || rightArray.length > indexRight) {
            if (indexLeft == leftArray.length) {
                result[indexResult] = rightArray[indexRight];
                indexRight++;
            } else if (indexRight == rightArray.length) {
                result[indexResult] = leftArray[indexLeft];
                indexLeft++;
            } else if (equalsMarks(leftArray[indexLeft], rightArray[indexRight])) {
                result[indexResult] = rightArray[indexRight];
                indexRight++;
            } else {
                result[indexResult] = leftArray[indexLeft];
                indexLeft++;
            }
            indexResult++;
        }
        return result;
    }
}
