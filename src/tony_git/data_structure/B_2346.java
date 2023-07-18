package tony_git.data_structure;

import java.util.*;
public class B_2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Balloon> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            que.add(new Balloon(i, sc.nextInt()));

        // 첫번째 풍선 터뜨림
        Balloon balloon = que.poll();
        int paperNum = balloon.paper;
        sb.append(balloon.order + 1).append(' ');

        while(!que.isEmpty()) {
            if (paperNum > 0) {
                for (int i = 1; i < paperNum; i++)
                    que.addLast(que.pollFirst());
                balloon = que.pollFirst();  //--★ 풍선 앞에서 꺼냄
            } else {
                for (int i = paperNum; i < -1; i++)
                    que.addFirst(que.pollLast());
                balloon = que.pollLast();   //--★ 풍선 뒤에서 꺼냄
            }
            paperNum = balloon.paper;
            sb.append(balloon.order + 1).append(' ');
        }
        System.out.println(sb);
    }

    static class Balloon {
        int order;
        int paper;

        public Balloon(int order, int paper) {
            this.order = order;
            this.paper = paper;
        }
    }
}
