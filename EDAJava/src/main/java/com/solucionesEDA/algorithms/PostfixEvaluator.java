package com.solucionesEDA.algorithms;

import com.solucionesEDA.datastructures.ArrayStack;
import java.util.StringTokenizer;

public class PostfixEvaluator {

    public static double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        ArrayStack<Double> stack = new ArrayStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands for operator " + token);
                }

                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                try {
                    double operand = Double.parseDouble(token);
                    stack.push(operand);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }

        return stack.pop();
    }

    public static int evaluateInteger(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        ArrayStack<Integer> stack = new ArrayStack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: insufficient operands for operator " + token);
                }

                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performIntegerOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                try {
                    int operand = Integer.parseInt(token);
                    stack.push(operand);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid token: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") ||
               token.equals("/") || token.equals("%") || token.equals("^");
    }

    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case "%":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 % operand2;
            case "^":
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private static int performIntegerOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case "%":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 % operand2;
            case "^":
                return (int) Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static boolean isValidPostfixExpression(String expression) {
        try {
            evaluate(expression);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String[] tokenize(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return new String[0];
        }

        StringTokenizer tokenizer = new StringTokenizer(expression);
        String[] tokens = new String[tokenizer.countTokens()];
        int index = 0;

        while (tokenizer.hasMoreTokens()) {
            tokens[index++] = tokenizer.nextToken();
        }

        return tokens;
    }

    public static int countOperators(String expression) {
        String[] tokens = tokenize(expression);
        int count = 0;

        for (String token : tokens) {
            if (isOperator(token)) {
                count++;
            }
        }

        return count;
    }

    public static int countOperands(String expression) {
        String[] tokens = tokenize(expression);
        int count = 0;

        for (String token : tokens) {
            if (!isOperator(token)) {
                count++;
            }
        }

        return count;
    }
}