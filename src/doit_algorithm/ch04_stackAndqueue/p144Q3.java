package doit_algorithm.ch04_stackAndqueue;

public class p144Q3 {
    private int max;
    private int ptrA;   // 스택A 포인터
    private int ptrB;   // 스택B 포인터
    private int[] stack;

    // ** 추가
    public enum AorB {
        StackA, StackB
    };

    // 실행 시 예외: 스택 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외: 스택 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public p144Q3(int capacity) {
        ptrA = 0;
        ptrB = capacity - 1;
        max = capacity;
        try {
            stack = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // push()
    public int push(AorB sw, int x) throws OverflowIntStackException {
        if (ptrA >= ptrB + 1)
            throw new OverflowIntStackException();
        switch (sw) {
            case StackA:
                stack[ptrA++] = x;
                break;
            case StackB:
                stack[ptrB--] = x;
                break;
        }
        return x;
    }

    // pop()
    public int pop(AorB sw) throws EmptyIntStackException {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    throw new EmptyIntStackException();
                x = stack[--ptrA];
                break;
            case StackB:
                if (ptrB >= max - 1)
                    throw new EmptyIntStackException();
                x = stack[++ptrB];
                break;
        }
        return x;
    }

    // peek()
    public int peek(AorB sw) throws EmptyIntStackException {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    throw new EmptyIntStackException();
                x = stack[ptrA - 1];
                break;
            case StackB:
                if (ptrB >= max - 1)
                    throw new EmptyIntStackException();
                x = stack[ptrB + 1];
                break;
        }
        return x;
    }

    // indexOf()
    public int indexOf(AorB sw, int x) {
        switch (sw) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--)
                    if (stack[i] == x)
                        return i;
                break;
            case StackB:
                for (int i = ptrB + 1; i < max; i++)
                    if (stack[i] == x)
                        return i;
                break;
        }
        return -1;
    }

    // clear()
    public void clear(AorB sw) {
        switch (sw) {
            case StackA:
                ptrA = 0;
                break;
            case StackB:
                ptrB = max - 1;
                break;
        }
    }

    // capacity() : A와 B의 합계
    public int capacity() {
        return max;
    }

    // size()
    public int size(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA;
            case StackB:
                return max - ptrB - 1;
        }
        return 0;
    }

    // isEmpty()
    public boolean isEmpty(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA <= 0;
            case StackB:
                return ptrB >= max - 1;
        }
        return true;
    }

    // isFull()
    public boolean isFull() {
        return ptrA >= ptrB + 1;
    }

    // dump()
    public void dump(AorB sw) {
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    System.out.println("스택 비어있음");
                else {
                    for (int i = 0; i < ptrA; i++)
                        System.out.print(stack[i] + " ");
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= max - 1)
                    System.out.println("스택 비어있음");
                else {
                    for (int i = max - 1; i > ptrB; i--)
                        System.out.print(stack[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}
