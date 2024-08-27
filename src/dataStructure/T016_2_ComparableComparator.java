package dataStructure;

import java.util.Arrays;
import java.util.Comparator;

// Comparable 과 Comparator 는 둘 다 Interface
// 정렬 기준을 구현하기 위해 사용된다.

// Comparable Inteface 는 compareTo() 메서드를 override 해서 구현
// → 일반적으로는 정렬할 객체에 implements 로 Comparable 인터페이스를 추가하여 구현

// Comparator Inteface 는 compare() 메서드를 override 해서 구현
// → 일반적으로는 별도 클래스를 정의해서 구현
//    따라서, 동일 객체에 다양한 정렬 기준을 가진 클래스를 작성 가능하다.
// → Comparable Interface가 정의되어 있더라도, Comparator 클래스의 정렬 기준으로 정렬된다.

public class T016_2_ComparableComparator implements Comparable<T016_2_ComparableComparator> {
    public int distance;
    public String vertex;

    public T016_2_ComparableComparator(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(T016_2_ComparableComparator c) {
        return this.distance - c.distance;
    }

    public static void main(String[] args) {
        T016_2_ComparableComparator c1 = new T016_2_ComparableComparator(12, "A");
        T016_2_ComparableComparator c2 = new T016_2_ComparableComparator(10, "A");
        T016_2_ComparableComparator c3 = new T016_2_ComparableComparator(13, "A");
        T016_2_ComparableComparator[] arr = new T016_2_ComparableComparator[]{c1, c2, c3};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i].distance + " ");

        System.out.println();
        System.out.println();

        // Comparator를 별도의 클래스로 작성
        Arrays.sort(arr, new Comparator<T016_2_ComparableComparator>() {
            @Override
            public int compare(T016_2_ComparableComparator o1, T016_2_ComparableComparator o2) {
                return o2.distance - o1.distance;
            }
        });

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i].distance + " ");
    }
}
