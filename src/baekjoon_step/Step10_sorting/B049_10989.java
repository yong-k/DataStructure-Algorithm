package baekjoon_step.Step10_sorting;

import java.io.*;

public class B049_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 1) Collections.sort() → 메모리 초과 뜸
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        for (int x : list)
            sb.append(x + "\n");
        System.out.println(sb);
        */

        // 2) Arrays.sort()
        /*
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int x : arr)
            sb.append(x + "\n");
        System.out.println(sb);
        */

        // 3) 도수 정렬
        int[] arr = new int[10001];
        for (int i = 0; i < N; i++)
            arr[Integer.parseInt(br.readLine())]++;
        for (int i = 1; i < 10001; i++) {
            while (arr[i] > 0) {
                sb.append(i + "\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}
