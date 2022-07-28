import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Connection connect(String urlConexao) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    urlConexao);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        Connection connection = connect(urlConexao);

        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE Cliente " +
                    "(ID INTEGER PRIMARY KEY autoincrement," +
                    " Nome           CHAR(50)    NOT NULL, " +
                    " Idade          INTEGER    NOT NULL, " +
                    " cpf            CHAR(14)   NOT NULL, " +
                    " rg             CHAR(14)   NOT NULL) ";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        Connection connection = connect(url_conexao);

        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO Cliente (Nome, Idade, cpf, rg) " +
                    "VALUES" +
                    " ('" + cliente.getNome() + "','" + cliente.getIdade() + "','" + cliente.getCpf() + "','" + cliente.getRg() + "');";

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        Connection connection = connect(urlConexao);

        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente;");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                Integer idade = resultSet.getInt("idade");
                String cpf = resultSet.getString("cpf");
                String rg = resultSet.getString("rg");
                System.out.println("ID : " + id);
                System.out.println("Nome : " + nome);
                System.out.println("Idade : " + idade);
                System.out.println("CPF: " + cpf);
                System.out.println("RG : " + rg);
                System.out.println();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        Connection connection = connect(urlConexao);
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String sql = "UPDATE Cliente set nome = '" + name + "', idade = " + idade + " where ID=" + id + ";";
            statement.executeUpdate(sql);
            connection.commit();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        Connection connection = connect(urlConexao);
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String sql = "DELETE from Cliente where ID="+id+";";
            statement.executeUpdate(sql);
            connection.commit();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}

