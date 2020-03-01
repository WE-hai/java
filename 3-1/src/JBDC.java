import java.sql.*;
import java.util.Scanner;

public class JBDC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/boke?useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("mysql> ");
            String sql = scanner.nextLine();
            if (sql.equals("quit")) {
                break;
            }
            Statement statement = connection.createStatement();
            if (sql.startsWith("select")) {
                ResultSet rs = statement.executeQuery(sql);
                int col = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    for (int i = 1;i <= col;i++) {
                        String result = rs.getString(i);
                        System.out.print(result+" ");
                    }
                    System.out.println();
                }
                rs.close();
            } else {
                int n = statement.executeUpdate(sql);
                System.out.printf("%d行受到影响%n",n);
            }
            statement.close();
        }
        connection.close();
    }
}
