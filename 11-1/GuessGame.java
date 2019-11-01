import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	public static int selectDifficult() {
		System.out.println("1. 简单");
		System.out.println("2. 中等");
		System.out.println("3. 地狱");
		Scanner scanner = new Scanner(System.in);
		int difficult = scanner.nextInt();
		scanner.nextLine();
		
		return difficult;
	}
	
	public static int generateRandom(int difficult) {
		Random random = new Random();
		switch (difficult) {
			case 1: return random.nextInt(50);
			case 2: return random.nextInt(100);
			case 3: return random.nextInt(150);
		}
		
		return -1;
	}
	
	public static int generateTimes(int difficult) {
		Random random = new Random();
		switch (difficult) {
			case 1: return 10;
			case 2: return 5;
			case 3: return 3;
		}
		
		return -1;
	}
	
	public static boolean guess(int r) {
		System.out.println("请输入数字:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		if (n == r) {
			return true;
		} else if (n < r) {
			System.out.println("猜小了");
		} else {
			System.out.println("猜大了");
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// 1. 难度选择
		int difficult = selectDifficult();
		// 2. 生成随机数
		int r = generateRandom(difficult);
		//System.out.println("DEBUG: 随机数是: " + r);
		int times = generateTimes(difficult);
		//System.out.println("DEBUG: 猜的次数是: " + times);
		// 3. 循环 x 次机会
		boolean success = false;
		for (int i = 0; i < times; i++) {
			// 4. 读取用户的输入并且给出合适的提示
			success = guess(r);
			//System.out.println("DEBUG: 上次猜的结果是: " + success);
			if (success) {
				break;
			}
		}
		
		// 5. 根据用户的猜测的结果，给出游戏最终结果
		if (success) {
			System.out.println("你真聪明");
		} else {
			System.out.println("你真笨");
		}
	}
	
	/*
	public static void main(String[] args) {
		/**
			随机生成一个数 n:	[0, 100)
			用户有 4 次猜的机会
			如果用户的输入比 n 大: 告诉用户大了
			如果用户的输入比 n 小: 告诉用户小了
			否则: 成功退出
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎进入猜数字的游戏");
		System.out.println("请稍后，生成数字中...");
		int n = random.nextInt(100);
		System.out.println("数字已生成");
		int times = 4;
		System.out.println("您有 " + times + " 次机会");
		for (int i = 1; i <= times; i++) {
			System.out.print("> ");
			int x = scanner.nextInt();
			if (x == n) {
				System.out.println("猜测成功，用了 " + i + " 次机会");
				return;
			} else if (x < n) {
				System.out.println("第 " + i + " 次猜测，您猜的数字小了");
			} else {
				System.out.println("第 " + i + " 次猜测，您猜的数字大了");
			}
		}
		System.out.println("很遗憾，Game Over");
		System.out.println("数字其实是 " + n);
	}
	*/
}