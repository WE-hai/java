public class StringInpool {
    public static void main(String[] args) {
        String s = "hello";
        String b = "hello";
        String p = new String(s);
        p = s.intern();
        System.out.println(s.equals(p));
    }

}
