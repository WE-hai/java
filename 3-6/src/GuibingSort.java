import java.util.Arrays;

public class GuibingSort {
    //归并排序
    //先分组(分解)，在合并
    //空间复杂度：O(n)
    //递归实现
    public static void mergeSort(int[] arr,int left,int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        //先对小组数据进行排序
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        //小组数据有序，才能合并
        int[] tmp = new int[arr.length];
        mergeInternal(arr,left,mid,right,tmp);

    }

    public static void mergeInternal(int[] arr, int left, int mid, int right,int[] tmp) {
        int begin1 = left,end1 = mid;
        int begin2 = mid+1,end2 = right;
        int idx = left;
        while (begin1 <= end1 && begin2 <= end2) {
            if (arr[begin1] < arr[begin2]) {
                tmp[idx++] = arr[begin1++];
            } else {
                tmp[idx++] = arr[begin2++];
            }
        }
        while (begin1 <= end1) {
            tmp[idx++] = arr[begin1++];
        }
        while (begin2 <= end2) {
            tmp[idx++] = arr[begin2++];
        }
        for (int i = left;i <= right;i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,32,23,12,7,3,9,26,17,8,5,14};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
