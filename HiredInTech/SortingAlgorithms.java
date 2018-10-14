package HiredInTech;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class SortingAlgorithms {
    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        bubbleSort(unsorted);
        printArray(unsorted);
        Integer[] unsorted2 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        insertionSort(unsorted2);
        printArray(unsorted2);
        Integer[] unsorted3 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        selectionSort(unsorted3);
        printArray(unsorted3);
        Integer[] unsorted4 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        shellSort(unsorted4);
        printArray(unsorted4);
        Integer[] unsorted5 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        tdMergeSort(unsorted5);
        printArray(unsorted5);
        Integer[] unsorted6 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        buMergeSort(unsorted6);
        printArray(unsorted6);
        Integer[] unsorted7 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        quickSort(unsorted7);
        printArray(unsorted7);
        Integer[] unsorted8 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        quick3way(unsorted8);
        printArray(unsorted8);
        Integer[] unsorted9 = new Integer[]{1, 3, 2, 8, 5, 7, 4};
        heapSort(unsorted9);
        printArray(unsorted9);
    }
    //Bubblesort
    private static void bubbleSort(Comparable[] arr) {
        int n = arr.length;
        while (n > 0) {
            int newN = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    newN = i;
                }
            }
            n = newN;
        }
    }

    // Insertion sort
    private static void insertionSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    // Selection sort
    private static void selectionSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[iMin]) < 0) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                swap(arr, i, iMin);
            }
        }
    }

    // Shellsort
    private static void shellSort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3) h = h*3 + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j].compareTo(arr[j - h]) < 0) {
                        swap(arr, j - h, j);
                    }
                }
            }
            h /= 3;
        }
    }

    private static void buMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        int n = arr.length;
        for (int sz = 1; sz < n; sz = 2*sz) {
            for (int lo = 0; lo < n - sz; lo += 2*sz) {
                merge(arr, lo, lo + sz -1, Math.min(lo+sz+sz-1, n-1), aux);
            }
        }
    }

    private static void tdMergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        tdMergeSort(arr, 0, arr.length - 1, aux);
    }

    private static void tdMergeSort(Comparable[] arr, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        tdMergeSort(arr, lo, mid, aux);
        tdMergeSort(arr, mid + 1, hi, aux);
        merge(arr, lo, mid, hi, aux);
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi, Comparable[] aux) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i <= mid && (j > hi || aux[i].compareTo(aux[j]) < 0)) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    // Quicksort
    private static void quickSort(Comparable[] arr) {
        Collections.shuffle(Arrays.asList(arr));
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j-1);
        quickSort(arr, j+1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable pivot = arr[lo];
        while (true) {
            while (arr[++i].compareTo(pivot) < 0) if (i == hi) break;
            while (arr[--j].compareTo(pivot) > 0) if (j == lo) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    // Quicksort 3 way
    private static void quick3way(Comparable[] arr) {
        Collections.shuffle(Arrays.asList(arr));
        quick3way(arr, 0, arr.length - 1);
    }

    private static void quick3way(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable pivot  = arr[lo];
        while (i <= gt) {
            int cmp = arr[i].compareTo(pivot);
            if (cmp < 0) swap(arr, lt++, i++);
            else if (cmp > 0) swap(arr, i, gt--);
            else i++;
        }
        quick3way(arr, lo, lt - 1);
        quick3way(arr, gt + 1, hi);
    }

    // Heapsort
    private static void heapSort(Comparable[] arr) {
        PriorityQueue<Comparable> minQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minQueue.add(arr[i]);
        }

        int i = 0;
        while (!minQueue.isEmpty()) {
            arr[i] = minQueue.poll();
            i++;
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static void printArray(Comparable[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
