package atykhonko;


public interface Sorter {
    default boolean equalsMarks(String first, String second) {
        double firstMark = Double.parseDouble(first.split(",")[1]);
        double secondMark = Double.parseDouble(second.split(",")[1]);
        return firstMark < secondMark;
    }

    String[] sort(String[] inputData);
}
