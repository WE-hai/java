public class Solution {
    //字符串替换%20
    public static String replaceString(StringBuilder sb) {
        int count = 0;
        for (int i = 0;i < sb.length();i++) {
            if (sb.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = sb.length()+2*count;
        int oldIndex = sb.length()-1;
        int newIndex = newLength-1;
        sb.setLength(newLength);
        while (oldIndex >= 0 && newIndex >= 0) {
            if (sb.charAt(oldIndex) == ' ') {
                sb.setCharAt(newIndex--,'0');
                sb.setCharAt(newIndex--,'2');
                sb.setCharAt(newIndex--,'%');
                oldIndex--;
            } else {
                sb.setCharAt(newIndex,sb.charAt(oldIndex));
                newIndex--;
                oldIndex--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("We are happy");
        System.out.println(s.toString());
        System.out.println(replaceString(s));
        String str = "We Are Happy";
        System.out.println(str.replace(" ","%20"));
    }
}
