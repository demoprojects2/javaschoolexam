package com.tsystems.javaschool.tasks.calculator;

import java.math.BigDecimal;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */

    private String expr;
    private int pos = -1;
    private int ch;

    public String evaluate(String statement) {
        // TODO: Implement the logic here

        try {
            expr = statement;
            BigDecimal bigDecimal = new BigDecimal(calculate()).setScale(4, BigDecimal.ROUND_HALF_UP);
            String res = String.valueOf(bigDecimal.doubleValue());
            return res.endsWith(".0") ? res.substring(0, res.length() - 2) : res;
        } catch (RuntimeException e) {
            return null;
        }
    }

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
}
