import java.util.ArrayList;

public class T002_2_MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty())
            return null;
        return queue.remove(0);
    }

    public static void main(String[] args) {
        T002_2_MyQueue<Integer> queue = new T002_2_MyQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);  // null
        //--==>> T002_2_MyQueue@677327b6
        // 이건 지금 arraylist라서 더미데이터 안나오고, 해시코드로 나옴
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
