package doit_algorithm.ch09_list;

import java.util.Comparator;

// 실습 9-5: 원형 이중 연결 리스트
public class p349_DblLinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = null;
        }

        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;    // 머리 노드(더미 노드)
    //--> 노드의 삽입/삭제 처리를 원활하게 하도록 리스트의 머리에 계속 존재하는 더미 노드
    private Node<E> crnt;

    public p349_DblLinkedList() {
        head = crnt = new Node<E>();    // 더미 노드를 생성
    }

    // 리스트가 비어 있는가?
    public boolean isEmpty() {
        return head.next == head;
    }

    // 노드를 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;    // 현재 스캔 중인 노드
        //-- 실질적은 머리노드는 더미 노드의 다음 노드이므로 검색 시작 → head.next 부터!

        while (ptr != head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 선택 노드를 출력
    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("선택 노드 없음");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드 출력
    public void dump() {
        Node<E> ptr = head.next;    // 더미 노드의 다음 노드 (실질적 머리노드)

        // ptr이 더미노드가 아닐 때 까지 반복
        while (ptr != head) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    // 모든 노드를 거꾸로 출력
    public void dumpReverse() {
        Node<E> ptr = head.prev;    // 더미 노드의 앞쪽 노드

        while (ptr != head) {
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        }
        System.out.println();
    }

    // 선택 노드를 하나 뒤로 이동
    public boolean next() {
        if (isEmpty() || crnt.next == head)
            return false;
        crnt = crnt.next;
        return true;
    }

    // 선택 노드를 하나 앞으로 이동
    public boolean prev() {
        if (isEmpty() || crnt.prev == head)
            return false;
        crnt = crnt.prev;
        return true;
    }

    // 선택 노드의 바로 뒤에 노드 삽입
    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    // 선택 노드 삭제
    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) crnt = head.next;
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드 삭제
    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드 삭제
    public void clear() {
        while (!isEmpty())
            removeFirst();
    }
}
