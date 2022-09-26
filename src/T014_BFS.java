// · ArrayList에서 요소 모두 추가하기 → list.addAll();

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T014_BFS {
    // 너비 우선 탐색 (Breadth-First Search)
    // BFS 시간복잡도: O(V+E) : 전체 노드(Vertex)와 간선(Edge)을 한 번 다 훑기 때문에
    // needVisit 큐, visted 큐 사용해서 구현 (2개의 큐 사용)

    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);
        int count = 0;

        while (needVisit.size() > 0) {
            count++;
            String node = needVisit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println(count);
        return visited;
    }

    public static void main(String[] args) {
        // 그래프 생성(HashMap, ArrayList 사용)
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        T014_BFS bfs = new T014_BFS();
        System.out.println(bfs.bfsFunc(graph, "A"));
    }
}
