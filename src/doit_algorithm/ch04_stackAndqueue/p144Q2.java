package doit_algorithm.ch04_stackAndqueue;

// Q2: 제네릭 스택 클래스 작성하기
public class p144Q2<E>{
    private int max;    // 스택 용량
    private int ptr;    // 스택 포인터
    private E[] stack; // 스택 본체

    // 실행 시 예외: 스택 비어있음
    public static class EmptyGenericStackException extends RuntimeException {
        public EmptyGenericStackException() {}
    }

    // 실행 시 예외: 스택 가득 참
    public static class OverflowGenericStackException extends RuntimeException {
        public OverflowGenericStackException() {}
    }

    // 생성자
    public p144Q2(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            //stack = new E[max];
            stack = (E[]) new Object[max];  // 스택 본체용 배열 생성
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // push()
    public E push(E e) throws OverflowGenericStackException {
        if (ptr >= max)
            throw new OverflowGenericStackException();
        return stack[ptr++] = e;
    }

    // pop()
    public E pop() throws EmptyGenericStackException {
        if (ptr <= 0)
            throw new EmptyGenericStackException();
        return stack[--ptr];
    }

    // peek()
    public E peek() throws EmptyGenericStackException {
        if (ptr <= 0)
            throw new EmptyGenericStackException();
        return stack[ptr - 1];
    }

    // indexOf()
    public int indexOf(E e) {
        for (int i = ptr - 1; i >= 0; i--)
            if (stack[i].equals(e))
                return i;
        return -1;
    }

    // clear()
    public void clear() {
        ptr = 0;
    }

    // capacity()
    public int capacity() {
        return max;
    }

    // size()
    public int size() {
        return ptr;
    }

    // isEmpty()
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // isFull()
    public boolean isFull() {
        return ptr >= max;
    }

    // dump()
    public void dump() {
        // 바닥 → 꼭대기 차례로 출력함
        if (ptr <= 0)
            System.out.println("스택 비어있음");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stack[i] + " ");
            System.out.println();
        }
    }
}
