package com.tsystems.javaschool.tasks.pyramid;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().main();
    }

    private void main() {
//        System.out.println(count(6));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(isPossible(2147483647 ));

//        PyramidBuilder pyramidBuilder = new PyramidBuilder();
//        List<Integer> list = Arrays.asList(11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 17, 5, 14, 10, 18, 8, 7, 19, 15, 6, 20);
//        int[][] a = pyramidBuilder.buildPyramid(list);
//        Arrays.stream(a).forEach(o -> {
//            System.out.println(Arrays.toString(o));
//        });

//        int n = 15;
//        System.out.println(Math.log(n) / Math.log(2.0));

        summarize(1);
        int depth = depthMap.get(1L);
        System.out.println(depth);
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

    private Map<Integer, Long> cache = new HashMap<>();
    private Map<Long, Integer> depthMap = new HashMap<>();
    private int count = 1;

    private long summarize(int times) {
        if (!cache.containsKey(1)) {
            cache.put(1, 1L);
            depthMap.put(1L, 1);
        }

        if (cache.containsKey(times)) {
            return cache.get(times);
        } else {
            for (long i = count; i < times; i++) {
                long curCount = count++;
                long sum = cache.get(curCount) + count;
                cache.put(count, sum);
                depthMap.put(sum, count);
            }
            return cache.get(times);
        }
    }

//    private int log(int n) {
//        return (int)Math.ceil(Math.log(n) / Math.log(2.0));
//    }
//
//    private boolean isPossible(int number) {
//        int k = 1;
//        long cur;
//        long res = 0;
//        while ((cur = summarize(k)) <= number) {
//           k ++;
//           res = cur;
//        }
//        return number == res;
//    }
//
//    private Map<Long, Long> cache = new HashMap<>();
//    private long count = 1;
//
//    private long summarize(long times) {
//        if (!cache.containsKey(1L)) {
//            cache.put(1L, 1L);
//        }
//
//        if (cache.containsKey(times)) {
//            return cache.get(times);
//        } else {
//            for (long i = count; i < times; i++) {
//                long curCount = count ++;
//                long sum = cache.get(curCount) + count;
//                cache.put(count, sum);
//            }
//            return cache.get(times);
//        }
//
////        long level = 1;
//////        long sum = 1;
////        long sum = cache.get(level);
////        for (int i = 0; i < times - 1; i++) {
////            sum = sum + level + 1;
////            level++;
////            cache.put(level, sum);
////        }
//////        return sum;
////        return cache.get(level);
//    }














//    private int log(int n) {
//        return (int)Math.ceil(Math.log(n) / Math.log(2.0));
//    }

//    private boolean isPossible(int number) {
//        int k = 1;
//        long cur;
//        long res = 0;
//        while ((cur = summarize(k)) <= number) {
//            k ++;
//            res = cur;
//        }
//        return number == res;
//    }
//
//    private long summarize(int times) {
//        long level = 1;
//        long sum = 1;
//        for (int i = 0; i < times - 1; i++) {
//            sum = sum + level + 1;
//            level ++;
//        }
//        return sum;
//    }

//    private boolean isPossible(int number) {
//        int k = 1;
//        long cur;
//        long res = 0;
//        while ((cur = summarize(k)) <= number) {
//            k ++;
//            res = cur;
//        }
//        return number == res;
//    }
//
//    private Map<Integer, Long> cache = new HashMap<>();
//    private Map<Long, Integer> depthMap = new HashMap<>();
//    private int count = 1;
//
//    private long summarize(long times) {
//        if (!cache.containsKey(1L)) {
//            cache.put(1, 1L);
//            depthMap.put(1L, 1);
//        }
//
//        if (cache.containsKey(times)) {
//            return cache.get(times);
//        } else {
//            for (long i = count; i < times; i++) {
//                long curCount = count++;
//                long sum = cache.get(curCount) + count;
//                cache.put(count, sum);
//                depthMap.put(sum, count);
//            }
//            return cache.get(times);
//        }
//    }
}
