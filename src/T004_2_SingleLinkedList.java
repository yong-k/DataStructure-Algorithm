public class T004_2_SingleLinkedList {
    public static class SingleLinkedList<T> {
        public Node<T> head = null;

        // 내부 클래스
        public class Node<T> {
            T data;
            Node<T> next = null;

            // 생성자
            public Node(T data) {
                this.data = data;
            }
        }

        // addNode(): 데이터 추가
        public void addNode(T data) {
            if (head == null) {
                // 이게 첫 노드라는 뜻 → head에 새로운 Node 넣어주기
                head = new Node<T>(data);
            } else {
                Node<T> node = this.head;
                while (node.next != null) {
                    node = node.next;

                }
                //--==>> node.next가 null일 때 while문을 벗어남 (마지막 노드에 도착)
                // 마지막 노드의 next에 새로운 노드 연결시켜주면 됨
                node.next = new Node<T>(data);
            }
        }

        // printAll(): 모든 데이터 출력
        public void printAll() {
            if (head != null) {
                // 현재 head부터 시작해야 하니까
                Node<T> node = this.head;
                // head 데이터 우선 출력
                System.out.print(node.data + " ");
                while (node.next != null) {
                    node = node.next;
                    System.out.print(node.data + " ");
                }
                System.out.println();
            }
        }

        // search(): 데이터 검색
        public Node<T> search(T isData) {
            if (this.head == null) {
                return null;
            } else {
                Node<T> node = this.head;
                while (node != null) {
                    if (node.data == isData) {
                        return node;
                    } else {
                        node = node.next;
                    }
                }
                return null;
            }
        }

        // addNodeInside(): 중간 부분에 노드 추가
        //-- newData: 새로 추가할 데이터
        //-- isData: 이 데이터 뒤에 새로 추가할 거 나타냄
        public void addNodeInside(T newData, T isData) {
            // isData 를 먼저 찾아야 그 뒤에 newData를 추가할 수 있음
            Node<T> searchedNode = this.search(isData);

            if (searchedNode == null) {
                // 찾는 Node가 없으면 맨 뒤에다 연결
                this.addNode(newData);
            } else {
                Node<T> nextNode = searchedNode.next;
                searchedNode.next = new Node<T>(newData);
                searchedNode.next.next = nextNode;
            }
        }

        // delNode(): 특정 노드 삭제
        public boolean delNode(T isData) {
            if (this.head == null) {
                return false;
            } else {
                Node<T> node = this.head;
                // head에 삭제할 데이터가 있을 경우
                //  → this.head 삭제하고 그 다음 노드를 head로 지정해줘야 함
                if (node.data == isData) {
                    this.head = this.head.next;
                    return true;
                } else {
                    while (node.next != null) {
                        if (node.next.data == isData) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> sl = new SingleLinkedList<>();
        sl.addNode(1);
        System.out.println(sl.head.data);       // 1
        System.out.println(sl.head.next);       // null
        sl.addNode(2);
        System.out.println(sl.head.next);       // T004_2_SingleLinkedList$SingleLinkedList$Node@677327b6
        System.out.println(sl.head.next.data);  // 2
        sl.addNode(3);
        sl.printAll();                          // 1 2 3

        sl.addNodeInside(5, 1);
        sl.printAll();                          // 1 5 2 3
        sl.addNodeInside(6, 3);
        sl.printAll();                          // 1 5 2 3 6
        sl.addNodeInside(7, 20);
        sl.printAll();                          // 1 5 2 3 6 7

        System.out.println(sl.delNode(3));  // true
        sl.printAll();                          // 1 5 2 6 7
        sl.delNode(1);
        sl.delNode(7);
        System.out.println(sl.delNode(21)); // false
        sl.printAll();                             // 5 2 6
    }
}
