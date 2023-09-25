package tony_git.data_structure;

// https://steady-coding.tistory.com/635
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int temp = 1;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') {
                stack.add(now);
                temp *= 2;
            } else if (now == '[') {
                stack.add(now);
                temp *= 3;
            } else if (now == ')') {
                // stack이 비었거나, stack 제일 위의 문자가 ( 아닐 경우 → 잘못된 괄호 형태
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                // ()인 경우
                if (s.charAt(i - 1) == '(') {
                    answer += temp;
                }
                temp /= 2;
                stack.pop();
            } else {
                // stack이 비었거나, stack 제일 위의 문자가 [ 아닐 경우 → 잘못된 괄호 형태
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                // []인 경우
                if (s.charAt(i - 1) == '[') {
                    answer += temp;
                }
                temp /= 3;
                stack.pop();
            }
        }

        // 연산 마쳤는데, 스택이 비어있지 않다면 → 잘못된 괄호 형태태
        if (!stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}