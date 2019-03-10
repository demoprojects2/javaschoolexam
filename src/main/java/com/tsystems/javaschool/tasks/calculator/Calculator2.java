package com.tsystems.javaschool.tasks.calculator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Calculator2 {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    private char ch;
    private int pos = -1;
    private String expression;
    private double result = 0.0;

    public static void main(String[] args) {
        Calculator2 calculator2 = new Calculator2();
        System.out.println(calculator2.evaluate("1+2"));
    }

    public String evaluate(String statement) {
        // TODO: Implement the logic here

        expression = statement;
        return String.valueOf(parse());
    }

    private double parse() {
        next();
        if (pos >= expression.length())
            return 0.0;

        StringBuilder curNumber = new StringBuilder();
        while (isNumber(ch)) {
            curNumber.append(ch);
            next();
        }

        switch(ch) {
            case '+':
//                result = result + Double.parseDouble(curNumber.toString());

                return Double.parseDouble(curNumber.toString()) + parse();
            case '-':
                return Double.parseDouble(curNumber.toString()) - parse();
            default:
                return 0.0;
        }
    }

    private boolean isNumber(char curChar) {
        return Character.isDigit(curChar) || curChar == '.';
    }


    private void next() {
        pos ++;
        if (pos < expression.length())
            ch = expression.charAt(pos);
    }
}
