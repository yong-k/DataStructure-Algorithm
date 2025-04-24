package tony_git.data_structure;

import java.util.*;

public class B_2346_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            deque.add(i);
        }

        int n = deque.pollFirst();
        int paper = arr[n];
        sb.append(n).append(' ');
        while (!deque.isEmpty()) {
            // 양수면 덱 앞에서 작업, 음수면 덱 뒤에서 작업
            if (paper > 0) {
                while (paper > 1) {
                    deque.addLast(deque.pollFirst());
                    paper--;
                }
                n = deque.pollFirst();
                paper = arr[n];
            } else {
                while (paper < -1) {
                    deque.addFirst(deque.pollLast());
                    paper++;
                }
                n = deque.pollLast();
                paper = arr[n];
            }
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }
}
