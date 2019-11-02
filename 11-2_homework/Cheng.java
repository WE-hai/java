import java.util.Scanner;

public class Cheng {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入一个数：");
		int n = scanner.nextInt();
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= i;j++) {
				System.out.printf("%d*%d=%d\t",j,i,i*j);
			}
			System.out.println("");
		}
	}
}