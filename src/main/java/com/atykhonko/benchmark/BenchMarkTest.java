package com.atykhonko.benchmark;

import com.atykhonko.BubbleSorter;
import com.atykhonko.HeapSorter;
import com.atykhonko.MergeSorter;
import org.openjdk.jmh.annotations.*;

public class BenchMarkTest {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void bubbleSort(CreateStringArray createStringArray){
        BubbleSorter sorter = new BubbleSorter();
        sorter.sort(createStringArray.array);
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void heapSort(CreateStringArray createStringArray){
        HeapSorter sorter = new HeapSorter();
        sorter.sort(createStringArray.array);
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    public void mergeSort(CreateStringArray createStringArray){
        MergeSorter sorter = new MergeSorter();
        sorter.sort(createStringArray.array);
    }
}
