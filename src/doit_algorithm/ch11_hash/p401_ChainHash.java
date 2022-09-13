package doit_algorithm.ch11_hash;

// 실습 11-1: 체인법에 의한 해시
public class p401_ChainHash<K,V> {
    // 해시를 구성하는 노드
    class Node<K,V> {
        private K key;              // 키 값
        private V data;             // 데이터
        private Node<K,V> next;     // 다음 노드에 대한 참조

        // 생성자
        Node(K key, V data, Node<K,V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        // 키 값 반환
        K getKey() {
            return key;
        }

        // 데이터 반환
        V getValue() {
            return data;
        }

        // 키의 해시 값 반환
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;           // 해시 테이블의 크기
    private Node<K,V>[] table;  // 해시 테이블

    // 생성자
    public p401_ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 해시 값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값 key를 갖는 요소의 검색 (데이터를 반환)
    public V search(K key) {
        int hash = hashValue(key);  // 검색할 데이터의 해시 값 (→ 키 값을 변환)
        Node<K,V> p = table[hash];  // 선택 노드 (→ 버킷을 선택)

        while (p != null) {
            if (p.getKey().equals(key))
                return p.getValue();
            p = p.next;
        }
        return null;
    }

    // 키 값 key, 데이터 data를 갖는 요소의 추가
    public int add(K key, V data) {
        int hash = hashValue(key);  // 추가할 데이터의 해시 값
        Node<K,V> p = table[hash];  // 선택 버킷

        while (p != null) {
            if (p.getKey().equals(key))     //-- 이미 등록된 키 값이라 추가 실패
                return 1;
            p = p.next;
        }
        // 노드를 연결리스트 맨 앞에 삽입
        Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
        table[hash] = temp;
        return 0;
    }

    // 키 값 key를 갖는 요소의 삭제
    public int remove(K key) {
        int hash = hashValue(key);         // 삭제할 데이터의 해시 값
        Node<K,V> node = table[hash];      // 선택 버킷
        Node<K,V> nodePrev = null;         // 바로 앞의 선택 노드

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (nodePrev == null)           // 그게 처음 노드라면,
                    table[hash] = node.next;    // 버킷이 node의 next 참조하도록
                else
                    nodePrev.next= node.next;
                return 0;
            }
            nodePrev = node;
            node = node.next;
        }
        return 1;
    }

    // 해시 테이블을 모두 출력
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K,V> p = table[i]; // 순서대로 버킷 선택
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
