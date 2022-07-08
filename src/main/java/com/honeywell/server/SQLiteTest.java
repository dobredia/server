package com.honeywell.server;

import java.sql.*;

public class SQLiteTest {

    public static Connection conn;
    public static boolean hasData = false;

    public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
        if (conn == null) getConnection();

        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery("SELECT fName, lName from user");

        return res;

    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:sqliteSimulatorAtm.db");

    }



    public void addUser(String firstname, String lastName) throws ClassNotFoundException, SQLException {

        if (conn == null) {
            getConnection();
        }

        PreparedStatement prep =  conn.prepareStatement("INSERT INTO user values(?,?,?);");
        prep.setString(2,firstname);
        prep.setString(3,lastName);
        prep.execute();
    }
}

