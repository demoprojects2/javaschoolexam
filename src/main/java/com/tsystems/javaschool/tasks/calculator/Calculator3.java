package com.tsystems.javaschool.tasks.calculator;

import java.math.BigDecimal;

public class Calculator3 {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */


//    private List<String> expr = new LinkedList<>();
//    private StringBuilder fullNumber = new StringBuilder();
//    private Deque<Integer> parentLeft = new ArrayDeque<>();
//    private Deque<Integer> parentRight = new ArrayDeque<>();
    private String expr;

    public String evaluate(String statement) {
        // TODO: Implement the logic here

        try {
            expr = statement;
            String res = String.valueOf(calculate());
            BigDecimal r = new BigDecimal(res).setScale(4, BigDecimal.ROUND_HALF_UP);
            res = String.valueOf(r.doubleValue());
            return res.endsWith(".0") ? res.substring(0, res.length() - 2) : res;
        } catch (RuntimeException e) {
            return null;
        }


//        try {
//            for (int i = 0; i < statement.length(); i++) {
//                char curChar = statement.charAt(i);
//                if (isNumber(curChar)) {
//                    fullNumber.append(curChar);
//                } else {
//                    flushNumber();
//                    if (isSign(curChar))
//                        expr.add(String.valueOf(curChar));
//                    else if (curChar == '(')
//                        parentLeft.offer(i);
//                    else if (curChar == ')')
//                        parentRight.offer(i);
//                    else
//                        return null;
//                }
//            }
//            flushNumber();
//
//            String res = calculate(expr);
//            BigDecimal r = new BigDecimal(res).setScale(4, BigDecimal.ROUND_HALF_UP);
//            res = String.valueOf(r.doubleValue());
//            return res.endsWith(".0") ? res.substring(0, res.length() - 2) : res;
//        } catch (RuntimeException e) {
//            System.out.println(e.getLocalizedMessage());
//            return null;
//        }















//        String[] a = statement.split("[\\s]{1}");
//
//        List<String> list = new LinkedList<>();
//        Arrays.stream(a).forEach(list::add);
//        Deque<Integer> parentLeft = new ArrayDeque<>();
//        Deque<Integer> parentRight = new ArrayDeque<>();
//
////        List<String> list = Arrays.asList(a);
//
//        for (int i = 0; i < list.size(); i++) {
//            String cur = list.get(i);
//
//            if (cur.equals("(")) {
//                parentLeft.offer(i);
//            }
//
//            if (cur.equals(")")) {
//                parentRight.offer(i);
//            }
//        }
//
//        if (parentLeft.isEmpty())
//            calculate(list);
//
//        while (!parentLeft.isEmpty()) {
//            int leftIndex = parentLeft.pollLast();
//            int rightIndex = parentRight.pollFirst();
//            list.remove(rightIndex);
//            list.remove(leftIndex);
//            String res = calculate(list.subList(leftIndex, rightIndex + 1));
//            for (int i = 0; i < rightIndex - leftIndex - 1; i ++) {
//                list.remove(rightIndex);
//            }
//            list.set(rightIndex, res);
//        }
//
//        list.forEach(System.out::println);
//        return "";

//        StringBuilder sb = new StringBuilder(statement);
//        StringBuilder number1 = new StringBuilder();
//        Character sign = null;
//        StringBuilder number2 = new StringBuilder();
//        for (int i = 0; i < sb.length(); i++) {
//
//            if (sign != null && !number2.equals("")) {
//                calc(number1.toString(), sign, number2.toString());
//            }
//
//            char curChar = sb.charAt(i);
//            if (curChar >= '0' && curChar <= '9') {
//                number.append(curChar);
//            } else if (curChar == '+') {
//                sign = curChar;
//            } else if (curChar == '-') {
//
//            } else if (curChar == '*') {
//
//            } else if (curChar == '/') {
//
//            } else if (curChar == '.') {
//
//            }
//        }
    }















    private int pos = -1;
    private int ch;

    private void next() {
        pos ++;
        if (pos < expr.length())
            ch = expr.charAt(pos);
        else
            ch = -1;
    }

    private boolean check(int ch) {
        if (this.ch == ch) {
            next();
            return true;
        }
        return false;
    }

    private double calculate() {
        next();
        double res = calcPlusMinus();

        if (pos < expr.length())
            throw new RuntimeException();

        return res;
    }

    private double calcPlusMinus() {
        double res = calcProdDiv();
        while (true) {
            if (check('+'))
                res += calcProdDiv();
            else if (check('-'))
                res -= calcProdDiv();
            else
                return res;
        }
    }

    private double calcProdDiv() {
        double res = calcParNum();
        while (true) {
            if (check('*'))
                res *= calcParNum();
            else if (check('/'))
                res /= calcParNum();
            else
                return res;
        }
    }

    private double calcParNum() {
        double res;
        int startPos = pos;
        if (check('(')) {
            res = calcPlusMinus();
            if (!check(')')) {
                throw new RuntimeException();
            }
        } else if (isNumber(ch)) {
            while (isNumber(ch))
                next();
            res = Double.parseDouble(expr.substring(startPos, pos));
        } else {
            throw new RuntimeException();
        }

        return res;
    }

    private boolean isNumber(int curChar) {
        return Character.isDigit((char)curChar) || (char)curChar == '.';
    }














//
//    private boolean isNumber(int curChar) {
////        (ch >= '0' && ch <= '9') || ch == '.'
//        return Character.isDigit((char)curChar) || (char)curChar == '.';
//    }
//
//    private boolean isSign(char curChar) {
//        String allowed = "+-/*()";
//        return allowed.contains(String.valueOf(curChar));
//    }
//
//    private void flushNumber() {
//        if (fullNumber.length() != 0) {
//            expr.add(fullNumber.toString());
//            fullNumber = new StringBuilder();
//        }
//    }
//
//    private String calculatePriority(List<String> list) {
//        while (!parentLeft.isEmpty()) {
//            int leftIndex = parentLeft.pollLast();
//            int rightIndex = parentRight.pollFirst();
//            list.remove(rightIndex);
//            list.remove(leftIndex);
//            String res = calculate(list.subList(leftIndex, rightIndex + 1));
//            for (int i = 0; i < rightIndex - leftIndex - 1; i ++) {
//                list.remove(rightIndex);
//            }
//            list.set(rightIndex, res);
//        }
//        return null;
//    }
//
//    private String calculate(List<String> list) {
//
//        while (list.size() > 1) {
//            for (int i = 0; i < list.size(); i++) {
//                String cur = list.get(i);
//
//                if (cur.equals("*") || cur.equals("/")) {
//                    String prev = list.get(i - 1);
//                    String next = list.get(i + 1);
//                    if (cur.equals("*")) {
//                        String res = String.valueOf(Double.valueOf(prev) * Double.valueOf(next));
//                        modify(list, i, res);
//                    } else {
//                        String res = String.valueOf(Double.valueOf(prev) / Double.valueOf(next));
//                        modify(list, i, res);
//                    }
//                }
//            }
//
//
//            for (int i = 0; i < list.size(); i++) {
//                String cur = list.get(i);
//                if (cur.equals("+") || cur.equals("-")) {
//                    String prev = list.get(i - 1);
//                    String next = list.get(i + 1);
//                    if (cur.equals("+")) {
//                        String res = String.valueOf(Double.valueOf(prev) + Double.valueOf(next));
//                        modify(list, i, res);
//                    } else {
//                        String res = String.valueOf(Double.valueOf(prev) - Double.valueOf(next));
//                        modify(list, i, res);
//                    }
//                }
//            }
//        }
//
//        return list.get(0);
//    }
//
//    private void modify(List<String> list, int i, String res) {
//        list.remove(i + 1);
//        list.remove(i);
//        list.set(i - 1, res);
//    }














//    private String calc(String n1, Character sign, String n2) {
//        String result = null;
//        Double d1 = Double.parseDouble(n1);
//        Double d2 = Double.parseDouble(n2);
//        switch (sign) {
//            case '+':
//                result = String.valueOf(d1 + d2);
//            case '-':
//                result = String.valueOf(d1 - d2);
//            case '*':
//                result = String.valueOf(d1 * d2);
//            case '/':
//                result = String.valueOf(d1 / d2);
//        }
//        return result;
//    }
}
