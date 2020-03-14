import java.util.*;

public class Solution {
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            /*
            Integer n = map.get(num);
            if (n == null) {
                map.put(num,1);
            } else {
                n++;
                map.put(num,n);
            }
            */
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for (char ch : S.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    //旧键盘
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String right = scanner.nextLine();
        String wrong = scanner.nextLine();
        Set<Character> wrongSet = new HashSet<>();
        for (char ch : wrong.toCharArray()) {
            wrongSet.add(ch);
        }
        Set<Character> printSet = new HashSet<>();
        for (char ch : right.toCharArray()) {
            if (!wrongSet.contains(ch)) {
                ch = Character.toUpperCase(ch);
                if (!printSet.contains(ch)) {
                    printSet.add(ch);
                    System.out.print(ch);
                }
            }
        }
        System.out.println();
    }
}
