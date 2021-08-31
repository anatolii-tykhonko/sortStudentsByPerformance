package atykhonko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSorterTest {
    MergeSorter mergeSorter = new MergeSorter();

    @Test
    void returnSortedResultWhenInputThreeData() {
        String[] input = new String[]{"Student1,8.5", "Student3,5.0", "Student2,6.5"};
        String[] expected = new String[]{"Student1,8.5", "Student2,6.5", "Student3,5.0"};

        String[] actual = mergeSorter.sort(input);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
    }

    @Test
    void returnSortedResultWhenInputTwoData() {
        String[] input = new String[]{"Student3,5.0", "Student2,6.5"};
        String[] expected = new String[]{"Student2,6.5", "Student3,5.0"};

        String[] actual = mergeSorter.sort(input);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void returnSortedResultWhenInputSixData() {
        String[] input = new String[]{"Student3,5.0", "Student2,5.5", "Student1,3.0", "Student4,7.5", "Student5,7.0", "Student6,8.5"};
        String[] expected = new String[]{"Student6,8.5", "Student4,7.5", "Student5,7.0", "Student2,5.5", "Student3,5.0", "Student1,3.0"};

        String[] actual = mergeSorter.sort(input);

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
        assertEquals(expected[3], actual[3]);
        assertEquals(expected[4], actual[4]);
        assertEquals(expected[5], actual[5]);
    }
}