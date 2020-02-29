import java.util.Arrays;

public class ChooseSort {
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //选择排序
    //时间复杂度：O(n^2)  无优化可能性
    //稳定性：可以稳定（可控）、可不稳定
    //空间复杂度：O(1)
    public static void selectSort(int[] arr) {
        //i表示未排序的最大位置
        for (int i = arr.length-1;i > 0;i--) {
            int end = i;
            int max = i;
            //从
            for (int j = end-1;j >= 0;j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr,max,end);
        }
    }

    public static void selectSort2(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            int min = begin;
            int max = end;
            for (int i = begin; i <= end; i++) {
                //最小选前面
                if (arr[i] < arr[min]) {
                    min = i;
                }
                //最大选后面
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            swap(arr, begin, min);
            //如果最大位置在初始位置，经过上次的交换之后，最大位置被移动到min指向的位置
            if (max == begin) {
                max = min;
            }
            swap(arr, end, max);
            begin++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {62,43,32,5,12,7,4,6,9,1,28,39,10};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        selectSort2(copy);
        System.out.println(Arrays.toString(copy));
    }
}
