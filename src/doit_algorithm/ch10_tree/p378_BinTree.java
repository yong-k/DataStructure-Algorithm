package doit_algorithm.ch10_tree;

import java.util.Comparator;

public class p378_BinTree<K,V> {
    static class Node<K,V> {
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key, V data, Node<K,V> left, Node<K,V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        // 키 값을 반환
        K getKey() {
            return key;
        }

        // 데이터를 반환
        V getValue() {
            return data;
        }

        // 데이터를 출력
        void print() {
            System.out.println(data);
        }
    }

    private Node<K,V> root;                             // 루트
    private Comparator<? super K> comparator = null;    // 비교자

    // 생성자1: 비어 있는 이진검색트리 생성, 자연 순서에 따라 키 값을 비교
    //-- K 타입이 Comparable() 구현하고 있는 Integer, String... 등에 알맞음!
    public p378_BinTree() {
        root = null;
    }

    // 생성자2: 비어 있는 이진검색트리 생성, 비교자로 키 값을 비교
    public p378_BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    // 두 키 값을 비교
    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
                : comparator.compare(key1, key2);
    }

    // 키에 의한 검색
    public V search(K key) {
        Node<K,V> p = root;

        while (true) {
            if (p == null)
                return null;
            int cond = comp(key, p.getKey());

            // 같으면 검색 성공
            if (cond == 0)
                return p.getValue();
            // key가 작으면 왼쪽 서브 트리로
            else if (cond < 0)
                p = p.left;
            // key가 크면 오른쪽 서브 트리로
            else
                p = p.right;
        }
    }

    // node를 루트로 하는 서브 트리에 노드<K,V>를 삽입
    private void addNode(Node<K,V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0)
            return;     // key가 이미 존재함 (삽입할 수 없음)
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<K,V>(key, data, null, null);
            else
                addNode(node.left, key, data);
        } else {
            if (node.right == null)
                node.right = new Node<K,V>(key, data, null, null);
            else
                addNode(node.right, key, data);
        }
    }

    // 노드 삽입
    public void add(K key, V data) {
        if (root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    // 키 값이 key인 노드 삭제
    public boolean remove(K key) {
        Node<K,V> p = root;             // 스캔 중인 노드
        Node<K,V> parent = null;        // 스캔 중인 노드의 부모 노드
        boolean isLeftChild = true;     // p는 부모의 왼쪽 자식 노드?

        // 삭제할 key 검색
        while (true) {
            if (p == null)
                return false;
            int cond = comp(key, p.getKey());
            if (cond == 0)
                break;
            else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        // 노드 삭제
        // 1) 자식 노드 없는 경우 & 자식 노드 1개인 경우
        if (p.left == null) {
            if (p == root)
                root = p.right;
            else if (isLeftChild)
                parent.left = p.right;
            else
                parent.right = p.right;
        } else if (p.right == null) {
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left = p.left;
            else
                parent.right = p.left;

        // 2) 자식 노드가 2개인 경우
        } else {
            parent = p;
            Node<K,V> left = p.left;    // 서브 트리 가운데 가장 큰 노드
            isLeftChild = true;

            // 가장 큰 노드 left를 검색
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            // left의 key, data를 p로 옮김
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild)
                parent.left = left.left;    // left 삭제
            else
                parent.right = left.left;   // left 삭제
        }
        return true;
    }

    // node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력 (재귀메서드)
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);    // 왼쪽 서브 트리를 키 값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data);     // node 출력
            printSubTree(node.right);   // 오른쪽 서브 트리를 키 값의 오름차순으로 출력
        }
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }

    // p392-Q1
    // 모든 노드를 키 값의 내림차순으로 출력
    private void printReverseSubTree(Node node) {
        if (node != null) {
            printReverseSubTree(node.right);
            System.out.println(node.key + " " + node.data);
            printReverseSubTree(node.left);
        }
    }
    public void printReverse() {
        printReverseSubTree(root);
    }


    // p392-Q2 : getMinKey(), getDataWithMinKey(), gitMaxKey(), getDataWithMaxKey()
    // 가장 작은 키 값을 반환
    public K getMinKey() {
        if (root == null)
            return null;
        else {
            Node<K,V> node = root;
            if (node.left != null)
                node = node.left;
            return node.getKey();
        }
    }
    // 가장 작은 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMinKey() {
        K key = getMinKey();
        V data = search(key);
        return data;
    }

    // 가장 큰 키 값을 반환
    public K getMaxKey() {
        if (root == null)
            return null;
        else {
            Node<K,V> node = root;
            while (node.right != null)
                node = node.right;
            return node.getKey();
        }
    }
    // 가장 큰 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMaxKey() {
        K key = getMaxKey();
        V data = search(key);
        return data;
    }

    public static void main(String[] args) {
        p378_BinTree<Integer, String> bt = new p378_BinTree<>();
        bt.add(5, "나");
        bt.add(2, "가");
        bt.add(8, "라");
        bt.add(7, "다");
        bt.add(9, "마");
        bt.print();
        System.out.println();
        bt.printReverse();

        System.out.println();
        System.out.println("최소 키 값: " + bt.getMinKey());
        System.out.println("ㄴ→ 데이터 = " + bt.getDataWithMinKey());
        System.out.println("최대 키 값: " + bt.getMaxKey());
        System.out.println("ㄴ→ 데이터 = " + bt.getDataWithMaxKey());
    }
}
