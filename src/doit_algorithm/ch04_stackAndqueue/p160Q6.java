package doit_algorithm.ch04_stackAndqueue;

public class p160Q6<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E [] que;

    // 실행 시 예외: 큐 비어있음
    public static class EmptyGenericQueueException extends RuntimeException {
        public EmptyGenericQueueException() {}
    }

    // 실행 시 예외: 큐 가득 참
    public static class OverflowGenericQueueException extends RuntimeException {
        public OverflowGenericQueueException() {}
    }

    // 생성자
    public p160Q6(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enque()
    public E enque(E e) throws OverflowGenericQueueException {
        if (num >= max)
            throw new OverflowGenericQueueException();
        que[rear++] = e;
        num++;
        if (rear == max)
            rear = 0;
        return e;
    }

    // deque()
    public E deque() throws EmptyGenericQueueException {
        if (num <= 0)
            throw new EmptyGenericQueueException();
        E e = que[front++];
        num--;
        if (front == max)
            front = 0;
        return e;
    }

    // peek()
    public E peek() throws EmptyGenericQueueException {
        if (num <= 0)
            throw new EmptyGenericQueueException();
        return que[front];
    }

    // indexOf()
    public int indexOf(E e) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % max] == e)
                return i + front;
        return -1;
    }

    // search()
    public int search(E e) {
        for (int i = 0; i < num; i++)
            if (que[(i + front) % max].equals(e))
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

    // dump()
    public void dump() {
        if (num <= 0)
            System.out.println("큐 비어있음");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max].toString() + " ");
            System.out.println();
        }
    }
}
