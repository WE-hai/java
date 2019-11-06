import java.util.Arrays;

public class Array {
	
	public static void swap(int[] arr,int i,int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		
	}
	
	public static void bubbleSort(int[] arr) {
		int t = 0;
		for(int i = 0;i < arr.length-1;i++) {
			for(int j = 0;j < arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		
	}
	
	public static void bubbleSort2(int[] arr) {
		for(int i = 0;i < arr.length-1;i++) {
			for(int j = 1;j < arr.length-i;j++) {
				if(arr[j-1] > arr[j]) {
					swap(arr,j-1,j);
				}
			}
		}
		
	}
	public static int binarySearch(int[] arr,int a){
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while(left <= right) {
				mid = (left + right)/2;
				if(a > arr[mid]) {
					left = mid + 1;
					
				} else if(a < arr[mid]) {
					right = mid - 1;
					
				} else {
					return mid;
				}	
			}
			return -1;			
	}
	
	public static int[] copyOf(int[] a, int newLength) {
		int[] arr = new int[newLength];
		int length = Math.min(a.length,newLength);
		for(int i = 0;i < length;i++) {
			arr[i] = a[i];
		}
		return arr;
	}		
	
	public static int[] copyOfRange(int[] a,int from,int to) {
		int ret[] = new int[to - from];
		for(int i = 0;i < to-from;i++) {
			ret[i] = a[from];
			from++;
		}
		return ret;
	}
	
	public static void fill(int[] a,int val) {
		for(int i = 0;i < a.length;i++) {
			a[i] = val;
		}			
	}
	
	public static void fill2(int[] a,int from,int to,int val) {
		for(int i = from;i < to;i++) {
			a[i] = val;
		}
	}
	
	public static boolean epuals(int[] a,int[] b) {
		if(a.length != b.length) {
			return false;
		} 
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {6,5,2,3,7,8,1};
		int[] arr2 = {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(arr1));
		bubbleSort(arr1);
		bubbleSort2(arr1);
		int x = binarySearch(arr2,3);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr1));
		
		System.out.println(x);
		
		System.out.println(Arrays.toString(copyOf(arr1,4)));
		
		System.out.println(Arrays.toString(copyOfRange(arr1,2,5)));
		fill(arr1,5);
		System.out.println(Arrays.toString(arr1));
		fill2(arr2,2,4,4);
		System.out.println(Arrays.toString(arr2));
		System.out.println(epuals(arr1,arr2));
		
	}
}