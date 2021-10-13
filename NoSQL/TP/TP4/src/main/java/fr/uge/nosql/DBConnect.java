package fr.uge.nosql;

import java.sql.*;
import java.util.Properties;

public class DBConnect {
    private final String pack;
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;


    public DBConnect(String pack, String address, String username, String password) {
        this.pack = pack;
        this.url = address;
        this.username = username;
        this.password = password;

    }
    public void connexion() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet doRequest(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

}
