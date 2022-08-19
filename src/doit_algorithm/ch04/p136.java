package doit_algorithm.ch04;

// 실습 4-1
public class p136 {
    private int max;        // 스택 용량
    private int ptr;        // 스택 포인터
    private int[] stack;    // 스택 본체

    // 실행 시 예외: 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public p136(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stack = new int[max];
        } catch (OutOfMemoryError e) {
            // 배열 본체 생성에 실패할 경우,
            max = 0;
            //--==>> 이렇게 하면 다른 메서드가 존재하지 않는 배열에 잘못 접근하는 걸 막을 수 있음
        }
    }

    // push 메서드 (값 추가)
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max)
            throw new OverflowIntStackException();
        return stack[ptr++] = x;    // push한 값을 반환함
    }

    // pop 메서드 (값 반환 후, 제거)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        // **먼저 스택 포인터 ptr 값을 감소시킨 후에 거기에 저장되어 있는 값 반환
        return stack[--ptr];
    }

    // peek 메서드 (값 확인, 제거하지는 않음)
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stack[ptr - 1];  // 값 제거하지 않으니, 스택 포인터 변화하지 않음
    }

    // indexOf 메서드 (해당 데이터의 위치 반환, 없으면 -1 반환)
    public int indexOf(int x) {
        // 스택은 나중에 들어온 데이터가 먼저 pop() 되니까, 뒤에서부터 앞으로 반복 진행
        for (int i = ptr - 1; i >= 0; i--)
            if (stack[i] == x)
                return i;
        return -1;
    }

    // clear 메서드 (스택의 모든 요소 삭제, 스택 비움)
    public void clear() {
        // 스택에 대한 push, pop 작업은 스택 포인터를 바탕으로 이루어지므로,
        // 요솟값을 변경할 필요 없이
        // 스택 포인터만 0으로 해주면 끝난다.
        ptr = 0;
    }

    // capacity 메서드 (스택의 용량 확인)
    public int capacity() {
        return max;
    }

    // size 메서드 (스택의 현재 데이터 수 확인)
    public int size() {
        return ptr;
    }

    // isEmpty 메서드 (스택이 비어 있는지 → true/false 반환)
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // isFull 메서드 (스택이 가득 찼는지 → true/false 반환)
    public boolean isFull() {
        return ptr >= max;
    }

    // dump 메서드 (스택의 모든 데이터를 바닥 → 꼭대기 순서로 출력)
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택 비어 있음");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stack[i] + " ");
            System.out.println();
        }
    }
}
