package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T015_DFS {
    // 깊이 우선 탐색 (Depth-First Search)
    // DFS 시간복잡도: O(V+E) : 전체 노드(Vertex)와 간선(dataStructure.Edge)을 한 번 다 훑기 때문에
    // needVisit 스택, visted 큐 사용해서 구현 (스택, 큐 사용)
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();

        needVisit.add(startNode);
        int count = 0;

        while (needVisit.size() > 0) {
            count++;

            // BFS와 이 부분만 다름 (큐 → 스택)
            String node = needVisit.remove(needVisit.size() - 1);

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

        T015_DFS dfs = new T015_DFS();
        System.out.println(dfs.dfsFunc(graph, "A"));
    }
}
