package algorithms;

import java.util.ArrayList;

public class MergeSort {
    public static void sort(ArrayList<Integer> list, int l, int r) {
    if (l < r) {
        // Find the middle point
        int m = l + (r - l) / 2;

        sort(list, l, m);
        sort(list, m + 1, r);

        merge(list, l, m, r);
    }
}

private static void merge(ArrayList<Integer> list, int l, int m, int r) {
    // sizes of two sublists
    int n1 = m - l + 1;
    int n2 = r - m;

    ArrayList<Integer> L = new ArrayList<>(n1);
    ArrayList<Integer> R = new ArrayList<>(n2);

    for (int i = 0; i < n1; ++i)
        L.add(i, list.get(l + i));
    for (int j = 0; j < n2; ++j)
        R.add(j, list.get(m + 1 + j));


    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
        if (L.get(i) <= R.get(j)) {
            list.set(k, L.get(i));
            i++;
        } else {
            list.set(k, R.get(j));
            j++;
        }
        k++;
    }

    while (i < n1) {
        list.set(k, L.get(i));
        i++;
        k++;
    }

    while (j < n2) {
        list.set(k, R.get(j));
        j++;
        k++;
    }
}

    
}
