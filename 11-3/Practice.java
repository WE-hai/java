public class Practice{
	public static void printNumber(int n) {
		if(n < 10) {
			System.out.printf("%d ",n);
		} else {
			int m = n/10;
			printNumber(m);
			int a = n%10;
			System.out.printf("%d ",a);
		}
			
	}
	
	public static int sumNumber(int n) {
		if(n < 10) {
			return n;
		} else {
			int m = n/10;
			int a = n%10;
			int h = sumNumber(m);
			int sum = a + h;
			return sum;
		}
	}
	
	public static void hanoi(int n,int from,int to) {
		if(n == 1) {
			System.out.printf("从%d移动到%d\n",from,to);
		} else {
			int other = 3-from-to;
			hanoi(n-1,from,other);
			System.out.printf("1从%d移动到%d\n",from,to);
			hanoi(n-1,other,to);
		}
	}
	public static void main(String[] args) {
		printNumber(9578);
		System.out.println(sumNumber(789));
		hanoi(4,0,2);
	}
}