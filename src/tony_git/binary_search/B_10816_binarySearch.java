package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10816_binarySearch {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 이분 탐색을 위한 배열 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            // 중복 원소 개수 count (상한선 - 하한선)
            sb.append(upperBound(key) - lowerBound(key)).append(' ');
        }
        System.out.println(sb);
    }

    static int lowerBound(int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            /*
            * 중복되는 값의 하한(이상)선을 찾아야 하는 상황
            * key가 mid보다 작거나 같다면,
            * right 값을 mid - 1로 바꿔줘야 함
            * */
            if (key <= arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    static int upperBound(int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            /*
            * 중복되는 값의 상한선(초과)을 찾아야 하는 상황
            * key가 mid보다 작다면,
            * right 값을 mid - 1로 바꿔줘야 함
            * */
            if (key < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
