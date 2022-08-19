package doit_algorithm.ch04;

// 실습 4-3 (링 버퍼 큐)
public class p148p160Q5 {
    private int max;    // 큐의 용량
    private int front;  // 첫 번째 요소 커서
    private int rear;   // 마지막 요소 커서
    //-- 다음 인큐할 인덱스 미리 준비해 두는 것
    private int num;    // 현재 데이터 수
    //-- front == rear 경우, 큐가 빈 건지/가득 찬 건지 구별할 수 없는 상황을 위해 필요
    private int[] que;  // 큐 본체

    // 실행 시 예외: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    // 생성자
    public p148p160Q5(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enque() : 큐의 맨 뒤에 데이터 넣음
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if (rear == max)    // *rear가 최대 용량의 max와 같을 경우, rear = 0으로 설정
            rear = 0;
        return x;
    }

    // deque() : 큐의 맨 앞 데이터 꺼냄
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == max)   // *front가 max와 같을 경우, front = 0으로 설정
            front = 0;
        return x;
    }
    // peek() : 큐의 맨 앞 데이터 확인 (꺼내지는 X → front, rear, num 값 변화 없음)
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    // indexOf() : 검색 값의 인덱스 반환 (없으면 -1 반환)
    public int indexOf(int x) {
        // front → rear 선형 검색
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;        // ★
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // search() : 검색 값의 큐 안에서의 위치 반환 (front면 1, 없으면 0)
    public int search(int x) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % max] == x)
                return i + 1;
        return 0;
    }

    // clear() : 큐의 모든 데이터 삭제
    public void clear() {
        num = front = rear = 0;     // → 큐의 요솟값 바꿀 필요 X
    }

    // capacity() : 최대 용량 확인
    public int capacity() {
        return max;
    }

    // size() : 현재 데이터 개수 확인
    public int size() {
        return num;
    }

    // isEmpty() : 큐 비어 있음? (true/false 반환)
    public boolean isEmpty() {
        return num <= 0;
    }

    // isFull() : 큐 가득 참? (true/false 반환)
    public boolean isFull() {
        return num >= max;
    }

    // dump() : 큐의 모든 데이터 front → rear 순으로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐 비어있음");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
