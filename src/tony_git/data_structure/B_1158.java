package tony_git.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 큐에 1 ~ N번까지 사람 추가
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.add(i);

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            if (count % K == 0)
                sb.append(queue.poll()).append(", ");
            else
                queue.add(queue.poll());

            count++;
        }
        sb.replace(sb.length() - 2, sb.length(), ">");
        System.out.println(sb);
    }
}
