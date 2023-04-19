package Algorithm.Sort.InternalSort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(shell(array)));
    }

    private static int[] shell(int[] origin) {
        int len = origin.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int temp = origin[i];
                int j = i - gap;
                while (j >= 0 && origin[j] > temp) {
                    origin[j + gap] = origin[j];
                    j -= gap;
                }
                origin[j + gap] = temp;
            }
        }
        return origin;
    }
}
