package baekjoon_step.Step24_priorityQueue;

import java.io.*;
import java.util.*;

public class B_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (pq.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            } else
                pq.add(request);
        }
        System.out.println(sb.toString());
    }
}
