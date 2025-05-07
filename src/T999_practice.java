import java.util.*;

public class T999_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 정렬 기준 설정.
        // 종료 시간 기준 오름차순 정렬 + 시작 시간 기준 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int count = 0;
        int endTime = -1;
        for (int i = 0; i < N; i++) {
            // 다음회의 시작시간이 현재회의 끝나는 시간보다 같거나 커야됨
            if (endTime <= arr[i][0]) {
                count++;
                endTime = arr[i][1];
            }
        }
        System.out.println(count);
    }
}