package 青蛙跳台阶;

public class Main {
    //转移方程 f(i) = f(i-1)+f(i-1) = 2*f(i-1)
    //初始状态：f（1） = 1
    //返回值：f(n)
    public int jump(int target) {
        int ret = 1;
        for (int i = 2;i <= target;i++) {
            ret *= 2;
        }
        return ret;
    }

    public int jumpFloor(int target) {
        return 1 << (target-1);
    }

    //递归
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
