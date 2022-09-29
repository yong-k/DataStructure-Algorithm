// prim 알고리즘은 edge를 중심으로 했다면,
// 개선된 prim 알고리즘은 vertex(node)를 중심으로!
// 다익스트라처럼 하는 것

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// Edge 구성도 다름
class Edge4 implements Comparable<Edge4> {
    public String node;
    public int weight;

    public Edge4(String node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }

    @Override
    public int compareTo(Edge4 edge) {
        return this.weight - edge.weight;
    }
}

// 이렇게 Edge만 있으면 어디서부터 어디로 갔는지 표현이 안되니까 Path class 추가
class Path {
    public String node1;
    public String node2;
    public int weight;

    public Path(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
    }
}

public class T019_2_Prim_Improved {
    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> mst = new ArrayList<>();
        PriorityQueue<Edge4> keys = new PriorityQueue<>();
        HashMap<String, Edge4> keysObjects = new HashMap<>();   //-- 각각의 노드마다 해당 객체
        HashMap<String, String> mstPath = new HashMap<>();      //-- 어느 노드에서 어느 노드로 연결되는지 나타냄
        Edge4 edgeObject, poppedEdge, linkedEdge;
        Integer totalWeight = 0;
        HashMap<String, Integer> linkedEdges;

        // in JAVA
        // priorityQueue가 최소힙으로 되어있는데, 새로운 값을 넣어주거나 빼거나만 가능
        // 여기서는 중간에 값을 업데이트 해줌
        // 업데이트하면 최소힙의 구조를 유지하기가 어려움
        // 데이터를 넣거나 뺄 때, 값 비교해서 최소힙의 구조로 만드는데,
        // 중간에 있는 데이터를 바꾸면 최소힙의 구조가 유지되지 않는다.
        //--▷ 그래서,
        //     강제로 key가 업데이트 될 경우에는,
        //     해당 key 삭제 후, 다시 priorityQueue에 넣어주게끔 작성할 것이다.

        //--▷ priorityQueue에서 데이터를 삭제할 때, 해당 데이터 자체를 인자로 넘겨줘야 한다.
        //     여기서는, 삭제할 Edge 객체를 찝어줘야 한다.
        //     해당 객체를 각각의 key마다 따로 hashMap으로 저장해서
        //     해당 객체를 삭제할 필요가 있을 때에는
        //     해당 key에 대한 따로 저장되어 있는 객체 정보를 가져와서 priorityQueue에 넘겨줌

        // 다익스트라처럼 전체 노드 가져와서 최댓값으로 설정하고, startNode는 값 0으로 설정
        for (String key : graph.keySet()) {
            if (key == startNode) {
                // 각각의 Edge는 별도의 Edge객체로 따로 만들어준다.
                edgeObject = new Edge4(key, 0);

                // edge 정보로만은, 어느 노드에서 어느 노드로 연결되는지 알 수 없음
                // 그 정보를 따로 관리하기 위해서 mstPath에 각각의 노드가 어느 노드로 연결되는지 저장
                mstPath.put(key, key);
                //--▷ startNode(맨 처음에 선택된 노드)는
                //   자신의 노드로만 지금 접근하는 상태니까 해당 key값으로 넣음

            } else {
                edgeObject = new Edge4(key, Integer.MAX_VALUE);

                // 처음에는 어느 노드로 연결된다는 정보 없으니까 null 넣음
                mstPath.put(key, null);
            }

            // 우선순위 큐에는 edge객체를 넣어준다.
            keys.add(edgeObject);

            // keysObject라는 별도의 hashMap을 만들어서,
            // 각각의 key마다 edgeObject 객체 자체를 만들어서, 필요할 때 불러서 쓸 예정
            keysObjects.put(key, edgeObject);
        }

        // 전체 노드의 수만큼 반복됨
        while (keys.size() > 0) {
            // 현재 노드 중에서 가장 key 값이 작은 걸 빼옴
            poppedEdge = keys.poll();
            //--▷ keys 우선순위 큐에서는 자동으로 삭제되지만,
            //     poppedEdge에 들어가있는 Edge정보를 가지고 있는
            //     keysObjects에서는 삭제가 자동으로 안되기 때문에 삭제해줘야함
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));

            // +) 전체 최소신장트리 가중치의 합 출력 위해서
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node);
            //            --------------------------
            //            └→ poppedEdge에 대한 HashMap을 가져옴
            //--▷ linkedEdges: 인접간선정보

            // linkedEdges(인접간선정보)를 순회 → 간선들이 하나씩 나옴
            for (String adjacent : linkedEdges.keySet()) {
                // keysObjects → 아직 체크되지 않은 노드들이 다 들어가있음
                if (keysObjects.containsKey(adjacent)) {
                    // 해당 key에 대한 객체를 가져옴
                    linkedEdge = keysObjects.get(adjacent);
                    //--▷ 초기에는 다 최댓값이 들어가 있을 것이다.

                    if (linkedEdges.get(adjacent) < linkedEdge.weight) {
                        // weight 정보 update → mst 로 등록
                        linkedEdge.weight = linkedEdges.get(adjacent);

                        // mst에 등록
                        mstPath.put(adjacent, poppedEdge.node);
                        //--> adjacent 노드는 poppedEdge.node와 연결된다는 뜻

                        // 값을 업데이트 해줬으니 우선순위 큐를 다시 최소힙의 구조로 만들어줘야 함
                        //--▷ 해당 값을 삭제하고 다시 넣어줄 거임
                       keys.remove(linkedEdge);
                       keys.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println(totalWeight);
        return mst;
    }

    public static void main(String[] args) {

        // HashMap에 ArrayList로 나타내는 게 아니라,
        // HashMap안에 HashMap으로 나타낼 계획

        // 현재 노드에서 → 어느 노드로 어떤 weight를 가진 간선을 가지고 있는지
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();

        HashMap<String, Integer> edges;
        edges = new HashMap<>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);
        //--▷ 간선 AB(weight=7), 간선 AD(weight=5) 넣은 거임!

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        T019_2_Prim_Improved prim = new T019_2_Prim_Improved();
        System.out.println(prim.improvedPrimFunc(mygraph, "A"));
    }
}
