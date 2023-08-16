package tony_git.data_structure;

// https://steady-coding.tistory.com/search/9012
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            stack = new Stack<>();
            boolean noFlag = false;

            for (int j = 0; j < s.length(); j++) {
                noFlag = false;
                char now = s.charAt(j);
                if (now == '(') {
                    stack.push(now);
                } else {
                    if (stack.isEmpty()) {
                        noFlag = true;
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        noFlag = true;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && !noFlag)
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}
