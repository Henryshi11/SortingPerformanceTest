package algorithms;

import java.util.ArrayList;

public class QuickSort {
    public static void sort(ArrayList<Integer> list, int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(list, begin, end);

        sort(list, begin, partitionIndex - 1);
        sort(list, partitionIndex + 1, end);
    }
}

private static int partition(ArrayList<Integer> list, int begin, int end) {
    int pivot = list.get(end);
    int i = (begin - 1);

    for (int j = begin; j < end; j++) {
        if (list.get(j) <= pivot) {
            i++;

            int swapTemp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, swapTemp);
        }
    }

    int swapTemp = list.get(i + 1);
    list.set(i + 1, list.get(end));
    list.set(end, swapTemp);

    return i + 1;
}

    
}
