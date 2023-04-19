package Algorithm.Sort.InternalSort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] array = {329, 457, 657, 839, 436, 720, 355};
        System.out.println("原始数组：" + Arrays.toString(array));
        radixSort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int digitNum = 0;
        while (max > 0) {
            digitNum++;
            max /= 10;
        }

        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < digitNum; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digit = getDigit(arr[j], i);
                bucketArr.get(digit).add(arr[j]);
            }

            int index = 0;
            for (int j = 0; j < bucketArr.size(); j++) {
                ArrayList<Integer> bucket = bucketArr.get(j);
                for (int k = 0; k < bucket.size(); k++) {
                    arr[index++] = bucket.get(k);
                }
                bucket.clear();
            }
        }
    }

    private static int getDigit(int num, int digit) {
        return (int) (num / Math.pow(10, digit)) % 10;
    }
}
