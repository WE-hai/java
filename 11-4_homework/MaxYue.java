import java.util.Scanner;

public class MaxYue {
	public static int maxYue(int x,int y) {
		if(x == y) {
			return x;
		} else if(x > y) {
			for(int i = y;i > 1;i--) {
				if(y%i == 0 && x%i == 0) {
					return i;
				}
			}
		} else {
			for(int j = x;j > 1;j--) {
				if(x%j == 0 && y%j == 0) {
					return j;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入两个数：");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int ret = maxYue(x,y);
		System.out.println("最大公约数是："+ret);
	}
}