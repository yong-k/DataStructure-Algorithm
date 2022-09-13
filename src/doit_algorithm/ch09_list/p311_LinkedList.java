package doit_algorithm.ch09_list;

import java.util.Comparator;

// 실습 9-1: 연결 리스트 클래스
public class p311_LinkedList<E> {
    // 노드
    class Node<E> {
        private E data;         // 데이터
        private Node<E> next;   // 다음 노드를 가리키는 포인터

        // 생성자
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head = null;    // 머리 노드 (머리 노드에 대한 참조! 머리 노드 그 자체 아님!)
    private Node<E> crnt = null;    // 현재 선택한 노드 (검색/삭제 등의 용도로 사용)

    // 생성자
    public p311_LinkedList() {
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> node = head;

        while (node != null) {
            // 검색 성공
            if (c.compare(obj, node.data) == 0) {
                crnt = node;
                return node.data;
            }
            // 다음 노드 대입
            node = node.next;
        }
        // 검색 실패
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> node = head;
        // head에 새로운 노드 넣어주고, next에 기존 head 넣어줌
        head = crnt = new Node<E>(obj, node);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> node = head;
            while (node.next != null)
                node = node.next;
            //-- while문 종료 시, node는 꼬리 노드를 가리킴
            node.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드 삭제
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        if (head != null) {
            // 머리노드가 꼬리노드일 때,
            if (head.next == null)
                removeFirst();
            else {
                Node<E> node = head;
                Node<E> nodePrev = head;
                while (node.next != null) {
                    nodePrev = node;
                    node = node.next;
                }
                //-- while문 종료 시, node는 꼬리 노드를, nodePrev는 꼬리 노드의 앞 노드를 가리킴
                nodePrev.next = null;
                crnt = nodePrev;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else {
                Node<E> node = head;
                while (node.next != p) {
                    node = node.next;
                    if (node == null)   return;     // p가 리스트에 없음
                }
                node.next = p.next;
                crnt = node;
            }
        }
    }

    // 선택 노드(crnt)를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        // 노드에 아무것도 없을 때까지 머리노드를 삭제
        while (head != null)
            removeFirst();
        crnt = null;
    }

    // 선택 노드(crnt)를 하나 뒤의 노드로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    // 선택 노드(crnt)를 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택 노드 없음");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드를 출력
    public void dump() {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // p331-Q1: 서로 같은 노드를 찾아 모두 삭제
    // comparator
    /*
    public void purge(Comparator <? super E> c) {
        Node<E> choice = head;  // 선택 노드
        Node<E> ptr = head;     // 다음칸으로 이동하며 선택노드와 비교

        while (choice != null) {
            ptr = choice.next;
            while (ptr != null) {
                if (c.compare(choice.data, ptr.data) == 0) {
                    Node<E> temp = ptr.next;
                    remove(ptr);
                    ptr = temp;
                }
                ptr = ptr.next;
            }
            choice = choice.next;
        }
        crnt = head;
    }
    */
    // int일 때로 테스트진행
    public void purge() {
        Node<E> choice = head;  // 선택 노드
        Node<E> ptr = head;     // 다음칸으로 이동하며 선택노드와 비교

        while (choice != null) {
            ptr = choice.next;
            while (ptr != null) {
                if (choice.data == ptr.data) {
                    Node<E> temp = ptr.next;
                    remove(ptr);
                    ptr = temp;
                }
                else
                    ptr = ptr.next;
            }
            choice = choice.next;
        }
        crnt = head;
    }

    // p331-Q2: 머리(0)부터 n번째 노드에 대한 참조 반환 → 머리로부터 n번째 노드 가져옴
    // -- (n이 음수거나 노드 개수보다 크거나 같으면 null 반환)
    public E retrieve(int n) {
        if (n < 0)
            return null;

        int count = 0;
        Node<E> node = head;
        for (; count < n; count++) {
            if (node.next == null) return null;
            node = node.next;
        }
        return node.data;
    }

    public static void main(String[] args) {
        p311_LinkedList<Integer> list = new p311_LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(3);
        list.addLast(5);
        list.addLast(3);
        list.addLast(6);
        list.addLast(3);
        list.addLast(7);
        list.addLast(2);
        list.dump();
        list.purge();
        list.dump();
        System.out.println(list.retrieve(3));
        System.out.println(list.retrieve(6));
        System.out.println(list.retrieve(-1));
        System.out.println(list.retrieve(7));
    }
}
