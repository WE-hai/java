import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchStudent {
    private static DataSource dataSource;

    public static void main(String[] args) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("stu");
        mysqlDataSource.setCharacterEncoding("utf8");
        mysqlDataSource.setUseSSL(false);

        dataSource = mysqlDataSource;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = scanner.nextLine();

            findStudent(name);
        }
    }

    private static void findStudent(String name) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = String.format(
                    "SELECT id, name FROM stu WHERE name = '%s'", name
            );

            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery(sql)) {
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                    }
                    System.out.println("=====================");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}