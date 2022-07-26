import java.sql.*;

public class ConnectionSQLite {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       try {
           Class.forName("org.sqlite.JDBC");
           Connection conexao = DriverManager.getConnection(
                   "jdbc:sqlite:sqlite_database_2022.db");

           System.out.println("Conectado!");
           conexao.close();
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }
}
