
import java.io.*;
import java.util.*;
public class T999_practice {
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

