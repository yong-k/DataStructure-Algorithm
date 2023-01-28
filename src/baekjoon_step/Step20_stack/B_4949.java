package baekjoon_step.Step20_stack;

import java.io.*;
import java.util.*;

public class B_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while (true) {
            s = br.readLine();
            if (s.equals("."))
                break;

            sb.append(solution(s)).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}
