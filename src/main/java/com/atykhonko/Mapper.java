package com.atykhonko;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mapper {

    public static Map<String, String> convertToMap(String[] sortedArray) {
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < sortedArray.length; i++) {
            String [] temp = sortedArray[i].split(",");
            result.put(temp[0], temp[1]);
        }
        return result;
    }
    private Mapper(){}
}
