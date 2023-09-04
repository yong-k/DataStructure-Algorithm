package z_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 컴퓨터개수
            int d = Integer.parseInt(st.nextToken());   // 의존성개수
            int startVertex = Integer.parseInt(st.nextToken());

            ArrayList<Edge>[] list = new ArrayList[n + 1];
            int[] distance = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
                return e1.weight - e2.weight;
            });

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Edge(a, s));
            }

            pq.add(new Edge(startVertex, 0));
            distance[startVertex] = 0;
            while (!pq.isEmpty()) {
                Edge now = pq.poll();
                int nowVertex = now.endVertex;

                if (visited[nowVertex]) continue;
                visited[nowVertex] = true;

                for (int i = 0; i < list[nowVertex].size(); i++) {
                    Edge temp = list[nowVertex].get(i);
                    int nextVertex = temp.endVertex;
                    int weight = temp.weight;

                    if (distance[nextVertex] > distance[nowVertex] + weight) {
                        distance[nextVertex] = distance[nowVertex] + weight;
                        pq.add(new Edge(nextVertex, distance[nextVertex]));
                    }
                }
            }

            int infectionCnt = 0;
            int maxTime = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (visited[i])
                    infectionCnt++;
                if (distance[i] != Integer.MAX_VALUE)
                    maxTime = Math.max(maxTime, distance[i]);
            }
            sb.append(infectionCnt).append(' ').append(maxTime).append('\n');
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
