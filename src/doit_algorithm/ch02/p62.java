package doit_algorithm.ch02;

public class p62 {
    // Q4
    static void copy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
    }
    // Q5
    static void rcopy(int[] a, int[] b) {
        for (int i = a.length-1, j = 0; i >= 0; i--,j++)
            b[j] = a[i];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[a.length];
        copy(a, b);
        for (int x : b)
            System.out.print(x + " ");
        System.out.println("\n\nreverse");
        rcopy(a, b);
        for (int x : b)
            System.out.print(x + " ");

    }
}
