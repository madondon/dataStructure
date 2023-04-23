package Algorithm.StringMatching;

public class BF {
    public static int bf(String s, String p) {
        int n = s.length(), m = p.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // 匹配成功，返回匹配的起始位置
            }
        }
        return -1; // 匹配失败
    }

    public static void main(String[] args) {
        String s = "ababcabcacbab";
        String p = "abcab";
        int index = bf(s, p); // 调用bf函数进行匹配
        if (index == -1) {
            System.out.println("S中不包含P");
        } else {
            System.out.println("P在S中的起始位置为：" + index);
        }
    }
}
