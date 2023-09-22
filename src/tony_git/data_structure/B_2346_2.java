package tony_git.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_2346_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        Balloon now = deque.removeFirst();
        sb.append(now.order).append(' ');

        while (!deque.isEmpty()) {
            int paperNum = now.paper;
            if (paperNum > 0) {
                for (int i = 1; i < paperNum; i++)
                    deque.addLast(deque.removeFirst());
            } else {
                for (int i = paperNum; i < 0; i++)
                    deque.addFirst(deque.removeLast());
            }
            now = deque.removeFirst();
            sb.append(now.order).append(' ');
        }
        System.out.println(sb);
    }
}

class Balloon {
    int order;
    int paper;

    public Balloon(int order, int paper) {
        this.order = order;
        this.paper = paper;
    }
}

