package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 4, 10};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //minimum index logic
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
