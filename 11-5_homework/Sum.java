import java.util.Scanner;

public class Sum {
	public static int sum(int n) {
		if(n > 0) {
			return n + sum(n-1);
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数：");
		int n = scanner.nextInt();
		int ret = sum(n);
		System.out.println(ret);
	}
}
	