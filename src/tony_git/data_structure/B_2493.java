package tony_git.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://steady-coding.tistory.com/15
public class B_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            /**
             * while 문 안에서
             * if 스택이 비어있다면, 0 출력하고 stack에 push
             * else,
             *   if peek()높이가 현재높이보다 높으면, peek()의 번호 출력하고, 현재 탑 push
             *   else peek()높이가 현재높이보다 낮으면, pop
            **/
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(new Top(i, height));
                    break;
                }

                Top top = stack.peek();
                if (top.height > height) {
                    sb.append(top.order).append(' ');
                    stack.push(new Top(i, height));
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
}

class Top {
    int order;
    int height;

    public Top(int order, int height) {
        this.order = order;
        this.height = height;
    }
}