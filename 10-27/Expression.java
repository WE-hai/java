public class Expression {
	public static void main(String[] args) {
	System.out.println(1==1&2==2);
	//&&  || 短路特性  & |是且或的意思，但不短路
	
	int a = -13;
	System.out.println(a);
	System.out.println(a<<1);
	System.out.println(a>>1);
	System.out.println(a>>>1);
	
	int n = 137;
	System.out.println((n>>2)&0x7);
	//得到2-4位
	
	}
}