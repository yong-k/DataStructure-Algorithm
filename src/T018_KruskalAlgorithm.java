import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Edge2 implements Comparable<Edge2> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge2(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge2 edge) {
        return this.weight - edge.weight;
    }
}

public class T018_KruskalAlgorithm {
    HashMap<String, String> parent = new HashMap<>();
    //--▷ 내 노드(key)를 넣으면 부모 노드(value)를 return하는 hashMap
    HashMap<String, Integer> rank = new HashMap<>();
    //--▷ 내 노드(key)의 랭크 번호(value)를 return하는 hashMap

    // find() : 매개변수로 받은 node의 루트노드를 return
    public String find(String node) {
        // 원래는 아래처럼 재귀용법으로 구현해야 하는데,
        /*
        //--노드의 부모노드를 가져왔는데 본인이면, 본인이 루트라는 말
        if (parent.get(node) != node)
            return find(parent.get(node));
        */
        // path compression 기법 사용 시, 안 그래도 됨
        // path compression 기법
        //--▷ 내 부모 노드가 루트 노드가 아니면,
        //     루트 노드를 찾아서 바로 루트 노드에 연결시켜서 랭크 낮춰줌
        if (parent.get(node) != node)
            return parent.put(node, find(parent.get(node)));
            //-- 현재 노드가 루트노드가 아니라면,
            //   [현재 노드의 부모노드]를 [부모노드의 부모노드를 찾게]끔 setting 해줌

        return parent.get(node);
        //-- 루트를 리턴해줌 & path compression 적용돼서 높이는 확 줄음
    }

    // union(): nodeV와 nodeU를 이어줌
    // nodeV와 nodeU를 연결해도 사이클이 생기지 않을 때, union() 호출된다고 전제
    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        // 1) 높이가 다를 때는, 높이가 큰 쪽에 붙여라
        // 2) 높이가 같다면, 한 쪽의 높이를 하나 높여준 다음에 붙여라
        if (rank.get(root1) > rank.get(root2))
            parent.put(root2, root1);   // root2의 부모노드를 root1으로 연결
        else {  // root2의 rank가 더 크거나 root1과 root2의 rank가 같은 경우
            parent.put(root1, root2);

            // 만약, 둘의 rank가 같다면, root2의 rank를 하나 높임
           if (rank.get(root1) == rank.get(root2))
                rank.put(root2, rank.get(root2) + 1);
        }
    }

    // 초기화 메서드: union-find 사용하기 위해서,
    //              맨 처음에는 n개의 원소를 모두 개별적인 집합으로 분리해야 함
    //-- 노드들의 리스트를 가지고 있는 vetices를 반복문으로 돌며
    //   makeSet() 메서드를 각 노드만큼 호출해주면 초기화된다.
    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }


    // 매개변수로 그래프 정보를 받음
    // vetices : 노드들 리스트
    // edges   : 간선들 리스트
    public ArrayList<Edge2> kruskalFunc(ArrayList<String> vetices, ArrayList<Edge2> edges) {
        ArrayList<Edge2> mst = new ArrayList<>();    // 간선리스트의 배열
        Edge2 currentEdge;

        // 1) 초기화
        for (int i = 0; i < vetices.size(); i++)
            makeSet(vetices.get(i));

        // 2) 간선리스트의 간선들을 weight 기반으로 sorting
        Collections.sort(edges);

        // 정렬된 edge들을 하나씩 순회
        for (int i = 0; i < edges.size(); i++) {
            // 맨 앞에 있는 건 weight 값이 가장 작을 거임
            // 그것부터 추출해서 currentEdge에 넣어줌
            currentEdge = edges.get(i);

            // currentEdge의 nodeV의 루트노드와 nodeU의 루트노드가 다르다면,
            // --▷ 사이클이 없는 것! --▷ 그 때만 합쳐라 (union() 메서드 호출)
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);

                // 해당 간선 선택한 것이니까, mst 리스트에 추가
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {

        // 그래프에서 연결해야 하는 모든 노드를 리스트로 관리
        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        ArrayList<Edge2> edges = new ArrayList<>();
        edges.add(new Edge2(7, "A", "B"));
        edges.add(new Edge2(5, "A", "D"));
        edges.add(new Edge2(7, "B", "A"));
        edges.add(new Edge2(8, "B", "C"));
        edges.add(new Edge2(9, "B", "D"));
        edges.add(new Edge2(7, "B", "E"));
        edges.add(new Edge2(8, "C", "B"));
        edges.add(new Edge2(5, "C", "E"));
        edges.add(new Edge2(5, "D", "A"));
        edges.add(new Edge2(9, "D", "B"));
        edges.add(new Edge2(7, "D", "E"));
        edges.add(new Edge2(6, "D", "F"));
        edges.add(new Edge2(7, "E", "B"));
        edges.add(new Edge2(5, "E", "C"));
        edges.add(new Edge2(7, "E", "D"));
        edges.add(new Edge2(8, "E", "F"));
        edges.add(new Edge2(9, "E", "G"));
        edges.add(new Edge2(6, "F", "D"));
        edges.add(new Edge2(8, "F", "E"));
        edges.add(new Edge2(11, "F", "G"));
        edges.add(new Edge2(9, "G", "E"));
        edges.add(new Edge2(11, "G", "F"));

        T018_KruskalAlgorithm kruskal = new T018_KruskalAlgorithm();
        System.out.println(kruskal.kruskalFunc(vetices, edges));
    }
}
