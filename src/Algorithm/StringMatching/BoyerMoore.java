package Algorithm.StringMatching;

import java.util.Arrays;

public class BoyerMoore {
    private static final int ALPHABET_SIZE = 256;

    public static int boyerMoore(String s, String p) {
        int n = s.length(), m = p.length();
        int[] last = new int[ALPHABET_SIZE];
        Arrays.fill(last, -1);
        for (int i = 0; i < m; i++) {
            last[p.charAt(i)] = i;
        }
        for (int i = m - 1, j; i < n; ) {
            for (j = m - 1; j >= 0 && s.charAt(i) == p.charAt(j); i--, j--);
            if (j < 0) return i + 1;
            int x = last[s.charAt(i)];
            i += j - x;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ababcabcacbab";
        String p = "abcab";
        int index = boyerMoore(s, p); // 调用boyerMoore函数进行匹配
        if (index == -1) {
            System.out.println("S中不包含P");
        } else {
            System.out.println("P在S中的起始位置为：" + index);
        }
    }
}
