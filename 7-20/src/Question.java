import java.util.Arrays;

public class Question {
    //数组中排序，奇数在前偶数在后，并且保持相对位置不变
    public static void sort(int[] arr) {
        int k = 0;
        for (int i = 0;i < arr.length;i++) {
            if ((arr[i] & 1) == 1) {
                int tmp = arr[i];
                int j = i;
                while (j > k) {
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[k++] = tmp;
            }
        }
    }
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void reOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int k = 0;
        for (int i = 0;i < arr.length;i++) {
            if ((arr[i]&1) == 1) {
                int tmp = arr[i];
                int m = i;
                while (k < m) {
                    arr[m] = arr[m-1];
                    m--;
                }
                arr[k++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,9,5,8};
        int[] arr1 = {10,3,6,7,9,5,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        reOrderArray(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
