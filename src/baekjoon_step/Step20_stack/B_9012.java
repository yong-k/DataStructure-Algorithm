package baekjoon_step.Step20_stack;

import java.io.*;
import java.util.*;

public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(solution(br.readLine())).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(c);
            else if (stack.isEmpty())
                return "NO";
            else
                stack.pop();
        }
        if (stack.isEmpty())
            return "YES";
        else
            return "NO";
    }
}
