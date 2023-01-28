package baekjoon_step.Step24_priorityQueue;

import java.io.*;
import java.util.*;

public class B_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

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
