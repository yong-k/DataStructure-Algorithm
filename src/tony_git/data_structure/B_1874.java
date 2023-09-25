package tony_git.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_1874 {
    public static void main(String[] args) throws IOException {
        /*
        num = 스택에 넣을 1부터 증가하는 자연수
        num < 입력받은 숫자: 입력받은 수가 될 때까지 push하고, 해당 숫자를 pop한다.
        num > 입력받은 숫자: 불가능한 경우  → NO출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input >= num) {
                while (input >= num) {
                    stack.push(num++);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
            } else {
                if (stack.peek() > input) {
                    sb = new StringBuilder("NO");
                    break;
                } else {
                    stack.pop();
                    sb.append('-').append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
