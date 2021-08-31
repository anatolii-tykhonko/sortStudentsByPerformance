package atykhonko;

public class SorterFabric {
    public static Sorter createSorter(int length) {
        if(length > 500){
            return new MergeSorter();
        }
        return new HeapSorter();
    }
    private SorterFabric(){}
}
