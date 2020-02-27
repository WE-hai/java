import java.util.Arrays;

public class HeapDemo {
    //注意二叉树后序遍历（if……else……）
    //堆：完全二叉树（数组存放）
    //向下调整：建堆、排序    小堆
    //parent = (child-1)/2  child = parent*2+1      child2 = parent*2+2
    //向上调整：大堆
    //子结构如果不是大堆：
    //问题：1.无法确定需要调整多少次
    //      2.无法确定调整后是否为大堆
    //小堆/非堆结构-----> 大堆：
    //1.首先调整子结构，让子结构变成大堆 从最小的树开始（最后一个非叶子结点） (n-2)/2     n是个数
    //2.在已经调整好的结构上继续调整更大的结构
    //3.直到调整到根节点就结束
    //向下调整的次数与非叶子节点有关

     //向下调整     一次向下调整最坏时间复杂度：log(n)
    public static void shiftDown(int[] arr,int sz,int parent) {
        int child = 2 * parent + 1; //左孩子
        while (child < sz) {
            //右孩子
            if (child + 1 < sz && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[child] > arr[parent]) {
                swap(arr,child,parent);
                //更新，继续向下调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                //不需要调整
                break;
            }
        }
    }

     public static void swap(int[] arr,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
     }

     public static void shiftDownSmall(int[] arr,int sz,int parent) {
         int child = 2 * parent + 1; //左孩子
         while (child < sz) {
             //右孩子
             if (child + 1 < sz && arr[child + 1] < arr[child]) {
                 child++;
             }
             if (arr[child] < arr[parent]) {
                 swap(arr,child,parent);
                 //更新，继续向下调整
                 parent = child;
                 child = 2 * parent + 1;
             } else {
                 //不需要调整
                 break;
             }
         }
     }

     public static void createHeap(int[] arr) {
        for (int i = (arr.length - 2)/2;i >= 0;i--) {
            shiftDown(arr,arr.length,i);
        }
     }

     public static void createHeapSmall(int[] arr) {
         for (int i = (arr.length - 2)/2;i >= 0;i--) {
             shiftDownSmall(arr,arr.length,i);
         }
     }

     //向上调整
    public static void shiftUp(int[] arr,int sz,int child) {
        int parent = (child - 1)/2;
        while (child > 0) {
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void shiftUpSmall(int[] arr,int sz,int child) {
        int parent = (child - 1)/2;
        while (child > 0) {
            if (arr[child] < arr[parent]) {
                swap(arr, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public static void createHeapUp(int[] arr) {
        for (int i = (arr.length - 2)/2;i >= 0;i--) {
            shiftUp(arr,arr.length,i);
        }
    }

    public static void createHeapSmallUp(int[] arr) {
        for (int i = (arr.length - 2)/2;i >= 0;i--) {
            shiftUpSmall(arr,arr.length,i);
        }
    }

     public static void main(String[] args) {
         int[] arr = {9,3,10,15,4,2,7,23,43};
         int[] copy = arr.clone();
         System.out.println(Arrays.toString(arr));
         createHeap(arr);
         System.out.println(Arrays.toString(arr));
         createHeapSmall(copy);
         System.out.println(Arrays.toString(copy));
         System.out.println();
         createHeapSmallUp(copy);
         System.out.println(Arrays.toString(copy));
         createHeapUp(arr);
         System.out.println(Arrays.toString(arr));
     }
 }
