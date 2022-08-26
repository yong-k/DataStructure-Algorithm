package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p216Q8 {
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int pl = 0;
            int pr = i - 1;
            int pc;
            int pd;     // 삽입하는 위치의 인덱스

            do {
                pc = (pl + pr) / 2;
                if (a[pc] == key)
                    break;
                else if (a[pc] < key)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);

            pd = (pl <= pr) ? pc + 1 : pr + 1;
            // pl <= pr 인데 반복문을 빠져나온거라면 a[pc] == key 인 상황
            // → 그럼 pc 뒤에 넣어주면 됨

            for (int j = i; j > pd; j--)
                a[j] = a[j - 1];
            a[pd] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] a = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++) {
            System.out.printf("a[%d] : ", i);
            a[i] = sc.nextInt();
        }

        insertionSort(a);

        System.out.println();
        System.out.println("오름차순 정렬 완료");
        for (int x : a)
            System.out.printf("%d ", x);
        System.out.println();
    }
}
