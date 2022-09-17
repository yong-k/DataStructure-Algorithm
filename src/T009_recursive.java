import java.util.ArrayList;

public class T009_recursive {
    static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    // 숫자 배열 주어졌을 때, 배열의 합 리턴하는 메서드 만들기 (재귀용법 사용)
    // ArrayList → subList(fromIndex, toIndex) : 무분별하게 사용하지 X
    // toIndex는 내가 자르고싶은 마지막인덱스 + 1
    // subList만들면서 생성자에 있는 parent의 값이 함께 반환됨
    // 메모리 누수 위험성 있음
    static int sumArray(ArrayList<Integer> list) {
        if (list.size() <= 0)
            return 0;

        // casting 하면 에러남
        //return list.get(0) + sumArray((ArrayList<Integer>) list.subList(1, list.size()));
        //-- java.lang.ClassCastException
        //   (class java.util.ArrayList$SubList cannot be cast to class java.util.ArrayList)

        // 객체 새로 생성해줘야함
        return list.get(0) + sumArray(new ArrayList<Integer>(list.subList(1, list.size())));
    }

    // 정수 n이 주어졌을 때, 1, 2, 3의 합으로 나타낼 수 있는 방법의 수 리턴하는 메서드 (재귀 사용)
    // ex) 4 -> 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 -> 7가지 방법
    static int sumCase(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else if (n == 3)
            return 4;
        return sumCase(n - 1) + sumCase(n - 2) + sumCase(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);
        System.out.println(sumArray(list));

        System.out.println(sumCase(4));
    }
}
