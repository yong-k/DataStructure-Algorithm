package doit_algorithm.ch11_hash;

// 실습 11-3: 오픈 주소법에 의한 해시
public class p417_OpenHash<K,V> {
    // 버킷의 상태
    enum Status {OCCUPIED, EMPTY, DELETED};     // {데이터저장, 비어있음, 삭제마침}

    // 버킷
    static class Bucket<K,V> {
        private K key;
        private V data;
        private Status stat;    // 상태

        // 생성자
        Bucket() {
            stat = Status.EMPTY;    // 버킷은 비어 있음
        }

        // 모든 필드에 값 설정
        void set(K key, V data, Status stat) {
            this.key = key;
            this.data = data;
            this.stat = stat;
        }

        // 상태 설정
        void setStat(Status stat) {
            this.stat = stat;
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

    private int size;
    private Bucket<K,V>[] table;      // 해시 테이블

    public p417_OpenHash(int size) {
        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++)
                table[i] = new Bucket<K,V>();
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 해시 값 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 재해시 값 구함
    public int rehashValue(int hash) {
        return (hash + 1) % size;
    }

    // 키 값 key를 갖는 버킷 검색
    private Bucket<K,V> searchNode(K key) {
        int hash = hashValue(key);
        Bucket<K,V> p = table[hash];

        for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
            if (p.stat == Status.OCCUPIED && p.getKey().equals(key))
                return p;
            hash = rehashValue(hash);   // 재해시
            p = table[hash];
        }
        return null;
    }

    // 키 값 key를 갖는 요소의 검색(데이터 반환) → 버킷당 key 한 개 들어있으니까
    public V search(K key) {
        Bucket<K,V> p = searchNode(key);
        if (p != null)
            return p.getValue();
        else
            return null;
    }

    // 키 값 key, 데이터 data를 갖는 요소의 추가
    public int add(K key, V data) {
        if (search(key) != null)
            return 1;       // 이미 등록된 키 값 → 추가 실패

        int hash = hashValue(key);
        Bucket<K,V> p = table[hash];
        for (int i = 0; i < size; i++) {
            if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
                p.set(key, data, Status.OCCUPIED);
                return 0;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return 2;   // 해시테이블 가득 참
    }

    // 키 값 key를 갖는 요소 삭제
    public int remove(K key) {
        Bucket<K,V> p = searchNode(key);
        if (p == null)
            return 1;

        p.setStat(Status.DELETED);
        return 0;
    }

    // 해시 테이블 모두 출력
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d ", i);
            switch (table[i].stat) {
                case OCCUPIED:
                    System.out.printf("%s (%s)\n"
                        , table[i].getKey(), table[i].getValue());
                    break;
                case EMPTY:
                    System.out.println("-- 미등록 --");
                    break;
                case DELETED:
                    System.out.println("-- 삭제 마침 --");
                    break;
            }
        }
    }
}
