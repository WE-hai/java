public class Mytime {
	
	private int hour;
	private int minute;
	private int second;
	
	Mytime() {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	Mytime(int hour,int minute,int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		if(second >= 60||second < 0) {
			System.out.println("秒数错误");
			return;
		}
		if(minute >= 60||minute < 0) {
			System.out.println("分钟错误");
			return;
		}
		if(hour >= 24||hour < 0) {
			System.out.println("小时错误");
			return;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%d：%d：%d",hour,minute,second);
	}
	
	public void add(int seconds) {
		if(seconds < 0) {
			System.out.println("秒数错误");
			return;
		}
		second += seconds;
		while(second >= 60) {
			second -= 60;
			minute += 1;
			if(minute >= 60) {
				hour += 1;
				minute = 01;
			}	
			if(hour >= 24) {
				hour = 0;
			}
		}
	}

	public void sub(int seconds) {
		second -= seconds;
		while(second < 0) {
			minute -= 1;
			if(minute < 0) {
				hour -= 1;
				minute = 59;
			}
			if(hour < 0) {
				hour = 23;
			}
			second += 60;
		}
	}
	
	public static void main(String[] args){
		Mytime t = new Mytime(15,1,35);
		System.out.println(t);
		t.add(45);
		System.out.println(t);
		t.sub(45);
		System.out.println(t);
	}
}	