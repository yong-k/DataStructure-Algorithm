package doit_algorithm.ch09_list;

import java.util.Comparator;

// 머리노드에 대한 참조 & 꼬리노드에 대한 참조
public class p331Q3_LinkedList<E> {
    // 노드
    class Node<E> {
        private E data;
        private Node<E> next;

        // 생성자
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;   // 머리 노드
    private Node<E> tail;   // 꼬리 노드
    private Node<E> crnt;   // 선택 노드

    // 생성자
    public p331Q3_LinkedList () {
        head = tail = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> node = head;
        while (node != null) {
            if (c.compare(obj, node.data) == 0) {
                crnt = node;
                return node.data;
            }
            node = node.next
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> node = head;
        head = node = new Node<E>(obj, node);
        if (tail == null)
            tail = head;
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            tail.next = crnt = new Node<E>(obj, null);
            tail = crnt;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
            if (head == null)
                tail = null;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> node = head;
                Node<E> nodePrev = head;
                while (node.next != null) {
                    nodePrev = node;
                    node = node.next;
                }
                nodePrev.next = null;
                tail = crnt = nodePrev;
            }
        }
    }

    // 노드 p를 삭제
    public void remove(Node p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else if (p == tail)
                removeLast();
            else {
                Node<E> node = head;
                while (node.next != p) {
                    node = node.next;
                    if (node == null)
                        return; // p가 리스트에 없음
                }
                node.next = p.next;
                crnt = node;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != null)
            removeFirst();
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;
        crnt = crnt.next;
        return true;
    }

    // 선택 노드 출력
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택 노드 없음");
        else
            System.out.println(crnt.data);
    }

    // 모든 노드 출력
    public void dump() {
        Node<E> node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
