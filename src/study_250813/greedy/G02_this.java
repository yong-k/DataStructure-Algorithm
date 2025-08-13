package study_250813.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
이코테 - 숫자 카드 게임
3 3
3 1 2
4 1 4
2 2 2
==> 2

2 4
7 3 1 8
3 3 3 4
==> 3
*/
public class G02_this {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int rowMin;
        int result = 0;
        for (int i = 0; i < N; i++) {
            rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                // 행에서 가장 작은 수
                rowMin = Math.min(rowMin, sc.nextInt());
            }
            // 그 중 가장 큰 수
            result = Math.max(result, rowMin);
        }
        System.out.println(result);
    }
}
