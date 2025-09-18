package com.solucionesEDA.algorithms;

import com.solucionesEDA.datastructures.ArrayStack;
import java.util.StringTokenizer;

public class InfixToPostfix {

    public static String convert(String infixExpression) {
        if (infixExpression == null || infixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        StringBuilder result = new StringBuilder();
        ArrayStack<String> operatorStack = new ArrayStack<>();
        StringTokenizer tokenizer = new StringTokenizer(infixExpression, "+-*/^%()", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) {
                continue;
            }

            if (isOperand(token)) {
                result.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    result.append(operatorStack.pop()).append(" ");
                }
                if (operatorStack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                operatorStack.pop();
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() &&
                       !operatorStack.peek().equals("(") &&
                       (getPrecedence(operatorStack.peek()) > getPrecedence(token) ||
                        (getPrecedence(operatorStack.peek()) == getPrecedence(token) &&
                         isLeftAssociative(token)))) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            if (operator.equals("(") || operator.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            result.append(operator).append(" ");
        }

        return result.toString().trim();
    }

    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return token.matches("[a-zA-Z_][a-zA-Z0-9_]*");
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") ||
               token.equals("/") || token.equals("%") || token.equals("^");
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }

    private static boolean isLeftAssociative(String operator) {
        return !operator.equals("^");
    }

    public static boolean isValidInfixExpression(String expression) {
        try {
            convert(expression);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String convertWithVariables(String infixExpression) {
        if (infixExpression == null || infixExpression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        StringBuilder result = new StringBuilder();
        ArrayStack<String> operatorStack = new ArrayStack<>();

        String[] tokens = tokenizeExpression(infixExpression);

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) {
                continue;
            }

            if (isOperand(token)) {
                result.append(token).append(" ");
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    result.append(operatorStack.pop()).append(" ");
                }
                if (operatorStack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                operatorStack.pop();
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() &&
                       !operatorStack.peek().equals("(") &&
                       (getPrecedence(operatorStack.peek()) > getPrecedence(token) ||
                        (getPrecedence(operatorStack.peek()) == getPrecedence(token) &&
                         isLeftAssociative(token)))) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            if (operator.equals("(") || operator.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            result.append(operator).append(" ");
        }

        return result.toString().trim();
    }

    private static String[] tokenizeExpression(String expression) {
        java.util.List<String> tokens = new java.util.ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isWhitespace(c)) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
            } else if (isOperatorChar(c) || c == '(' || c == ')') {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else {
                currentToken.append(c);
            }
        }

        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens.toArray(new String[0]);
    }

    private static boolean isOperatorChar(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }

    public static boolean isBalancedParentheses(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static String addParentheses(String expression) {
        String postfix = convert(expression);
        ArrayStack<String> stack = new ArrayStack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }
}