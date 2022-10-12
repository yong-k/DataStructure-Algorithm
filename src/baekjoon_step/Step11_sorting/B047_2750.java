package baekjoon_step.Step11_sorting;

import java.io.*;
import java.util.*;
public class B047_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 방법1: Arrays.sort() 이용 → O(nlogn) → 최악의 경우엔 O(n²)
        /*
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int x : arr)
            System.out.println(x);
        */

        // 방법2: 도수 정렬 (계수 정렬 = 카운팅 정렬 = Counting Sort) → O(n)
        // → 데이터의 최솟값과 최댓값을 미리 알고 있는 경우에만 사용할 수 있음
        //   수의 범위가 극단적으로 크면, 메모리 낭비 엄청날 수 있음

        // 데이터 범위: -1000 ~ 1000
        // -1000부터 arr[0]에 저장 → 0은 arr[1000]에 저장 → 1000은 arr[2000]에 저장
        // boolean 배열로 해당 값이 있는지 없는지만 저장
        boolean[] arr = new boolean[2001];
        for (int i = 0; i < n; i++)
            arr[Integer.parseInt(br.readLine()) + 1000] = true;

        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                System.out.println(i - 1000);

    }
}
