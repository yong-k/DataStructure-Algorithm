package dataStructure;

import java.util.ArrayList;
import java.util.Collections;

public class T013_binarySearch {
    static boolean binarySearch(ArrayList<Integer> list, Integer searchedItem) {
        if (list.size() == 1 && list.get(0) == searchedItem)
            return true;
        if (list.size() == 1 && list.get(0) != searchedItem)
            return false;
        if (list.size() == 0)
            return false;

        int medium = list.size() / 2;

        if (searchedItem == list.get(medium))
            return true;
        else {
            if (searchedItem < list.get(medium))
                return binarySearch(new ArrayList<Integer>(list.subList(0, medium)), searchedItem);
            else
                return binarySearch(new ArrayList<Integer>(list.subList(medium, list.size())), searchedItem);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            list.add((int)(Math.random() * 100));

        Collections.sort(list);
        System.out.println(binarySearch(list, 7));
    }
}

