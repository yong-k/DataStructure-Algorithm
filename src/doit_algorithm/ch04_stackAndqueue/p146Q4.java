package doit_algorithm.ch04_stackAndqueue;

public class p146Q4 {
    private int max;    // 큐 용량
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체

    // 실행 시 예외: 큐가 비어 있음
    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {}
    }

    // 실행 시 예외: 큐가 가득 참
    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {}
    }

    // 생성자
    public p146Q4(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enque()
    public int enque(int x) throws OverflowIntAryQueueException {
        if (num >= max)
            throw new OverflowIntAryQueueException();
        que[num++] = x;
        return x;
    }

    // deque()
    public int deque() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();
        int x = que[0];
        for (int i = 0; i < num - 1; i++)
            que[i] = que[i + 1];
        num--;
        return x;
    }

    // peek(): 머리 데이터 살펴봄
    public int peek() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException();
        return que[num - 1];
    }

    // indexOf()
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
            if (que[i] == x)
                return i;
        return -1;
    }

    // clear()
    public void clear() {
        num = 0;
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

    // dump() : 머리 → 꼬리 차례로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐 비었음");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}