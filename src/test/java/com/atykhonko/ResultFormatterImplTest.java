package com.atykhonko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultFormatterImplTest {
    ResultFormatterImpl formatter = new ResultFormatterImpl();

    @Test
    void printResultShouldFormattedText(){
        String[] input = {"Student10,8.5", "Student2,6.5", "Student3,5.0"};
        String expected = String.format("1|Student10 |8.5|%n" +
                "2|Student2  |6.5|%n" +
                "3|Student3  |5.0|%n");
        String actual = formatter.printResult(input);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}