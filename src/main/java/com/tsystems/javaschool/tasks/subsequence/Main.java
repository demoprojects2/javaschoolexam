package com.tsystems.javaschool.tasks.subsequence;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> input = Collections.nCopies(5, 0);
//        System.out.println(input);

        Subsequence s = new Subsequence();
        boolean b = s.find(Arrays.asList("A", "B", "C", "D"),
                Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D"));
        System.out.println(b); // Result: true
    }
}
