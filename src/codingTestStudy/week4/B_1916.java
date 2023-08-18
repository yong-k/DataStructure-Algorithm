package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
public class B_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시 개수
        int M = Integer.parseInt(br.readLine());    // 버스 개수

        ArrayList<Edge>[] list = new ArrayList[N + 1];
        int[] distance = new int[N + 1];            // 최단 거리 기록
        boolean[] visited = new boolean[N + 1];     // 방문 여부
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
           // 가중치 오름차순 정렬 정의
           return e1.weight - e2.weight;
        });

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());
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
        System.out.println(distance[endVertex]);
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