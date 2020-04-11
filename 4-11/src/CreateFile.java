import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File file = new File("Main.txt");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        file.createNewFile();
        System.out.println("文件创建成功");
    }
}
