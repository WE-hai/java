public class Book {
	String bookName;
	String writer;
	double price;
	String name;
	String publisher;
	
	Book() {
		bookName = "abc";
		writer = "d";
		price = 30;
	}
	public Book(String bookName,String writer,double price,String publisher) {
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;
	}
	
	public static void main(String[] args) {
		Book book = new Book("abc","A",10,"AAB");
		System.out.println(book.bookName);
		System.out.println(book.price);
	}
}