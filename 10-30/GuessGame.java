import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	public static void main (String[] args) {
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	int n = random.nextInt(100);
	int times = 10;
	for(int i = 1;i <= times;i++) {	
		System.out.print("请输入要猜的数字：");
		int x = scanner.nextInt();
		if(x == n) {
			System.out.println("猜测成功，用了"+i+"次机会");
			return;
		} else if(x < n) {
			System.out.println("第"+i+"次机会，猜小了");
		} else {
			System.out.println("第"+i+"次机会，猜大了");
		}
	}
	System.out.println("Game Over");
	System.out.println("数字是："+n);
	}
}