package 数组中出现了一次的数字;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void func(int[] arr){
        Map<Integer,Integer> map = new TreeMap<>();
        for (Integer n : arr) {
            int k = map.getOrDefault(n,0);
            map.put(n,k+1);
        }
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
            if (m.getValue()%2 == 1) {
                System.out.print(m.getKey()+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            func(arr);
        }
    }
}