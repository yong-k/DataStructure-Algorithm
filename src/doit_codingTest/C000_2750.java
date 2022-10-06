package doit_codingTest;

// 백준 2750

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class C000_2750 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 방법1: Scanner & 배열 → Arrays.sort() 사용
        // 시간: 336ms
        /*
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for (int x : arr)
            System.out.println(x);
        */

        // 방법2: Scanner & ArrayList → Collections.sort() 사용 ()
        // 시간: 348ms
        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        int size = sc.nextInt();
        for (int i = 0; i < size; i++)
            list.add(sc.nextInt());

        Collections.sort(list);

        for (Integer x : list)
            System.out.println(x);
        */

        // 방법3: BufferedReader & Arrays.sort() → 가장 빠름
        // 시간: 172ms
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(bf.readLine())];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(arr);

        for (int x : arr)
            System.out.println(x);

    }
}
