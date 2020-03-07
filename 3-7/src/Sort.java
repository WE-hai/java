import java.util.Arrays;

public class Sort {
    public static void mergeInternal(int[] arr, int left, int mid, int right,int[] tmp) {
        int begin1 = left,end1 = mid;
        int begin2 = mid+1,end2 = right;
        int idx = left;
        while (begin1 <= end1 && begin2 <= end2) {
            //<= 稳定
            //< 不稳定
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

    //归并排序
    //递归实现
    //时间复杂度：O(nlog)
    //空间复杂度：O(n)
    //稳定性：稳定
    public static void mergeSort(int[] arr,int left,int right,int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        //先对小组数据进行排序
        mergeSort(arr, left, mid,tmp);
        mergeSort(arr, mid+1, right,tmp);
        //小组数据有序，才能合并
        tmp = new int[arr.length];
        mergeInternal(arr,left,mid,right,tmp);
    }

    public static void merge(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,tmp);
    }

    //非递归实现
    public static void mergeSort2(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 1;i < arr.length;i *= 2) {
            for (int j = 0;j < arr.length;j += 2*i) {
                //mergeInternal(arr,j,j+i-1,j+2*i-1,tmp);
                int left = j;
                int mid = j+i-1;
                if (mid >= arr.length-1) {
                    continue;
                }
                int right = j + 2 * i - 1;
                if (right >= arr.length) {
                    right = arr.length-1;
                }
                mergeInternal(arr,left,mid,right,tmp);
            }
        }
    }

    //大数据的排序：外排序    借助外存进行排序，可借助归并排序的思想

    public static void main(String[] args) {
        int[] arr = {6,12,23,8,2,16,27,19,-1,5,11,8};
        int[] tmp = new int[arr.length];
        int[] arr0 = arr.clone();
        System.out.println(Arrays.toString(arr));
        mergeSort(arr0,0,arr.length-1,tmp);
        System.out.println(Arrays.toString(arr0));
        int[] arr1 = arr.clone();
        merge(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = arr.clone();
        mergeSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
