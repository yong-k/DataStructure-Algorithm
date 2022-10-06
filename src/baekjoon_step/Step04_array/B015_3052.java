package baekjoon_step.Step04_array;

// 3052
import java.io.*;
import java.util.*;
public class B015_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        int[] arr = new int[42];
        for (int i = 0; i < 10; i++)
            arr[Integer.parseInt(br.readLine()) % 42]++;

        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > 0) count++;

        System.out.println(count);
        */

        // hashSet 특징
        // - 중복 원소를 허용하지 않음 (중복될 경우 하나만 저장)
        // - 순서 개념 없음 → Collections.sort() 사용 불가
        //   정렬하려면 리스트로 변환 후 정렬해야 한다.
        //--▷ 중복 원소 허용하지 않으니 size() 사용해서 개수 구하면 됨
        HashSet<Integer> hashset = new HashSet<>();

        for (int i = 0; i < 10; i++)
            hashset.add(Integer.parseInt(br.readLine()) % 42);

        System.out.println(hashset.size());
    }
}
