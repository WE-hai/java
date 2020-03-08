import java.sql.*;
import java.util.Scanner;


public class JBDC {
    /*
    1.注册驱动Driver
    2.从DriverManage获取MySQL的网络连接
    3.开始语句的执行循环
    4.关闭之前获取的MySQL网络连接
    */

    private static String ip;
    private static int port;
    private static String user;
    private static String password;
    private static String defaultDatabase;

    private static void parseArgs(String[] args) {
        ip = args[0].substring(2);
        port = Integer.parseInt(args[1].substring(2));
        user = args[2].substring(2);
        defaultDatabase = args[4];
        System.out.print("Enter password: ");
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println(ip);
        System.out.println(port);
        System.out.println(user);
        System.out.println(password);
        System.out.println(defaultDatabase);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //parseArgs(args);

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url,"root","");

        //System.out.println(connection);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("mysql> ");
            String sql = scanner.nextLine();
            if (sql.trim().isEmpty()) {
                continue;
            }
            if (sql.equalsIgnoreCase("quit")) {
                break;
            }
            /*
            //Statement stmt = connection.createStatement();
            //int n = stmt.executeUpdate(sql);
            //System.out.println("受到影响的行数是："+n);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            //取到结果的基元信息
            ResultSetMetaData metaData = rs.getMetaData();
            int columCount = metaData.getColumnCount();
            for (int i = 0;i < columCount;i++) {
                String columName = metaData.getCatalogName((i+1));
                System.out.println(columName+" ");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 0;i < columCount;i++) {
                    String value = rs.getString(i+1);
                    System.out.println(value+" ");
                }
                System.out.println();
            }
            rs.close();
            statement.close();
        }
        connection.close();
    }
}
*/
            Statement statement = connection.createStatement();

            String firstWord = sql.split(" ")[0];
            if (firstWord.equalsIgnoreCase("select")
                    || firstWord.equalsIgnoreCase("show")
                    || firstWord.equalsIgnoreCase("desc")) {
                // 有结果的 SQL
                executeSQLWithResult(statement, sql);
            } else {
                // 没有结果的 SQL
                executeSQLWithoutResult(statement, sql);
            }

            statement.close();
        }

        // 4. 关闭连接
        connection.close();
    }

    private static void executeSQLWithoutResult(Statement statement, String sql) throws SQLException {
        int 受到影响的行数 = statement.executeUpdate(sql);
        System.out.println("受到影响的行数是: " +  受到影响的行数);
    }

    private static void executeSQLWithResult(Statement statement, String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        // 取到结果集元信息
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            String columnName = metaData.getColumnName(i + 1);
            System.out.print(columnName + " ");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {
                String value = rs.getString(i + 1);
                System.out.print(value + " ");
            }
            System.out.println();
        }

        rs.close();
    }
}