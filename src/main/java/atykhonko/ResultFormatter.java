package atykhonko;


public interface ResultFormatter {
    String printResult(String[] result);

    void saveResultToFile(String[] result, String pathToSaveFile);
}
