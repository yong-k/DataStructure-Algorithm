package doit_algorithm.ch03_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 실습 3-8
public class p128 {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 오름차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return d1.height > d2.height ? 1 : (d1.height < d2.height) ? -1 : 0;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
            new PhyscData("이나령", 162, 0.3),
            new PhyscData("유지훈", 168, 0.4),
            new PhyscData("김한결", 169, 0.8),
            new PhyscData("홍준기", 171, 1.5),
            new PhyscData("전서현", 173, 0.7),
            new PhyscData("이호연", 174, 1.2),
            new PhyscData("이수민", 175, 2.0)
        };
        System.out.print("몇 cm인 사람을 찾고 있나요? : ");
        int height = sc.nextInt();
        int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);

        if (idx < 0)
            System.out.println("요소 X");
        else {
            System.out.println(idx + "번째에 있음");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
