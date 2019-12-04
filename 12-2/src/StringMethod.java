import java.io.UnsupportedEncodingException;

public class StringMethod {
    private static boolean Number(String s) {
        for(char c : s.toCharArray()) {
            //if (!Character.isDigit(c)) {
            //    return false;
            //}
            if (c < '0'||c >'9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] s = "中国人".getBytes("GB18030");

    }
}
