package dataStructure;

public class T004_1_LinkedList {
    public static class Node<T> {
        // Node 안에는
        T data;                 // 데이터
        Node<T> next = null;    // 다음 객체를 가리키는 포인터

        // 생성자
        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        //-- 아직은 LinkedList 아님. node1이 node2를 가리키고 있어야 함
        node1.next = node2;
        //-- 어느 Node가 head(시작)인지도 표시해야 함
        Node<Integer> head = node1;
    }
}