package dataStructure;// 배열(Array)

import java.util.ArrayList;
import java.util.Arrays;


public class T001_Array {
    public static void main(String[] args) {
        Integer[] data_list = new Integer[10];
        data_list[0] = 1;

        Integer data_list1[] = {5,4,3,2,1};

        // 배열의 내용 출력 (java.util.Arrays)
        // Arrays.toString(배열명);
        // → 화면에 전체 배열의 데이터를 출력
        System.out.println(Arrays.toString(data_list1));
        //--==>> [5, 4, 3, 2, 1]

        // 배열은 고정 길이
        // ArrayList: 가변 길이 배열 자료구조

        // ArrayList 선언: 아래 3개 다 똑같은 거
        //List<Integer> list1 = new ArrayList<Integer>();
        //ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<>();
        //└→ JDK 1.7 이상부터는 인스턴스 생성 시 타입을 추정할 수 있는 경우에는 타입 생략 가능

        list1.add(1);
        System.out.println(list1.get(0));   // 1
        list1.set(0, 3);
        System.out.println(list1.get(0));   // 3
        list1.remove(0);
        //System.out.println(list1.get(0));
        //--==>> Runtime Error: IndexOutOfBoundsException
        System.out.println(list1.size());   // 0

        // 3차원 배열
        Integer[][][] arr = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };
        System.out.println(arr[0][0][1]);   // 2
        System.out.println(arr[0][1][1]);   // 5
        System.out.println(arr[1][0][2]);   // 9
        System.out.println(arr[1][0][1]);   // 8
        System.out.println(arr[1][1][0]);   // 10

        // 아래 배열에서 문자 'M' 을 가지고 있는 아이템의 수를 출력해보자
        String dataset[] = {
                "Braund, Mr. Owen Harris",
                "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                "Heikkinen, Miss. Laina",
                "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                "Allen, Mr. William Henry",
                "Moran, Mr. James",
                "McCarthy, Mr. Timothy J",
                "Palsson, Master. Gosta Leonard",
                "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                "Nasser, Mrs. Nicholas (Adele Achem)",
                "Sandstrom, Miss. Marguerite Rut",
                "Bonnell, Miss. Elizabeth",
                "Saundercock, Mr. William Henry",
                "Andersson, Mr. Anders Johan",
                "Vestrom, Miss. Hulda Amanda Adolfina",
                "Hewlett, Mrs. (Mary D Kingcome) ",
                "Rice, Master. Eugene",
                "Williams, Mr. Charles Eugene",
                "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                "Masselmani, Mrs. Fatima",
                "Fynney, Mr. Joseph J",
                "Beesley, Mr. Lawrence",
                "McGowan, Miss. Anna",
                "Sloper, Mr. William Thompson",
                "Palsson, Miss. Torborg Danira",
                "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                "Emir, Mr. Farred Chehab",
                "Fortune, Mr. Charles Alexander",
                "Dwyer, Miss. Ellen",
                "Todoroff, Mr. Lalio"
        };
        /*
        for 반복문을 배열 길이만큼 돌면서,
        요소에 'M' 있는지 체크 후, 있으면 count 증가
        */
        int count = 0;
        for (int i = 0; i < dataset.length; i++)
            if (dataset[i].indexOf('M') != -1) count += 1;
        System.out.println("M을 갖고 있는 거 : " + count + "개");
    }
}