package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
public class B_10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());               // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken());               // 의존성 개수
            int startComputer = Integer.parseInt(st.nextToken());   // 해킹당한 컴퓨터 번호

            ArrayList<Edge>[] list = new ArrayList[n + 1];
            int[] infection = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) ->  {
               // 감염 시간 기준 오름차순 정렬
               return e1.weight - e2.weight;
            });

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                infection[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());   // a가 b를 의존
                int s = Integer.parseInt(st.nextToken());   // b 감염 s초 후, a도 감염

                list[b].add(new Edge(a, s));
            }

            pq.add(new Edge(startComputer, 0));
            infection[startComputer] = 0;
            while (!pq.isEmpty()) {
                Edge now = pq.poll();
                int nowVertex = now.endVertex;

                if (visited[nowVertex]) continue;
                visited[nowVertex] = true;

                for (int i = 0; i < list[nowVertex].size(); i++) {
                    Edge temp = list[nowVertex].get(i);
                    int nextVertex = temp.endVertex;
                    int weight = temp.weight;

                    if (infection[nextVertex] > infection[nowVertex] + weight) {
                        infection[nextVertex] = infection[nowVertex] + weight;
                        pq.add(new Edge(nextVertex, infection[nextVertex]));
                    }
                }
            }

            int count = 0;
            int maxTime = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) count++;
                if (infection[i] != Integer.MAX_VALUE)
                    maxTime = Math.max(maxTime, infection[i]);
            }
            sb.append(count).append(' ').append(maxTime).append('\n');
        }
        System.out.print(sb);
    }
}

class Edge {
    int endVertex;
    int weight;

    public Edge(int endVertex, int weight) {
        this.endVertex = endVertex;
        this.weight = weight;
    }
}
 */
