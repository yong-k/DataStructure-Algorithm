package doit_algorithm.ch06_sorting;
import java.util.Scanner;

// 실습 6-4
public class p210 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void selectionSorting(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;        // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스 값 저장
            for (int j = i + 1; j < a.length; j++)
                if (a[min] > a[j])
                    min = j;
            swap(a, i, min);    // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
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

        selectionSorting(a);

        System.out.println();
        System.out.println("오름차순 정렬 완료");
        for (int x : a)
            System.out.printf("%d ", x);
        System.out.println();
    }
}
