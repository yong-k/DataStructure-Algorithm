package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2110 {
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 집의 개수
        int C = Integer.parseInt(st.nextToken());   // 공유기 개수
        house = new int[N];

        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        // 이분 탐색을 위한 정렬
        Arrays.sort(house);

        int left = 1;
        int right = house[N - 1] - house[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            /*
            * 설치가능한 공유기 개수가 C에 못 미치면, 거리를 좁혀야 하므로
            * right = mid - 1 로 줄여준다.
            * */
            if (canInstall(mid) < C)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(right);
    }

    // distance에 대해 설치 가능한 공유기 개수를 반환한다.
    static int canInstall(int distance) {
        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {
            /*
            * 현재 집의 위치와 직전에 설치했던 집의 거리가
            * distance보다 크거나 같다면, 공유기 설치 개수 늘려주고
            * 마지막 설치 위치 갱신해준다.
            * */
            int locate = house[i];
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
