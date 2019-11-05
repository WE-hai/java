import java.util.Scanner;

public class Print {
	public static void print(int n) {
		if(n < 10) {
			System.out.println(n);
		} else {
			int m = n%10;
			print(n/10);
			System.out.println(m);
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int n = scanner.nextInt();
		print(n);
		
	}
}