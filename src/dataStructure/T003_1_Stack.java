package dataStructure;// 스택(Stack)
// ex) 재귀용법 호출방식

import java.util.Stack;

public class T003_1_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);  // [1, 2, 3]
        System.out.println(stack.pop());    // 3
        System.out.println(stack);          // [1, 2]
        System.out.println(stack.peek());   // 2
        System.out.println(stack);          // [1, 2]

    }
}
