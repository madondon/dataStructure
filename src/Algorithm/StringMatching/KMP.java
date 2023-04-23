package Algorithm.StringMatching;

public class KMP {
    public static int kmp(String s, String p) {
        int n = s.length(), m = p.length();
        int[] match = new int[m];
        match[0]=-1;
        for (int j = 1; j < m; j++) {
            int i=match[j-1];
            while (i >= 0 && p.charAt(i+1) != p.charAt(j))  // 在模式串中寻找前缀和后缀的最长公共部分
                i = match[i];
            if (p.charAt(i+1) == p.charAt(j))  // 如果匹配成功，更新match数组
                match[j]=i+1;
            else  // 如果匹配失败，则将match[j]设置为-1
                match[j]=-1;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) j = match[j - 1]+1; // 在匹配过程中，利用match数组跳过已经匹配过的字符
            if (s.charAt(i) == p.charAt(j)) j++; // 如果匹配成功，继续往后匹配
            if (j == m) return i - m + 1; // 匹配成功，返回匹配的起始位置
        }
        return -1; // 匹配失败
    }

    public static void main(String[] args) {
        String s = "ababcabcacbab";
        String p = "abcab";
        int index = kmp(s, p); // 调用kmp函数进行匹配
        if (index == -1) {
            System.out.println("S中不包含P");
        } else {
            System.out.println("P在S中的起始位置为：" + index);
        }
    }
}

