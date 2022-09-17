public class T010_DPAndDivideAndConquer {
    // 나
    static int fibonacci_1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci_1(n-2) + fibonacci_1(n-1);
    }

    // recursive
    static int fibonacci_2(int n) {
        if (n <= 1) return n;
        return fibonacci_2(n-2) + fibonacci_2(n-1);
    }

    // dynamic programming
    static int fibonacci_3(int n) {
        int cache[] = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < cache.length; i++)
            cache[i] = cache[i-2] + cache[i-1];
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci_1(10));
        System.out.println(fibonacci_2(10));
        System.out.println(fibonacci_3(10));
    }
}
