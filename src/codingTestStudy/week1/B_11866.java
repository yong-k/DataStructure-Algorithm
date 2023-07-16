package codingTestStudy.week1;

import java.util.*;
public class B_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append('<');
        for (int i = 1; i <= N; i++)
            queue.add(i);

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            if (cnt % K == 0)
                sb.append(queue.poll()).append(", ");
            else
                queue.add(queue.poll());
        }
        sb.delete(sb.length() - 2, sb.length()).append('>');
        System.out.println(sb);
    }
}
