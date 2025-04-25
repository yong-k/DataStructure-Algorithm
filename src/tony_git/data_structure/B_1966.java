package tony_git.data_structure;

import java.util.*;
public class B_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int documentCount;
        int findNum;

        // 중요도를 담은 우선순위큐를 하나 만들어서, 이번 문서가 우선순위큐 앞에있는거와 같으면 poll
        Queue<Document> queue;
        PriorityQueue<Integer> pq;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            documentCount = sc.nextInt();
            findNum = sc.nextInt() + 1;
            queue = new LinkedList<>();
            pq = new PriorityQueue<>((o1, o2) -> {
                return o2 - o1;
            });

            for (int j = 1; j <= documentCount; j++) {
                int priority = sc.nextInt();
                queue.add(new Document(j, priority));
                pq.add(priority);
            }

            int cnt = 1;
            while (!queue.isEmpty()) {
                Document now = queue.poll();
                // 번호 같은지도 봐야되지만, 우선순위가 같은지도 봐야함
                if (now.priority == pq.peek()) {
                    if (now.num == findNum) {
                        sb.append(cnt).append('\n');
                        break;
                    }
                    pq.poll();
                    cnt++;
                } else {
                    queue.add(now);
                }
            }
        }
        System.out.println(sb);
    }
}

class Document {
    int num;
    int priority;

    Document(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
}
