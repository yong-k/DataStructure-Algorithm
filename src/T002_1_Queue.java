// 큐(Queue)

import java.util.LinkedList;
import java.util.Queue;

public class T002_1_Queue {
    public static void main(String[] args) {
        // Queue는 LinkedList 클래스를 사용
        Queue<Integer> que_int = new LinkedList<Integer>();
        Queue<String> que_str = new LinkedList<String>();

        // Enqueue: add(), offer()
        que_int.add(1);
        System.out.println(que_int.add(2));         // true
        que_int.offer(3);
        System.out.println(que_int.offer(4));    // true

        // 그냥 출력하면 더미데이터 출력력
       System.out.println(que_int);
        //--==>> [1, 2, 3, 4]

        // Dequeue: poll(), remove() → 데이터 꺼내고(반환), 큐에서 삭제
        que_int.poll();
        System.out.println(que_int);    // [2, 3, 4]
        que_int.remove();
        System.out.println(que_int);    // [3, 4]

        // peek() : 첫 번째 값 뭔지 보는거(꺼내는거 X) : 훔쳐보다
    }
}
