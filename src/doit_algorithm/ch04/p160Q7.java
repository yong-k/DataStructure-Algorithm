package doit_algorithm.ch04;

// 덱(deck): 양방향 대기열
public class p160Q7 {
    private int max;    // 덱(deck)의 용량
    private int num;    // 현재 데이터 개수
    private int front;  // 맨 앞 커서
    private int rear;   // 맨 뒤 커서
    private int[] que;  // 덱(deck)의 본체

    // 실행 시 예외: deck 비어 있음
    public class EmptyDeckException extends RuntimeException {
        public EmptyDeckException() {}
    }

    // 실행 시 예외: deck 가득 참
    public class OverflowDeckException extends RuntimeException {
        public OverflowDeckException() {}
    }

    // 생성자
    public p160Q7(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enqueFront() : 데이터를 front에 enque
    public int enqueFront(int x) throws OverflowDeckException {
        if (num >= max)
            throw new OverflowDeckException();
        if (--front < 0)
            front = max - 1;
        que[front] = x;
        num++;
        return x;
    }

    // enqueRear()  : 데이터를 rear에 enque
    public int enqueRear(int x) throws OverflowDeckException {
        if (num >= max)
            throw new OverflowDeckException();
        que[rear++] = x;
        if (rear == max)
            rear = 0;
        num++;
        return x;
    }

    // dequeFront() : front에서 deque
    public int dequeFront() throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        int x = que[front++];
        if (front == max)
            front = 0;
        num--;
        return x;
    }

    // dequeRear()  : rear에서 deque
    public int dequeRear() throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        if (--rear < 0)
            rear = max - 1;
        num--;
        return que[rear];
    }

    // peekFront()  : front 데이터를 peek
    public int peekFront() throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        return que[front];
    }

    // peekRear()   : rear 데이터를 peek
    public int peekRear() throws EmptyDeckException {
        if (num <= 0)
            throw new EmptyDeckException();
        return que[rear == 0 ? max - 1 : rear - 1];
    }

    // indexOf()
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % max] == x)
                return i + front;
        return -1;
    }

    // search()
    public int search(int x) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % max] == x)
                return i + 1;
        return 0;
    }

    // clear()
    public void clear() {
        num = front = rear = 0;
    }

    // capacity()
    public int capacity() {
        return max;
    }

    // size()
    public int size() {
        return num;
    }

    // isEmpty()
    public boolean isEmpty() {
        return num <= 0;
    }

    // isFull()
    public boolean isFull() {
        return num >= max;
    }

    // dump() : front → rear 순으로 데이터 출력
    public void dump() {
        if (num <= 0)
            System.out.println("deck 비어있음");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
