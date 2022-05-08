package org.example.CA1.DAO;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.impl.StaticMarkerBinder;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConnetctionPool {
    private static final BasicDataSource ds = new BasicDataSource();
    private static final String dbURL = "jdbc:mysql://localhost:3306/IEMDB";
    private static final String dbUsername = "IEMDB";
    private static final String dbPassword = "1234";
    static {
        try {
            Class.forName("org.example.CA1.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        ds.setUsername(dbUsername);
        ds.setPassword(dbPassword);
        ds.setUrl(dbURL);
        ds.setMinIdle(5);
        ds.setMaxIdle(15);
        ds.setMaxOpenPreparedStatements(100);
        setEncoding();
    }
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    private static void setEncoding() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("ALTER DataBASE IEMDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
