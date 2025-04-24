package tony_git.data_structure;

import java.util.*;
public class B_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = sc.next();
            stack = new Stack<>();
            boolean flag = true;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty())
                flag = false;

            if (flag)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
