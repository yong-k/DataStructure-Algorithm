package baekjoon_step.Step21_queue;

import java.io.*;
import java.util.*;

public class B_18258 {
    static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String str;
        int num;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            switch (str) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    num = pop();
                    sb.append(num + "\n");
                    break;
                case "size":
                    num = size();
                    sb.append(num + "\n");
                    break;
                case "empty":
                    num = empty();
                    sb.append(num + "\n");
                    break;
                case "front":
                    num = front();
                    sb.append(num + "\n");
                    break;
                case "back":
                    num = back();
                    sb.append(num + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static void push(int x) {
        q.add(x);
    }
    static int pop() {
        if (q.isEmpty())
            return -1;
        else
            return q.poll();
    }
    static int size() {
        return q.size();
    }
    static int empty() {
        if (q.isEmpty())
            return 1;
        else
            return 0;
    }
    static int front() {
        if (q.isEmpty())
            return -1;
        else
            return q.peek();
    }
    static int back() {
        if (q.isEmpty())
            return -1;
        else
            return q.peekLast();
    }
}
