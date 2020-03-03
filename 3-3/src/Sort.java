import java.util.Arrays;

public class Sort {
    //插入排序：时间O(n)~O(n^2)    空间：O(1)
    //希尔排序：时间O(n^1.3) (适用于无序)  空间：O(1)
    //选择排序：时间稳定O(n^2) 时间性能最差  稳定性能保证
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //向下调整
    public static void shiftDown(int[] arr,int parent,int sz) {
        int child = 2*parent+1;
        while (child < sz) {
            if (child+1 < sz && arr[child+1] > arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            } else {
                break;
            }
        }
    }
    //堆排序：基于堆结构 时间复杂度O(nlogn)   空间：O(1)  稳定性：不稳定，会破坏相对位置
    //1.建堆O(n) (升序排序：递增  建大堆--->向下调整)
    //2.排序   交换
    public static void heapSort(int[] arr) {
        for (int i = (arr.length-1)/2;i >= 0;i--) {
            shiftDown(arr,i,arr.length);
        }/*
        int end = arr.length-1;
        while (end > 0) {
            swap(arr, 0, end);
            shiftDown(arr, 0, end);
            end--;
        }*/
        for (int end = arr.length-1;end >= 0;end--) {
            swap(arr,0,end);
            shiftDown(arr,0,end);
        }
    }

    //冒泡排序：升序   重要
    //时间复杂度：O(n^2)  最好：+标记O(n) 最坏：O(n^2)
    //稳定性：稳定   空间复杂度：O(1)
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            len--;
        }
    }

    public static void bubbleSort2(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            boolean flag = true;
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            len--;
        }
    }

    //快速排序：重要
    //1.递归：找基准值----->找到的大小交换(从后找)----->相遇------>与基准值交换
    //2.非递归
    public static int partition1(int[] arr,int left,int right) {
        int k = arr[left];
        int start = left;
        while (left < right) {
            while (left < right && arr[right] >= k) {
                right--;
            }
            while (left < right && arr[left] <= k) {
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,left,start);
        return left;
    }

    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int mid = partition1(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public static void main(String[] args) {

        int[] arr = {12,34,4,1,5,23,9,3,17,6,2};
        System.out.println("原数组："+Arrays.toString(arr));
        heapSort(arr);
        System.out.println("堆排序："+Arrays.toString(arr));
        int[] arr2 = arr.clone();
        bubbleSort(arr2);
        System.out.println("冒泡排序："+Arrays.toString(arr2));
        int[] arr3 = arr.clone();
        bubbleSort2(arr3);
        System.out.println("冒泡排序2："+Arrays.toString(arr3));
        int[] arr4 = arr.clone();
        quickSort(arr4,0,arr4.length-1);
        System.out.println("快速排序："+Arrays.toString(arr4));
        int[] arr5 = arr.clone();
        Arrays.sort(arr5);
        System.out.println("系统排序："+Arrays.toString(arr5));
    }
}
