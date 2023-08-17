package doit_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C057_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCnt = Integer.parseInt(br.readLine());
        int busCnt = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] list = new ArrayList[cityCnt + 1];
        int[] distance = new int[cityCnt + 1];
        boolean[] visited = new boolean[cityCnt + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.weight - e2.weight;
        });

        for (int i = 1; i <= cityCnt; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        pq.add(new Edge(startCity, 0));
        distance[startCity] = 0;

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
        System.out.println(distance[endCity]);
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
