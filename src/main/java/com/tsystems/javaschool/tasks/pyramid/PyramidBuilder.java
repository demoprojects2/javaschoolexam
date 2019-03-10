package com.tsystems.javaschool.tasks.pyramid;

import java.util.*;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */

    private Map<Integer, Long> cache = new HashMap<>();
    private Map<Long, Integer> depthMap = new HashMap<>();
    private int count = 1;

    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // TODO : Implement your solution here

        if (!isPossible(inputNumbers.size()) || inputNumbers.contains(null))
            throw new CannotBuildPyramidException();

        Queue<Integer> q = new PriorityQueue<>(inputNumbers);

        long depth = depthMap.get((long)inputNumbers.size());
        int[][] a = new int[(int)depth][(int)(depth + (depth - 1))];

        int times = 1;
        int startIndex = (int)((depth + (depth - 1)) / 2);
        for (int i = 0; i < depth; i++) {
            int curIndex = startIndex;
            for (int j = 0; j < times; j++) {
                a[i][curIndex] = q.poll();
                curIndex = curIndex + 2;
            }
            times ++;
            startIndex --;
        }

        return a;
    }

    private boolean isPossible(int number) {
        int k = 1;
        long cur;
        long res = 0;
        while ((cur = summarize(k)) <= number) {
            k ++;
            res = cur;
        }
        return number == res;
    }

    private long summarize(long times) {
        if (!cache.containsKey(1)) {
            cache.put(1, 1L);
            depthMap.put(1L, 1);
        }

        if (!cache.containsKey((int)times)) {
            for (long i = count; i < times; i++) {
                long curCount = count++;
                long sum = cache.get((int)curCount) + count;
                cache.put(count, sum);
                depthMap.put(sum, count);
            }
        }

        return cache.get((int)times);
    }
}
