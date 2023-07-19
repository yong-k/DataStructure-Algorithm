package tony_git.data_structure2;

import java.util.*;
public class B_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2))
                return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == 0 && pq.isEmpty())
                sb.append("0\n");
            else if (n == 0)
                sb.append(pq.poll()).append('\n');
            else
                pq.add(n);
        }
        System.out.println(sb);
    }
}
