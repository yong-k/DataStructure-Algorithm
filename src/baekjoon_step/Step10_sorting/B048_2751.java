package baekjoon_step.Step10_sorting;

import java.io.*;

public class B048_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //-- StringBuilder안 쓰고 sout()으로 출력해주면 시간초과떴음!
        StringBuilder sb = new StringBuilder();

        // Arrays.sort() 사용해서 풀면 → 시간초과 뜸 ㅎ


        // 방법1) 도수 정렬 = 계수 정렬 = Counting sort 사용
        // 수 범위: -1000000 ~ 1000000
        // -1000000 → arr[0]       저장
        //        0 → arr[1000000] 저장
        //  1000000 → arr[2000000] 저장
        boolean[] arr = new boolean[2000001];
        for (int i = 0; i < n; i++)
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                sb.append(i - 1000000 + "\n");
        System.out.println(sb);

        // 방법2) Collections.sort() 이용
        // Arrays.sort()        → 최선 O(nlogn)   최악 O(n²)
        // Collections.sort()   → 최선 O(n)       최악 O(nlogn)
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        for (Integer x : list)
            sb.append(x + "\n");
        System.out.println(sb);
        */
    }
}
