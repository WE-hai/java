import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void test1() {
        int[] arr = {1,9,3,2,10,34,54,0,8,14};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(arr));
        //insertSort(arr);
        //System.out.println(Arrays.toString(arr));
        Sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        MySort.shellSort(copy);
        System.out.println(Arrays.toString(arr));
    }

    public static void test2() {
        Random ran = new Random(2020022911);
        int number = 100000;
        int[] arr = new int[number];
        for (int i = 0;i < number;i++) {
            arr[i] = ran.nextInt();
        }
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

        long begin = System.nanoTime();
        Sort.insertSort(arr);
        long end = System.nanoTime();
        System.out.printf("insertSort time: %.4fms\n",(end-begin)*1.0/1000/1000);

         begin = System.nanoTime();
         MySort.shellSort(arr2);
         end = System.nanoTime();
         System.out.printf("shellSort time: %.4fms\n",(end-begin)*1.0/1000/1000);

        begin = System.nanoTime();
        ChooseSort.selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time: %.4fms\n",(end-begin)*1.0/1000/1000);

    }

    public static void main(String[] args) {
        test2();
    }
}
