import java.util.Scanner;

public class Scanner {
	public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
	while (scanner.hasNext()) {
		//String s = scanner.nextLine();//  \n
		String s = scanner.next();  //\n  /  \t
		System.out.println(s);
		}
	}
}