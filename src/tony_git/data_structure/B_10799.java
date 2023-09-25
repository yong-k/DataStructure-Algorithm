package tony_git.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i - 1) == '(') {
                // () 레이저일 경우, 지금까지 스택에 있는거 모두 자름
                stack.pop();
                answer += stack.size();
            } else {
                // 막대기 하나 끝난 경우 → 해당 막대기만 끝났으니 + 1
                stack.pop();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
