import java.io.*;
import java.util.Scanner;

public class Scanner分割 {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                }
            }
        }
    }
}
