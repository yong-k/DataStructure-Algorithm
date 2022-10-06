package baekjoon_step.Step05_function;

public class B018_4673 {
    static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int num = d(i);
            if (num <= 10000)
                check[num] = true;
        }

        for (int i = 1; i <= 10000; i++)
            if (check[i] == false)
                System.out.println(i);

    }
}
