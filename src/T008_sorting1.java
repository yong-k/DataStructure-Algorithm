import java.util.ArrayList;
import java.util.Collections;

public class T008_sorting1 {
    static ArrayList<Integer> setOriginalList(ArrayList<Integer> list) {
        list.clear();
        list.add(9); list.add(7); list.add(5); list.add(3); list.add(1);
        return list;
    }

    // 버블 정렬
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        boolean swap = false;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swap = true;
                    Collections.swap(list, j, j + 1);
                }
            }
            if (swap == false)  break;
        }
        return list;
    }

    // 선택 정렬
    static ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        //int min, minIdx;
        //-- 변수 2개 안쓰고 그냥 idx로 저장해놓고, 교환해주면 됨
        int minIdx;
        for (int i = 0; i < list.size(); i++) {
            //min = list.get(i);
            minIdx = i;
            //for (int j = i; j < list.size(); j++) {
            //-- min에 i 넣어놨으니 i부터 시작할 필요 없음
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIdx)) {
                    //min = list.get(j);
                    minIdx = j;
                }
            }
            Collections.swap(list, i, minIdx);
        }
        return list;
    }

    static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (list.get(j) < list.get(j - 1))
                    Collections.swap(list, j, j - 1);
                else
                    break;
            }
        }
        return list;
    }

    public static void main (String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        setOriginalList(list);
        System.out.print("원래버전   → ");
        for(int x : list)
            System.out.print(x + " ");
        System.out.print("\n버블정렬 후 → ");
        for(int x : bubbleSort(list))
            System.out.print(x + " ");
        System.out.println(); System.out.println();

        setOriginalList(list);
        System.out.print("원래버전   → ");
        for(int x : list)
            System.out.print(x + " ");
        System.out.print("\n선택정렬 후 → ");
        for(int x : selectionSort(list))
            System.out.print(x + " ");
        System.out.println(); System.out.println();

        setOriginalList(list);
        System.out.print("원래버전   → ");
        for(int x : list)
            System.out.print(x + " ");
        System.out.print("\n삽입정렬 후 → ");
        for(int x : insertionSort(list))
            System.out.print(x + " ");
        System.out.println(); System.out.println();
    }
}
