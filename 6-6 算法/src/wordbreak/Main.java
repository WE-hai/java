package wordbreak;

import java.util.Set;

public class Main {
    //状态f(i):前i个字符能否被分割
    //转移方程：f(i): j < i && f(j) && [j+1,i]能否在词典中找到
    //初始状态：辅助状态：f(0),true
    //返回值：f(n)
    public boolean workBreak(String s, Set<String> dict) {
        boolean[] arr = new boolean[s.length()+1];
        arr[0] = true;
        for (int i = 1;i <= s.length();i++) {
            for (int j = i-1;j >= 0;j--) {
                if (arr[j] && dict.contains(s.substring(j,i))) {
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[s.length()];
    }
}
