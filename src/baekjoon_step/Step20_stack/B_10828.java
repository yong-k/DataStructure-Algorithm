package baekjoon_step.Step20_stack;

import java.util.*;
import java.io.*;

public class B_10828 {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;
            switch (str) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    num = pop();
                    bw.write(num + "\n");
                    break;
                case "size":
                    num = size();
                    bw.write(num + "\n");
                    break;
                case "empty":
                    num = empty();
                    bw.write(num + "\n");
                    break;
                case "top":
                    num = top();
                    bw.write(num + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void push(int n) {
        stack.push(n);
    }
    static int pop() {
        if (stack.isEmpty())
            return -1;
        else
            return stack.pop();
    }
    static int size() {
        return stack.size();
    }
    static int empty() {
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }
    static int top() {
        if (stack.isEmpty())
            return -1;
        else
            return stack.peek();
    }
}
