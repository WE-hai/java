public class JavaPractice {
	public static void main(String[] args) {
	//System.out.println(args[0]);
	//System.out.println(args[1]);
	//System.out.println(args[2]);
	//System.out.println(args.length);
	//在命令中传参
	
	
	String action = "你好";
	String target = "世界";
	String message = action+target;
	System.out.println(message);
	
	if(args.length<2){
		System.out.println("请输入两个数：");
		return;
	}
	int x = Integer.parseInt(args[0]);
	int y = Integer.parseInt(args[1]);
	int result = x + y;
	System.out.println(""+x+"+"+y+"="+result);
	System.out.print(""+x+"+"+y+"="+result);
	Syetem.out.printf("%d+%d=%d\n",x,y,result);
	
	final int x ;
	x = 6;
	System.out.println(x);
	
	
	String s = "123";
	System.out.println(Integer.parseInt(s));
	System.out.println(Long.parseLong(s));
	System.out.println(Double.parseDouble(s));
	
	int x = 45;
	long y = 98L;
	double z = 3.1415;
	float a = 8.09f;
	System.out.println(String.valueOf(x));
	System.out.println(String.valueOf(y));
	System.out.println(String.valueOf(z));
	System.out.println(String.valueOf(a));
	
	
	}
}
