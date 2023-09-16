package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 큐에 1 ~ N까지 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.add(i);

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            if (count == K) {
                sb.append(queue.poll()).append(", ");
                count = 1;
            } else {
                queue.add(queue.poll());
                count++;
            }
        }
        sb.replace(sb.length() - 2, sb.length(), ">");
        System.out.println(sb);
    }
}
