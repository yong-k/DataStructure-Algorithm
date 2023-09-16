package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10811_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 바구니 번호 초기화
        int[] arr1 = new int[N];
        for (int i = 1; i <= N; i++) {
            arr1[i - 1] = i;
        }

        // 역순으로 바꾸기 위한 여분 바구니들 생성
        int[] arr2 = new int[arr1.length];
        int[] temp = new int[arr1.length];
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            arr2 = arr1.clone();

            // 역순으로 바꿔준다.
            // 해당 범위의 arr1[] 끝(i)에 원소를 arr2[] 배열 처음(j)부터 넣음
            int i, j;
            for (i = end, j = start; i >= start; i--, j++) {
                arr2[i] = arr1[j];
            }

            // arr1과 arr2 배열의 이름을 바꿔준다.
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr1) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
