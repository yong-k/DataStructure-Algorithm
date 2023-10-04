package tony_git.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2))
                return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            else
                pq.add(input);
        }
        System.out.print(sb);
    }
}
