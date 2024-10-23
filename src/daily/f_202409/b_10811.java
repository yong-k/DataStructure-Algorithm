package daily.f_202409;

import java.util.Scanner;

/**
 * 백준 - 바구니 뒤집기 (240901) [X]
 * https://www.acmicpc.net/problem/10811
 * */
public class b_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr1 = new int[N];
        for (int i = 1; i <= N; i++)
            arr1[i - 1] = i;

        // 역순으로 바꾸기 위한 여분 바구니들 생성
        int[] arr2 = new int[arr1.length];
        int[] temp = new int[arr1.length];
        for (int m = 0; m < M; m++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;

            arr2 = arr1.clone();

            // 역순으로 바꿔준다.
            // arr2[]에 arr1[] 원소를 역순으로 넣음
            int i, j;
            for (i = end, j = start; i >= start; i--, j++) {
                arr2[i] = arr1[j];
            }

            // arr1과 arr2 배열의 이름을 바꿔준다.
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        for (int i : arr1)
            System.out.print(i + " ");
    }
}
