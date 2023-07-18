package tony_git.data_structure;

import java.util.*;
public class B_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String s = sc.next();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') {
                stack.push(now);
            } else if (s.charAt(i - 1) == '(') {    // () 레이저일 경우
                stack.pop();
                answer += stack.size();
            } else {                                // 막대기 하나 끝난 경우
                stack.pop();
                answer++;
            }
        }

        System.out.println(answer);
    }
}
