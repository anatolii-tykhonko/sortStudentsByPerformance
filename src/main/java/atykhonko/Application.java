package atykhonko;

public class Application {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        String[] dataFromFile = reader.readFileToArray(args[1]);
        Sorter sorter;
        if (args[0].equals("y")) {
            sorter = new BubbleSorter();
        } else {
            sorter = SorterFabric.createSorter(dataFromFile.length);
        }
        String[] sortedStudentsByPerformance = sorter.sort(dataFromFile);
        ResultFormatter formatter = new ResultFormatterImpl();
        if (args.length > 2) {
            formatter.saveResultToFile(sortedStudentsByPerformance, args[2]);
        } else {
            System.out.println(formatter.printResult(sortedStudentsByPerformance));
        }
    }
}
