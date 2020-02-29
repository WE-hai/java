import java.util.Arrays;

public class MySort {
    //希尔排序  是插入排序的改进
    //gap = 2 or 3的倍数
    //1.选择排序的性能和数据的顺序有关：数据越接近有序，时间复杂度越低
    //2.让数据逐渐接近有序
    //时间复杂度O(n)~O(n^2)
    //稳定性：不稳定
    //空间复杂度：常数空间O(1)
    public static void shellSort(int[] arr) {
        //分组：逻辑分组
        //对分组数据进行插入排序
        //同一组数据，之间的间隔不一定是1
        int gap = arr.length;
        while (gap > 1) {
            gap = gap/3+1;
            //i表示已经排序的最后一个位置
            for (int i = 0;i < arr.length-gap;i++) {
                int end = i;
                int key = arr[end+gap];
                while (end >= 0 && arr[end] > key) {
                    arr[end+gap] = arr[end];
                    end -= gap;
                }
                arr[end+gap] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,23,31,-3,1,5,13,16,25,2};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
    }
}
