import java.util.Scanner;
public class Prime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数：");
		int n = scanner.nextInt();
		int i = 2;
		for(i = 2;i < n;i++) {
			if(n % i == 0) {
				System.out.println(n+"不是素数");
				break;
			} 
		}
		if(n == i) {
			System.out.println(n+"是素数");
		}
		
	}
}