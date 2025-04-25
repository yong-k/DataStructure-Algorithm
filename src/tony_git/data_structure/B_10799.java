package tony_git.data_structure;

import java.util.*;
public class B_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();

        // () 가 연달아 나오면, pop()하면서 size만큼 더해주고,
        // )가 나오면, pop()하면서 +1

        int totalCount = 0;
        stack.push(str.charAt(0));
        char prev = stack.peek();
        for (int i = 1; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
            } else if (prev == '(') {
                stack.pop();
                totalCount += stack.size();
            } else {
                stack.pop();
                totalCount++;
            }
            prev = now;
        }
        System.out.println(totalCount);
    }
}
