package dataStructure;

import java.util.ArrayList;

public class T003_2_MyStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty())
            return null;
        //return stack.remove(stack.size());
        return stack.remove(stack.size() - 1);
    }

    public static void main(String[] args) {
        T003_2_MyStack<Integer> st = new T003_2_MyStack<>();
        st.push(1);
        st.push(2);
        System.out.println(st.pop());   // 2
        st.push(3);
        System.out.println(st.pop());   // 3
        System.out.println(st.pop());   // 1
        System.out.println(st.pop());   // null
    }
}
