import java.util.Arrays;

public class Sort {
    //排序：
    //稳定性：相同元素的相对位置保持不变 eg：12，4，6a，7，9，6b，13    排序后：4，6a，6b，7，9，12，13
    //冒泡、快速排序面试多

    //直接插入排序：升序 最坏：O(n^2)--->逆序   最好：O(n)----->顺序
    //稳定性：稳定的   空间复杂度：常数空间O(1)
    public static void insertSort(int[] arr) {
        //开始第0，排好序
        for (int i = 0;i < arr.length-1;i++) {
            int key = arr[i+1];
            //从i位置表示已排序数据的最后一个位置
            int end = i;
            while (end >= 0 && arr[end] > key) {
                    //把大的向后
                    arr[end+1] = arr[end];
                    //继续向前搜索
                    end--;
            }
            //end = -1 or end <= key的位置
            arr[end+1] = key;
        }
    }

    public static void insertSort2(int[] arr) {
        for (int i = 1;i < arr.length;i++) {
            //i:下一个待排序的位置
            int key = arr[i];
            //end：已排序数据的最后一个位置
            int end = i-1;
            while (end >= 0 && arr[end] > key) {
                arr[end+1] = arr[end];
                end--;
            }
            arr[end+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,9,3,2,10,34,54,0,8,14};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        //insertSort(arr);
        //System.out.println(Arrays.toString(arr));
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
    }
}
