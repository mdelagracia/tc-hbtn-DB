import java.sql.*;

public class ConnectionSQLite {
    public static void main(String[] args) {
        initConnection();
    }

    public static void initConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexao = DriverManager.getConnection(
                    "jdbc:sqlite:sqlite_database_2022.db");
            conexao.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}