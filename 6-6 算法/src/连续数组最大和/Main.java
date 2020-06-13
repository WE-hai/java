package 连续数组最大和;

public class Main {
    //转移方程：f(i) = max(f(i-1)+arr[i],arr[i])
    //状态：f（i）以第i个元素结尾的最大连续和
    //初始状态：f(0) = arr[0]
    //返回值：max(f(i))
    public int sumPartArray(int[] array) {
        int maxSum = array[0],curSum = array[0];
        for (int i = 1;i < array.length;i++) {
            curSum = Math.max(curSum+array[i],array[i]);
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
