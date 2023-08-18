package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
public class B_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수
        int startVertex = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] list = new ArrayList[V + 1];
        int[] distance = new int[V + 1];            // 최단거리 기록
        boolean[] visited = new boolean[V + 1];     // 방문 여부
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            // 가중치 오름차순 정렬 정의
            return e1.weight - e2.weight;
        });

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, w));
        }

        // 시작 정점 설정
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

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (visited[i])
                sb.append(distance[i]).append('\n');
            else
                sb.append("INF").append('\n');
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
