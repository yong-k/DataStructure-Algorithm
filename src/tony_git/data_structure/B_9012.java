package tony_git.data_structure;

// https://steady-coding.tistory.com/search/9012
import java.util.*;
public class B_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = sc.next();
            stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char now = s.charAt(j);
                if (now == '(')
                    stack.push(now);
                // ')'이고 stack 비어있으면 NO라고 출력해주기 위해 push하고 break;
                else if (stack.isEmpty()) {
                    stack.push(now);
                    break;
                } else
                    stack.pop();
            }
            if (stack.isEmpty())
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}
