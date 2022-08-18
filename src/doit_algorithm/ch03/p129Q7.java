package doit_algorithm.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p129Q7 {

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

        // 시력 내림차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();
        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? 1 : (d1.vision < d2.vision) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                // 배열의 요소는 시력순이어야 함!!!
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이수민", 175, 2.0)
        };
        System.out.print("시력 얼마인 사람을 찾고 있나요? : ");
        double vision = sc.nextDouble();
        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

        if (idx < 0)
            System.out.println("요소 X");
        else {
            System.out.println(idx + "번째에 있음");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
