package tony_git.data_structure;

// https://steady-coding.tistory.com/635
import java.util.*;
public class B_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String s = sc.next();
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
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(')
                    answer += temp;
                temp /= 2;
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[')
                    answer += temp;
                temp /= 3;
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            answer = 0;

        System.out.println(answer);
    }
}
