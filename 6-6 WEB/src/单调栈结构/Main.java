package 单调栈结构;

import java.util.*;

public class Main {
    public static void PrintIndex(int[] arr,int count) {
        int[] A = new int[2];
        for(int i = 0;i < count;i++){
            if(i == 0){
                A[0] = -1;
            }
            if(i == count - 1){
                A[1] = -1;
            }
            int j = i;
            while(j >= 0 && j <= count - 1){
                j -= 1;
                if(j >= 0) {
                    if (arr[i] > arr[j]) {
                        A[0] = j;
                        break;
                    }
                } else {
                    A[0] = -1;
                }
            }
            j = i;
            while(j >= 0 && j <= count - 1){
                j += 1;
                if(j <= count - 1) {
                    if (arr[i] > arr[j]) {
                        A[1] = j;
                        break;
                    }
                }else {
                    A[1] = -1;
                }
            }
            System.out.println(A[0] + " " + A[1]);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for(int i = 0;i < count;i++){
            arr[i] = scanner.nextInt();
        }
        PrintIndex(arr,count);
    }
}
