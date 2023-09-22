package tony_git.data_structure;

import java.io.*;
import java.util.*;
public class B_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Document> pq = new PriorityQueue<>((d1, d2) -> {
                return d2.priority - d1.priority;
            });

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority));
                pq.add(new Document(i, priority));
            }

            // document의 order와 M이 같은 걸 찾으면 된다.
            int count = 1;
            while (!queue.isEmpty()) {
                Document now = queue.poll();
                if (now.priority == pq.peek().priority) {
                    if (now.order == M) {
                        sb.append(count).append('\n');
                        break;
                    }
                    pq.poll();
                    count++;
                } else {
                    queue.add(now);
                }
            }
        }
        System.out.print(sb);
    }
}

class Document {
    int order;
    int priority;

    public Document(int order, int priority) {
        this.order = order;
        this.priority = priority;
    }
}
