package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenteses {
    final private static String OPEN = "([{";
    final private static String CLOSE = ")]}";

    public static boolean check(String par) {
        Deque<Character> stack = new ArrayDeque<>();
        final int n = par.length();
        for (int i = 0; i < n; i++) {
            char c = par.charAt(i);
            if (OPEN.indexOf(c) != -1) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (OPEN.indexOf(open) != CLOSE.indexOf(c)) return false; // different parens
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(check("([})"));
    }
}
