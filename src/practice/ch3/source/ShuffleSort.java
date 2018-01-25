package practice.ch3.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShuffleSort {
    public static void luckSort(ArrayList<String> strings, Comparator<String> comparator) {

        while(isNotSorted(strings, comparator)) {
            Collections.shuffle(strings);
        }
    }

    private static boolean isNotSorted(ArrayList<String> strings, Comparator<String> comparator) {
        for (int i = 0, j = 1; j < strings.size(); i++, j++) {
            if (comparator.compare(strings.get(i), strings.get(j)) > 0) {
                return true;
            }
        }
        return false;
    }
}
