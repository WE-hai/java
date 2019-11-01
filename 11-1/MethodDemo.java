import java.util.Scanner;
public class MethodDemo{
	//只有这能定义方法
	
	public static int add(int a,int b) {
	int r = a + b;
	return r;
	}
	public static double sub(double a,double b) {
	return a-b;
	}
	
	public static int fac(int n) {
		int m = 1;
		for(int i = 1;i <= n;i++) {
			m *= i;
		}
		return m;
	}
	public static int sum(int n) {
		int sum = 0;
		for(int i = 1;i <= n;i++) {
			sum += fac(i);
		}
		return sum;
	}
	public static long facdg(int n) {
		if(n == 1){
			return 1;
		} else {
		return n*facdg(n-1);
	}
	
	public static long fib(int n) {
		if(n ==0||n ==1) {
			return 1;
		} else {
			return fib(n-1)+fib(n-2);
		}
		
	}
	public static void main (String[] args) {
		// int sum = add(2,7);
		// double s = sub(4,3);
		// System.out.println(s);
		// System.out.println(sum);
		System.out.print("请输入一个数：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//int ret = 0;
		//ret = sum(n);
		//ret = facdg(n);
		long ret = fib(n);
		System.out.println(ret);
	}
}