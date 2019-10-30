public class WhileDemo {
	public static void main (String[] args) {
		
		int n  = 5;
		int sum = 0;
		int m = 1;
		for(int i = 1;i <= n;i++) {     //i的作用域
			m *= i;
			sum += m;
		}
		System.out.println(sum);	
		
	}
}
