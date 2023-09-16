package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 1 ~ N까지 카드 넣는다.
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 아니면, 제일 위에 있는 카드 버리고, 그 다음 위에 있는 카드 맨 뒤로 넣음
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
