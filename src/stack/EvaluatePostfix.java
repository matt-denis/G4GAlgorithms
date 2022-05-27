package stack;

import java.util.Stack;

public class EvaluatePostfix {
    private static final String OPERATORS = "+-*/^";

    public static int eval(String expr) {
        var stack = new Stack<Integer>();
        int n = expr.length();
        for (int i = 0; i < n; i++) {
            char ch = expr.charAt(i);
            if (Character.isWhitespace(ch)) continue;
            if (isOperator(ch)) {
                if (stack.size() < 2) throw new IllegalArgumentException("Invalid postfix expression");
                int res;
                int x = stack.pop();
                int y = stack.pop();
                switch (ch) {
                    case '+':
                        res = x + y;
                        break;
                    case '-':
                        res = x - y;
                        break;
                    case '*':
                        res = x * y;
                        break;
                    case '/':
                        res = x / y;
                        break;
                    default:
                        throw new UnsupportedOperationException(
                            String.format("Operator %s not supported", ch));

                }
                stack.push(res);
            }
            else stack.push(Character.getNumericValue(ch));
        }
        return stack.pop();

    }

    private static boolean isOperator(char op) {
        return OPERATORS.indexOf(op) >= 0;
    }

    public static void main(String[] args) {
        String expr = "13+4*";
        System.out.println(eval(expr));
    }
}