package com.atykhonko.benchmark;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class CreateStringArray {
    String[] array;
    @Setup(Level.Invocation)
    public void setUp() {
        array = new String[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = "Student" + i + "," + Math.random() * 10;
        }
    }
}
