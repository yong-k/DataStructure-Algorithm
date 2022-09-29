import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Edge3 implements Comparable<Edge3> {
    public int weight;
    public String node1;
    public String node2;

    public Edge3(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }

    @Override
    public int compareTo(Edge3 edge) {
        return this.weight - edge.weight;
    }
}

public class T019_1_PrimAlgorithm {
    // 매개변수
    // StartNode: prim 알고리즘은 시작 정점 하나 정해놓고 시작하니까
    // edges: edge 정보 담고 있는 리스트
    public ArrayList<Edge3> primFunc(String startNode, ArrayList<Edge3> edges) {

        // 연결된 노드의 집합(string vertex 저장)
        ArrayList<String> connectedNodes = new ArrayList<>();

        // 최소신장트리 저장(선택한 간선의 리스트)
        ArrayList<Edge3> mst = new ArrayList<>();

        // 간선에 연결된 노드들
        // 각각의 노드마다 거기에 연결된 간선들의 데이터를 배열로 저장
        // 노드 값(key) - 해당 노드에 연결된 간선(value)
        HashMap<String, ArrayList<Edge3>> adjacentEdges = new HashMap<>();

        Edge3 currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge3> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge3> priorityQueue;

        // 초기화
        for (int i = 0; i < edges.size(); i++) {
            // 간선리스트(edges)에서 간선의 정보를 빼와서
            // 해당 간선에 써있는 노드들을 다 파악해서
            // hashMap(adjacentEdges)의 key로 만들기 위함
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.node1))
                // 각각의 리스트들을 초기 array 형태로 만들어놓음
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge3>());
            if (!adjacentEdges.containsKey(currentEdge.node2))
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge3>());

            // node1과 node2를 중복되지 않게 다 hashMap에 넣으면 key들은 다 들어갔음
        }

        // 이제 각각의 노드마다 연결된 간선 리스트를 추가해야 된다.
        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);

            // adjacentEdges에 만들어져있는 비어있는 초기 arraylist를 가져옴
            // add() 해서 각각의 간선을 넣기 위해서
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge3(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge3(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        // connectedNodes에 지금까지 연결된 노드를 넣음
        // 일단 처음에는 startNode가 선택된 상태니까 그걸 넣음
        connectedNodes.add(startNode);

        // 해당 노드에 연결된 모든 간선들을 candidateEdgeList에 추가
        // 해당 노드에 연결된 모든 간선들의 정보는 adjacentEdges에 있음
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge3>());
        //--▷ 혹시라도 해당 노드에 연결된 것이 없으면 에러날 수 있으니
        //   빈 arrayList라도 return 하도록 getOrDefault() 사용

        priorityQueue = new PriorityQueue<Edge3>();
        for (int i = 0; i < candidateEdgeList.size(); i++)
            priorityQueue.add(candidateEdgeList.get(i));


        // 큐에 간선이 없으면 끝
        while(priorityQueue.size() > 0) {
            // 최소 weight를 가진 간선을 가져옴
            poppedEdge = priorityQueue.poll();

            // Edge에서 node1, node2가 있는데 node1자리에 들어가는건 자기 자신임
            // ex) node "A"기준으로 연결된 node "B"와 연결된 간선 "A-B"가 있다고 하면
            // Edge(weight, "A", "B"); 이렇게 들어가는 것!

            // 그래서 우선순위 큐에서 poll()로 가져온
            // poppedEdge의 node1은 이미 connectedNodes에 들어가있는 건 확실하고
            // 걔랑 연결된 node2가 connectedNodes에 들어가있는지는 확실하지 않아서
            // 들어가있는지 체크해 봐야함!!
            //--▷ node2도 connectedNodes에 들어가있다면,
            //    연결하면 사이클이 생기는 것이니까, 아무 작업도 할 필요 없음
            //--▷ node2가 connectedNodes에 없다면, edge를 mst에 추가해주면 됨
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge를 mst에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge3(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                // 해당 간선에 새로 연결된 node2에! 연결된 간선들이 또 있을 것임
                // node2에 연결된 간선들 → adjacentEdges 해쉬맵에 있음
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge3>());
                //--▷ 혹시라도 해당 노드에 연결된 것이 없으면 에러날 수 있으니
                //   빈 arrayList라도 return 하도록 getOrDefault() 사용

                for (int i = 0; i < adjacentEdgeNodes.size(); i++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(i);

                    // 새로운 노드(node2)에 연결된 모든 간선들(adjacentEdgeNodes)을
                    // 모두 priorityQueue에 넣어도 되기는 하지만,
                    // 아예 넣을 때 의미 없는 건 안 넣어주면 됨
                    //--▷ 의미 없는 것: 이미 connectedNodes(연결된 노드 집합)에 있는 노드들끼리 연결된 것들은
                    //                 연결하면 cycle이 생기니까 빼줌

                    // poppedEdge.node2와 여기서의 adjacentEdgeNode.node2는 다른 것
                    //-----------------          -----------------------
                    //     "A-B"의 B                  "B-C"의 C
                    //--▷ poppedEdge.node2와 연결되는 또 다른 노드를 말함
                    if (!connectedNodes.contains(adjacentEdgeNode.node2))
                        priorityQueue.add(adjacentEdgeNode);
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {

        // 간선리스트
        ArrayList<Edge3> myedges = new ArrayList<>();
        myedges.add(new Edge3(7, "A", "B"));
        myedges.add(new Edge3(5, "A", "D"));
        myedges.add(new Edge3(8, "B", "C"));
        myedges.add(new Edge3(9, "B", "D"));
        myedges.add(new Edge3(7, "D", "E"));
        myedges.add(new Edge3(5, "C", "E"));
        myedges.add(new Edge3(7, "B", "E"));
        myedges.add(new Edge3(6, "D", "F"));
        myedges.add(new Edge3(8, "E", "F"));
        myedges.add(new Edge3(9, "E", "G"));
        myedges.add(new Edge3(11, "F", "G"));

        T019_1_PrimAlgorithm prim = new T019_1_PrimAlgorithm();
        System.out.println(prim.primFunc("A", myedges));
    }
}
