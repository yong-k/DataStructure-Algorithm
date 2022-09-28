import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// 최단 경로 알고리즘 - 다익스트라 알고리즘
// 방향이 있는 가중치 그래프
// BFS와 유사: 연결된 노드들 먼저 확인하는 측면에서
//--▷ 우선순위 큐 사용 (최소힙의 로직을 가진 큐)
class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}

public class T017_DijkstraAlgorithm {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode;              //--우선순위큐에서 poll() 한 거 저장할 변수
        int currentDistance;        //-- edgeNode의 distance 정보 저장할 변수
        String currentNode;         //-- edgeNode의 vertex 정보 저장할 변수
        ArrayList<Edge> nodeList;   //-- currentNode에 연결되어 있는 edge들을 저장할 리스트
        Edge adjacentNode;          //-- currentNode에 연결되어 있는 edge 저장할 변수
        int weight;                 //-- adjacentNode의 distance 정보 저장할 변수
        String adjacent;            //-- adjacentNode의 vertex 정보 저장할 변수
        int distance;               //-- currentDistance(edgeNode의 distance) + weight(adjacentNode의 distance)

        // 시작 정점에서 각 정점까지의 거리를 저장할 HashMap
        HashMap<String, Integer> distances = new HashMap<>();

        for (String key : graph.keySet())
            distances.put(key, Integer.MAX_VALUE);  // 다 무한대로 초기화

        distances.put(start, 0);    // 첫 정점 거리는 0, 나머지는 무한대로 저장

        // 이제 우선순위 큐 만들어야 함
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();        // 최소거리 가진 edge 뽑음
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            // 현재 edge의 distance(=currentDistance)가
            // 지금까지의 최단거리를 가지고 있는 distance 배열의 해당 노드에 대한 distance보다
            // 더 큰 값을 가지고 있으면 → 더 이상 계산 진행 안해도 됨(skip)
            if (distances.get(currentNode) < currentDistance)
                continue;

            // 이제 graph에서 currentNode에 연결되어 있는 edge 정보를 가지고 와서 계산해야함
            //→ 해당 리스트를 가져와야 함
            nodeList = graph.get(currentNode);
            for (int i = 0; i < nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                // distance가 기존 distance 배열에 저장해놓은 최단거리보다 짧으면
                // distance배열과 우선순위 큐에 업데이트 해줘야 함함
                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);                  // distance배열 update
                    priorityQueue.add(new Edge(distance, adjacent));    // priorityQueue에 정보 추가
                }
            }
       }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        T017_DijkstraAlgorithm dijkstra = new T017_DijkstraAlgorithm();
        System.out.println(dijkstra.dijkstraFunc(graph, "A"));
    }
}


