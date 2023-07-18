package tony_git.data_structure;

import java.util.*;
public class B_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int checkNum = sc.nextInt();
            Queue<Document> que = new LinkedList<>();
            PriorityQueue<Document> pq = new PriorityQueue<>((o1, o2) -> {
                return o2.priority - o1.priority;
            });

            for (int j = 0; j < N; j++) {
                int priority = sc.nextInt();
                que.add(new Document(j, priority));
                pq.add(new Document(j, priority));
            }

            int count = 1;
            while (!que.isEmpty()) {
                Document now = que.poll();
                if (now.priority == pq.peek().priority) {
                    if (now.order == checkNum) {
                        sb.append(count).append('\n');
                        break;
                    }
                    pq.poll();
                    count++;
                } else {
                    que.add(now);
                }
            }
        }
        System.out.println(sb);
    }

    static class Document {
        int order;
        int priority;

        public Document(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
