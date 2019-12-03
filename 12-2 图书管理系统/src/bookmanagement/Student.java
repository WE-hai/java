package bookmanagement;

import java.util.Scanner;

public class Student extends User {
    @Override
    public void menu() {
        System.out.println("1、借书");
        System.out.println("2、还书");
        System.out.println("3、现有量查询");
    }

    @Override
    public void operation(int select) {
        switch (select) {
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                listBooks();
                break;
                default:
                    System.out.println("输入错误");
                    break;
        }
    }

    private void listBooks() {
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] books = bookShelf.getBooks();
        System.out.println("书名, 当前数量, 总数");
        for (Book book : books) {
            System.out.println(book.title + ", " + book.currentCount + ", " + book.totalCount);
        }

    }

    private void returnBook() {
        System.out.println("请输入书名：");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] books = bookShelf.getBooks();
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.currentCount++;
            }
        }
        System.out.println("还书成功！");
    }

    private void borrowBook() {
        System.out.println("请输入书名：");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] books = bookShelf.getBooks();
        for (Book book : books) {
            if (book.title.equals(title)) {
                if (book.currentCount > 0) {
                    book.currentCount--;
                    System.out.println("借书成功！");
                    return;
                } else {
                    System.out.println("没有这本书！");
                    return;
                }
            }
        }
        System.out.println("没这本书！");
    }
}
