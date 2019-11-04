import java.util.Scanner;

public class WeiShu {
	public static void weiShu(int n) {
		if(n < 10) {
			System.out.println(n);
		} else {
			int m = n/10;
			weiShu(m);
			System.out.println(n%10);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数：");
		int n = scanner.nextInt();
		weiShu(n);
	}
}