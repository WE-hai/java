import java.util.Arrays;
import java.util.Stack;

public class Sort {
    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //霍尔法
    public static int partition1(int[] arr,int left,int right) {
        int key = arr[left];
        int start = left;
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,left,start);
        return left;
    }

    //挖坑法:
    public static int partition2(int[] arr,int left,int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    //前后遍历法
    public static int partition3(int[] arr,int left,int right) {

        int mid = getMid(arr,left,right);
        swap(arr,left,right);

        int key = arr[left];
        //prev ：最后一个小于key的位置 cur：下一个小于key的值
        int cur = left+1;
        int prev = left;
        while (cur <= right) {
            if (arr[cur] < key && prev++ != cur) {
                swap(arr,prev,cur);
            }
            cur++;
        }
        swap(arr,left,prev);
        return prev;
    }

    //快速排序：递归实现
    //时间复杂度：平均O(nlogn)  最坏：O(n^2)（没有优化之前）
    //Arrays.sort();  Collection
    //稳定性：不稳定  基准值位置进行交换的时候有可能改变相同元素的相对位置
    //空间复杂度：O(logn)
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            //int mid = partition1(arr, left, right);
            //int mid = partition2(arr,left,right);
            int mid = partition3(arr,left,right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
    //快速排序：非递归实现  不存在栈溢出的问题
    //时间复杂度：O(nlogn)
    //稳定性：不稳定
    //空间复杂度：O(logn)
    //模拟递归算法：1、选基准值
    // 2、划分（根据基准值分组）
    // 3、给划分的小组数据继续重复1、2
    public static void quickSort2(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        Stack<Integer> stack = new Stack<>();

        if (left < right) {
            stack.push(left);
            stack.push(right);
        }
        while (!stack.isEmpty()) {
            int right1 = stack.pop();
            int left1 = stack.pop();
            int mid = partition2(arr,left1,right1);
            if (mid-1 > left1) {
                stack.push(left1);
                stack.push(mid-1);
            }
            if (mid+1 < right1) {
                stack.push(mid+1);
                stack.push(right1);
            }
        }
    }

    //三数取中法：解决栈溢出问题
    public static int getMid(int[] arr,int left,int right) {
        int mid = (left+right)/2;
        if (arr[mid] > arr[left]) {
            if (arr[mid] < arr[right]) {
                return mid;
            } else {
                if (arr[left] > arr[right]) {
                    return left;
                } else {
                    return right;
                }
            }
        } else {
            if (arr[mid] > arr[right]) {
                return mid;
            } else {
                if (arr[left] < arr[right]) {
                    return left;
                }  else {
                    return right;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {15,1,6,2,9,13,7,22,9,43,36,4,18};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = arr.clone();
        quickSort2(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
