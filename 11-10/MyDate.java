import java.util.Scanner;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	private static final int[] DAY_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	private static boolean leapYear(int year) {
		if((year%4 == 0 && year%100 != 0)||year%400 == 0) {
			return true;
		}
		return false;
	}
	
	public static int getDayOfMonth(int year,int month) {
		if(month != 2) {
			return DAY_OF_MONTH[month - 1];
		}  
		if(leapYear(year)) {
			return 29;
		} else {
			return 28;
		}
	}
	
	public MyDate() {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public MyDate(int year,int month,int day) {
		if(year < 1970) {
			System.out.println("不支持年份！");
			return;
		}
		if(month > 12||month < 1) {
			System.out.println("不支持月份！");
			return;
		}
		if(day < 1||day > getDayOfMonth(year,month)) {
			System.out.println("不支持天数！");
			return;
		}
		this.year = year;
		this.month = month;
		this.day = day;

	}
	
	@Override
	public String toString() {
		return String.format("%04d-%02d-%02d",year,month,day);
	}
	
		public void addDays(int days) {
		day += days;
		while(day > getDayOfMonth(year,month)) {
			day -= getDayOfMonth(year,month);
			month += 1;
			if(month > 12) {
				year += 1;
				month = 1;
			}
		}
	}
	
	public void subDays(int days) {
		day -=days;
		while(day <= 0) {
			month -= 1;
			if(month == 0) {
				year -=1;
				month = 12;
			}
		}
		day += getDayOfMonth(year,month);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份：");
		int y = scanner.nextInt();
		System.out.println("请输入月份：");
		int m = scanner.nextInt();
		System.out.println("请输入日：");
		int d = scanner.nextInt();
	    MyDate date = new MyDate(y,m,d);
		System.out.println("***********************");
		System.out.println("****  1、增加天数  ****");
		System.out.println("****  2、减少天数  ****");
		System.out.println("***********************");
		System.out.println("请输入选择：");
		int input = scanner.nextInt();
		switch(input) {
			case 1:
				System.out.println("请输入增加的天数：");
				int a = scanner.nextInt();
				date.addDays(a);
				System.out.println(date);
				break;
			case 2:
				System.out.println("请输入减少天数：");
				int b = scanner.nextInt();
				date.subDays(b);
				System.out.println(date);
				break;
			default:
				break;
		}
	}
}