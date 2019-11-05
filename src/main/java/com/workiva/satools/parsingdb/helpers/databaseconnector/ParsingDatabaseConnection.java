package com.workiva.satools.parsingdb.helpers.databaseconnector;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParsingDatabaseConnection {
    private final String connectionString = "jdbc:mysql://sa-tools-test-aurora.cdsa0kvhqzyp.us-east-1.rds.amazonaws.com:3306/DataModeler";
    private final String user = "SAToolsMaster";
    private final String password = "SAToolsPassword";
    private final String mysql_driver = "com.mysql.jdbc.Driver";

    public Connection GetDatabaseConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(mysql_driver).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(connectionString, user, password);
    }
}