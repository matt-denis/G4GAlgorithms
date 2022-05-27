package stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    private static final String OPERATORS = "+-*/^";
    private static enum Associativity {
        LEFT("+-*/"),
        RIGHT("^");

        private String operators;
        private Associativity (String operators) {
            this.operators = operators;
        }
        String operators() { return operators; }
    }


    public static String convert(String expression) {
        String output = "";
        var stack = new Stack<Character>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (Character.isSpaceChar(c)) continue;
            if (isParenthesis(c)) {
                if (c == '(') stack.push(c);
                else {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        output += stack.pop();
                    }
                    stack.pop(); // pop opening bracket

                }
            }
            else if (isOperator(c)) {
                if (stack.isEmpty()) stack.push(c);
                else if (getPrecedence(c) > getPrecedence(stack.peek())) {
                    stack.push(c);
                }
                else if (getPrecedence(c) < getPrecedence(stack.peek())) {
                    do {
                        output += stack.pop();
                    } while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek()));
                    stack.push(c);
                }
                else {  // equal precedence
                    Associativity associativity = getAssociativity(c);
                    switch (associativity) {
                        case LEFT:
                            do {
                                output += stack.pop();
                            } while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek()));
                            stack.push(c);
                            break;
                        case RIGHT:
                        default:
                            stack.push(c);
                    }
                }
            }
            else {
                output += c;
            }
        }
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') return "Invalid Expression";
            output += c;
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter an expression");
            String expr = sc.nextLine();
            while (!expr.equals("")) {
                System.out.println(convert(expr));
                System.out.println("Enter an expression");
                expr = sc.nextLine();
            }
                
        }
    }
        

            



    private static Associativity getAssociativity(char op) {
        return Associativity.LEFT.operators().indexOf(op) >= 0 ?
            Associativity.LEFT  : Associativity.RIGHT;
    }

    private static boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }

    private static boolean isOperator(char op) {
        return OPERATORS.indexOf(op) >= 0;
    }

    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;  // this would be an opening parenthesis
        }

    }
}
   
