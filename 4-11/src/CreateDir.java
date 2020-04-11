import java.io.File;
import java.util.Scanner;

public class CreateDir {
    public static void main(String[] args) {
        File file = new File("a");
        File file1 = new File("B/a");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        file.mkdir();
        file1.mkdirs();
        System.out.println("文件夹创建成功");
    }
}
