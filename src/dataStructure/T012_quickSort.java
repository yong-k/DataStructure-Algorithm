package dataStructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class T012_quickSort {
    static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        if (list.size() <= 1)
            return list;
        int pivot = list.get(0);
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > pivot)
                rightList.add(list.get(i));
            else
                leftList.add(list.get(i));
        }

        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(quickSort(leftList));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(quickSort(rightList));

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            list.add((int)(Math.random() * 100));
        System.out.println(quickSort(list));
    }
}