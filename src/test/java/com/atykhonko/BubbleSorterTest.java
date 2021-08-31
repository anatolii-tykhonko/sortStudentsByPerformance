package com.atykhonko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSorterTest {
    BubbleSorter bubbleSorter = new BubbleSorter();

    @Test
    void returnSortedResult(){
        String[] input = new String[]{"Student1,8.5", "Student3,5.0", "Student2,6.5"};
        String[] expected = new String[]{"Student1,8.5", "Student2,6.5", "Student3,5.0"};

        String[] actual = bubbleSorter.sort(input);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);

    }

}