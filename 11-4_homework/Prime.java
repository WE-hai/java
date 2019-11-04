
public class Prime {
	// public static void PrimeNumber() {
		
	// }
	public static void main(String[] args) {
		boolean flag = false;
		for(int i = 2;i <= 100;i++) {
			for(int j = 2;j < i;j++) {
				if(i%j == 0) {
					flag = true;
				}
			}
			if(flag == false) {
				System.out.printf("%d ",i);
			}
			flag = false;	
		}		
	}
}