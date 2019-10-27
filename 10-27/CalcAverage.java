//求平均值
public class CalcAverage {
	public static void main (String[] args) {
        int sum = 0;
		for(int i=0;i<args.length;i++){
		    sum += Integer.parseInt(args[i]);
		}
		double avg = 0;
		avg = sum/args.length;
		System.out.println(avg);
	}
}
		
		