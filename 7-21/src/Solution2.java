public class Solution2 {
    public  int moreThanHaIfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int target = array[0];
        int times = 1;
        for (int i = 0;i < array.length;i++) {
            if (times == 0) {
                target = array[i];
                times = 1;
            }
            if (target == array[i]) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0;i < array.length;i++) {
            if (target == array[i]) {
                times++;
            }
        }
        return times > array.length/2 ? target : 0;
    }
}
