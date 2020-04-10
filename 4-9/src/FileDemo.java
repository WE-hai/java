import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        testFile("F:\\比特\\java-code\\java_work\\4-9\\Main.java");
        System.out.println("===========================");
        testFile("F:\\比特\\java-code\\java_work\\4-9\\NoSuchFile.java");
        System.out.println("===========================");
        testFile("F:\\比特\\java-code\\java_work\\4-9");
    }

    private static void testFile(String path) {
        File file = new File(path);
        System.out.println(file);

        // 属性的方法
        System.out.println("路径对应的文件是否存在: " + file.exists());
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("父结点: " + file.getParent());
        System.out.println("文件名称: " + file.getName());
        System.out.println("路径: " + file.getPath());
        // 判断是否是文件夹
        System.out.println("是文件夹么: " + file.isDirectory());
        System.out.println("是普通文件么: " + file.isFile());
        // 其他的一些属性
        System.out.println("是隐藏文件么: " + file.isHidden());
        System.out.println("是绝对路径么: " + file.isAbsolute());
        System.out.println("是否有权限读: " + file.canRead());
        System.out.println("是否有权限写: " + file.canWrite());
        System.out.println("是否有权限执行: " + file.canExecute());
    }
}
