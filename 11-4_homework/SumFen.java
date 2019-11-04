public class SumFen {
	public static void main(String[] args) {
		double m = 0;
		double n = 0;
		for(int i = 1;i < 100;i = i+2) {
			m += 1.0/i;
		}
		for(int j = 2;j <= 100;j = j+2) {
			n += 1.0/j;
		}
		System.out.println(m-n);
	}
}