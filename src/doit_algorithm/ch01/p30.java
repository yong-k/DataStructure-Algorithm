package doit_algorithm.ch01;

public class p30 {
    // Q7
    public static int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++)
            result += i;
        return result;
    }

    // Q8 (가우스의 덧셈)
    public static int gauss(int n) {
        //return (1+n)*(n/2);
        //--> 이러면 n이 홀수일 때, 값 제대로 안나옴
        return (1 + n) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);
    }

    // Q9
    public static int sumof(int a, int b) {
        int sum = 0;
        if (a > b) {
            a = a ^ b;
            b = b ^ a;
            a = a ^ b;
        }
        for (int i = a; i <= b; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(7));
        System.out.println(gauss(10));
        System.out.println(gauss(100));
        System.out.println(sumof(3, 5));
        System.out.println(sumof(6, 4));
    }
}
