import java.io.File;

public class Delete {
    public static void main(String[] args) {
        File file = new File("a");
        file.delete();  //删除文件与文件夹都用delete()

        file.deleteOnExit();//程序结束后删除
    }
}
