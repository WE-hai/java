class Bike {
	
	String color;
	int speed;
	int maxSpeeed;
	
	Bike() {
		color = "black";
		speed = 0;
		maxSpeeed = 200;
	}
	
	Bike(String color,int speed,int maxSpeeed) {
		this.color = color;
		this.speed = speed;
		this.maxSpeeed = maxSpeeed;
	}
	
	void setColor(String color) {
		this.color = color;
	}
	
	String getColor() {
		return color;
	}
	
	int jiaSpeed(){
		while(true) {
			speed += 10;
			if(speed < maxSpeeed) {
				return maxSpeeed;
			} 
			return speed;
		}	
	}	
}

public class Test{
	public static void main(String[] args) {
		Bike bike = new Bike("blue",10,200);
		//System.out.println(jiaSpeed());
		System.out.println(bike.getColor());
	}
}