public class MaxMin{
	public static void main(String[] args){
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int c = Integer.parseInt(args[2]);
	int tmp = 0;
	int max = 0;
	int min = 0;
	if(a<b){
		tmp = a;
		a = b;
		b = tmp;
	}
	if(a<c){
		tmp = a;
		a = c;
		c = tmp;
	}
	if(b<c){
		tmp = b;
		b = c;
		c = tmp;
		min = c;
	}
	max = a;
	min = c;
	System.out.println("max="+max);
	System.out.println("min="+min);
	}
}