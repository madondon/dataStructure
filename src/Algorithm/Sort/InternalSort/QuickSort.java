package Algorithm.Sort.InternalSort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {6,8, 1, 4, 9, 0, 3, 5, 2, 7};
        System.out.println("原始数组：" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后数组：" + Arrays.toString(array));

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = start;
        while (start < end) {
            while (start < end && arr[end] >= arr[pivot]) {
                end--;
            }
            while (start < end && arr[start] <= arr[pivot]) {
                start++;
            }
            if(arr[start]!=arr[end])
                swap(arr,start,end);
        }
        if(arr[start]!=arr[pivot])
            swap(arr,start,pivot);
        return start;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}