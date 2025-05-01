package doit_codingTest;

import java.io.*;
import java.util.*;

public class C010_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Number> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast().value > now) {
                deque.pollLast();
            }
            deque.addLast(new Number(i, now));

            if (deque.peekFirst().order <= i - L)
                deque.pollFirst();

            bw.write(deque.peekFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Number {
    int order;
    int value;

    public Number(int order, int value) {
        this.order = order;
        this.value = value;
    }
}
