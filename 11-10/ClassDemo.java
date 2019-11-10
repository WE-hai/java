
class Person {
	//一个文件中允许定义多个类，但是只能有一个public修饰的类，文件名为public修饰的类名
	String name;
	int age;
	
	//普通方法
	void sayHello(String target) {
		System.out.println(name+" say hello to "+target);
	}
	//构造方法   （）
	public Person() {
		this.name = name;
		this.age = age;
	}
	//构造方法   （String，int）
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name) {
		this("name",12);
	}
}
	
public class ClassDemo {
	/*
	public static Person createPerson(String name,int age) {
		Person p = new Person();
		p.name = name;
		p.age = age;
		return p;
	}
	*/
	
	public static void main(String[] args) {
			
			//引用没有参数列表的构造方法
			Person p = new Person("name");
			//引用有两个参数的参数列表的构造方法
			//Person q = new Person("w",18);
			//引用成员变量
			p.name = "a";
			//引用方法
			p.sayHello("b");
			System.out.println(p.age);
			
	}
}