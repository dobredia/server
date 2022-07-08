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
        initialise();
    }

    private void initialise() throws SQLException {

        Statement state2 = conn.createStatement();
        state2.execute("CREATE TABLE user(id integer," +
                "fName varchar(60), " +
                "lName varchar(60)," +
                "primary key(id) );");
       /*if (!hasData) {
            hasData = true;


            if (!res.next()) {
                System.out.println("Building the User table with pre-populated values.");
                // need to build the table
                Statement state2 = conn.createStatement();
                state2.execute("CREATE TABLE user(id integer," +
                        "fName varchar(60), " +
                        "lName varchar(60)," +
                        "primary key(id) );");

                // inserting some sample data
                PreparedStatement prep2 = conn.prepareStatement("INSERT INTO user values (?,?,?)");
                prep2.setString(2, "John");
                prep2.setString(3, "Smith");
                prep2.execute();
            }

            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery("SELECT fName, lName FROM sqlite_master WHERE type='table' AND name = 'user' ");

        }*/
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

