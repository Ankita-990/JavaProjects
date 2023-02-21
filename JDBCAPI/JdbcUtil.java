import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class JdbcUtil
{
    private JdbcUtil(){}

    public static Connection geJdbcConnection() // factory method
    {
        // resources used in Jdbc Appication
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        Properties props = new Properties();

        FileInputStream fis = new FileInputStream("/workspace/JavaProjects/JDBCAPI/jdbc.properties");
        props.load(fis);

        // Establishing the connection
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException
    {
        // closing the resources
        if(resultSet != null)
            resultSet.close();
        if(statement != null)
            statement.close();
        if(connection != null)
            connection.close();
    }
}