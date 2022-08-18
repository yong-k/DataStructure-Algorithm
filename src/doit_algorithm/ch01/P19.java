package doit_algorithm.ch01;

// P19-Q1, Q3: 최댓값, 최솟값
public class P19 {
    static int max4(int a, int b, int c, int d) {
        int arr[] = {a, b, c, d};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];
        return max;
    }

    static int min4(int a, int b, int c, int d) {
        int arr[] = {a, b, c, d};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < min) min = arr[i];
        return min;
    }

    public static void main(String[] args) {
        System.out.println(max4(4, 2, 3, 9));
        System.out.println(max4(8, 2, 22, 19));
        System.out.println(min4(4, 2, 3, 9));
        System.out.println(min4(8, 2, 22, 19));

    }
}
