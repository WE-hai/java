public class Swap{
	public static void main(String[] args){
		int tmp = 0;
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("");
		tmp = a;
		a = b;
		b =tmp;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}