import java.util.Arrays;

public class Array {
	// public static int[] createArray(int n) {
		// return new int[n];
	// }
	
	public static int max(int[] a) {
		int m = a[0];
		for(int i = 1;i < a.length;i++) {
			if(a[i] > m) {
				m = a[i];
			}
		}
		return m;
	}
	
	public static double average(int[] a) {
		int avg = 0;
		int sum = 0;
		for(int i = 0;i < a.length;i++) {
			sum += a[i];
		}
		avg = sum/a.length;
		return avg;
	}
	
	public static int indexOf(int[] a,int n) {
		for(int i = 0;i < a.length;i++) {
			if(n == a[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static int lastIndexOf(int[] a,int n) {
		for(int i = a.length - 1;i >= 0;i--) {
			if(n == a[i]) {
				return i;
			}
		}
		return -1;
		//int m = 0
		// for(int i = 0;i < a.length;i++) {
			// if(n == a[i]) {
				// m = i;
			// }
		// }
		//return m;
	}
	
	public static int[] copy(int[] a,int from,int to) {
		int[] b = new int[to - from];
		for(int i = from;i < to;i++) {
			b[i - from] = a[i];
		}
		return b;
	}
	
	public static void swap(int[] a,int i,int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void main(String[] args) {
		int[] a = { 1,2,8,4,5,6,2,7,2,9 };
		System.out.println(max(a));
		System.out.println(average(a));
		System.out.println(indexOf(a,2));
		System.out.println(lastIndexOf(a,2));
		System.out.println(copy(a,2,7));
		System.out.println(Arrays.toString(a)); 
		
		// for(int v:a) {
			// System.out.println(v);
			
		//}
		
	}
}