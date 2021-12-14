package Algorithm_and_Structure;

//По условиям: на вход нам приходит строка, содержащая только символы скобок.
// Следующие символы скобочек: ( ) { } [ ].
// Необходимо написать функцию, которая проверит такую строку и вернет в результате true или false
// — в зависимости от того, является ли данная последовательность скобок валидной или нет.

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";  // true
        String s2 = "()[]{}"; // true
        String s3 = "(]";  // false
        String s4 = "([)]"; // false
        String s5 = "{([])}"; // true
        String test = "([{(})])"; // false
        System.out.println(s1 + " " + isValid(s1));
        System.out.println(s2 + " " + isValid(s2));
        System.out.println(s3 + " " + isValid(s3));
        System.out.println(s4 + " " + isValid(s4));
        System.out.println(s5 + " " + isValid(s5));
        System.out.println(test + " " + isValid(test));
    }

    private static boolean isValid(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> brackets = new HashMap<>(3);

        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (isClosed(current)) {      // Закрывающиеся скобки
                if (brackets.get(current) != stack.pollLast()) {
                    // Если current ")" , если brackets.get(")") = "(" != stack.pop() => "" ===> true
                    return false;
                }
            } else {                      // Открывающиеся скобки
                stack.add(current);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isClosed(char chr) {
        char[] c = {'}', ')', ']'};

        for (int i = 0; i < c.length; i++) {
            if (c[i] == chr) return true;
        }
        return false;
    }
}
