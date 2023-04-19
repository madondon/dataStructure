package Algorithm.Sort.InternalSort;


import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(insertion(array)));
    }

    private static int[] insertion(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int arrayLength = array.length;

        for (int i = 1; i < arrayLength; i++) {
            int current = array[i];
            int preIndex = i -1;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;

        }

        return array;
    }
}